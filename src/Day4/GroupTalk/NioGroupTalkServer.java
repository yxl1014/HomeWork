package Day4.GroupTalk;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class NioGroupTalkServer {
    public static void start(int port) throws IOException {
        Selector mainSelector = Selector.open();//启动指挥中心，类似于zookeeper
        ServerSocketChannel mainChannel = ServerSocketChannel.open();//启动服务器上下文，类似于new ServerSocket
        mainChannel.configureBlocking(false);//设置为非阻塞
        mainChannel.socket().setReuseAddress(true);//使服务器关闭时，端口可使用
        mainChannel.bind(new InetSocketAddress(port), 128);//为channel绑定端口，和等待数

        //将事物绑定到注册中心,及将channel绑定到selector他的事件类型为accept，并定义操作载体NioGroupTalkServer.MainNioHandler
        mainChannel.register(mainSelector, SelectionKey.OP_ACCEPT, new NioGroupTalkServer.MainNioHandler(mainSelector, mainChannel));

        while (mainSelector.select() > 0) {//等待事物请求，类似于serversocket.accept
            //遍历就绪事件
            for (SelectionKey selectedKey : mainSelector.selectedKeys()) {
                mainSelector.selectedKeys().remove(selectedKey);//删除set中的该事物封装
                NioHandler handler = (NioHandler) selectedKey.attachment();//获得该事物的操作载体
                handler.handler();//执行
            }
        }
    }

    public static class MainNioHandler implements NioHandler {

        private Selector mainSelector;//注册中心
        private ServerSocketChannel mainChannel;//上下文
        private int talkid=1;

        public MainNioHandler(Selector mainSelector, ServerSocketChannel mainChannel) {
            this.mainChannel = mainChannel;
            this.mainSelector = mainSelector;
        }

        @Override
        public void handler() {
            try {
                SocketChannel talker = mainChannel.accept();//获取用户的socket
                talker.configureBlocking(false);//设置为非阻塞

                //将事物绑定到注册中心,及将channel绑定到selector他的事件类型为read，并定义操作载体NioGroupTalkServer.ThreadPoolGroupTalkSpace
                talker.register(mainSelector, SelectionKey.OP_READ, new NioGroupTalkServer.ThreadPoolGroupTalkSpace(talker,talkid++));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static class ThreadPoolGroupTalkSpace implements NioHandler {
        private SocketChannel talker;
        private int talkerid;
        private static Executor executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() << 1);//操作线程池

        public ThreadPoolGroupTalkSpace(SocketChannel talker,int talkerid) {
            this.talker = talker;
            this.talkerid=talkerid;
        }

        @Override
        public void handler() {
            executor.execute(new Talking(talker,talkerid));//在线程池中执行具体操作
        }
    }

    public static class Talking implements Runnable {

        private SocketChannel talker;

        private int talkerid;

        public Talking(SocketChannel talker,int talkerid) {
            this.talker = talker;
            this.talkerid=talkerid;
        }

        @Override
        public void run() {
            try {
                ByteBuffer buffer = ByteBuffer.allocate(1024);
                int cnt = 0;
                String msg = "";
                do {
                    cnt = talker.read(buffer);
                    if (cnt > 0) {
                        msg += new String(buffer.array());
                    }
                    buffer.clear();
                } while (cnt >= buffer.capacity());
                System.out.println("talkerid :"+talkerid+", Time: "+new Date()+", Say :" + msg);

                //回写数据
                ByteBuffer sendBuf = ByteBuffer.allocate(msg.getBytes().length + 1);
                sendBuf.put(msg.getBytes());
                talker.write(sendBuf);

            } catch (Exception e) {
                e.printStackTrace();
                if (talker != null) {
                    try {
                        talker.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        NioGroupTalkServer.start(18686);
    }
}
