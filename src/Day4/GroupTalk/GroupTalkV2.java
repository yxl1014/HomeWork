package Day4.GroupTalk;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class GroupTalkV2 {
    private final static int PROCESS_NUM = 10;


    public static void start(int port) {
        try {
            Selector mainSelector = Selector.open();//启动指挥中心，类似于zookeeper
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();//启动服务器上下文，类似于new ServerSocket
            serverSocketChannel.configureBlocking(false);//设置为非阻塞
            serverSocketChannel.socket().setReuseAddress(true);//使服务器关闭时，端口可使用
            serverSocketChannel.bind(new InetSocketAddress(port), 128);//为channel绑定端口，和等待数

            //注册accept事件
            serverSocketChannel.register(mainSelector, SelectionKey.OP_ACCEPT);//将事物绑定到注册中心,及将channel绑定到selector他的事件类型为accept

            DispatchHandler[] handlers = new DispatchHandler[PROCESS_NUM];//新建一个事务处理的handler数组
            for (int i = 0; i < handlers.length; i++) {
                handlers[i] = new DispatchHandler();//给每一个地址创建实例对象
            }
//            for (DispatchHandler h : handlers) {
//                h = new DispatchHandler();
//            }

            int count = 0;//统计一共处理了多少事物
            int userid = 1;//为用户标上id
            //阻塞等待就绪事件
            while (mainSelector.select() > 0) {//等待事物请求，类似于serversocket.accept
                //SelectionKey是一个是我请求的包装，里面包含了事物的绝大多数信息
                Set<SelectionKey> keys = mainSelector.selectedKeys();//获取channel接受到事物包装的请求set
                Iterator<SelectionKey> iterator = keys.iterator();//新建一个迭代器，迭代接受到的事物

                //遍历就绪事件
                while (iterator.hasNext()) {//遍历接受到的事物
                    SelectionKey key = iterator.next();
                    iterator.remove();//删除迭代器中的该事物
                    if (key.isAcceptable()) {//是否可以获得事物
                        SocketChannel socketChannel = serverSocketChannel.accept();//接收
                        socketChannel.configureBlocking(false);//设置为非阻塞
                        handlers[count++ % PROCESS_NUM].addChannel(socketChannel, userid++);//调用之前初始化的处理事务的数组
                    }
                    keys.remove(key);//删除事物set中的该事物，说明处理完毕。
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static class DispatchHandler {

        private static Executor executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() << 1);//新建一个定长线程池来多线程处理事务
        private Selector selector;//为用户端事物新建注册中心
        private int userid;//该用户的id

        public DispatchHandler() throws IOException {
            selector = Selector.open();//打开注册中心，分配中心
            this.start();
        }

        public void addChannel(SocketChannel socketChannel, int userid) throws ClosedChannelException {
            this.userid = userid;
            socketChannel.register(selector, SelectionKey.OP_READ);//将该事物注册到注册中心
            this.selector.wakeup();//唤醒监听器监听
        }


        public void start() {
            executor.execute(new Runnable() {

                public void run() {
                    while (true) {
                        try {
                            selector.selectNow();//现在开始接受数据
                        } catch (Exception e) {

                        }
                        Set<SelectionKey> keys = selector.selectedKeys();//获取channel接受到事物包装的请求set
                        if (!keys.isEmpty()) {//set不是空开始操作
                            Iterator<SelectionKey> iterator = keys.iterator();//创建迭代器
                            if (iterator.hasNext()) {//迭代
                                SelectionKey key = iterator.next();
                                SocketChannel socketChannel = (SocketChannel) key.channel();
                                iterator.remove();
                                if (key.isReadable()) {
                                    try {
                                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                                        int cnt = 0;
                                        String msg = "";
                                        do {
                                            cnt = socketChannel.read(buffer);
                                            if (cnt > 0) {
                                                msg += new String(buffer.array());
                                            }
                                            buffer.clear();
                                        } while (cnt >= buffer.capacity());
                                        System.out.println("talkerid :" + userid + ", Time: " + new Date() + ", Say :" + msg);

                                        //回写数据
                                        ByteBuffer sendBuf = ByteBuffer.allocate(msg.getBytes().length + 1);
                                        sendBuf.put(msg.getBytes());
                                        socketChannel.write(sendBuf);

                                    } catch (Exception e) {
                                        e.printStackTrace();
                                        if (socketChannel != null) {
                                            try {
                                                socketChannel.close();
                                            } catch (Exception ex) {
                                                ex.printStackTrace();
                                            }
                                        }
                                    }
                                }
                                keys.remove(key);
                            }
                        }
                    }
                }
            });

        }
    }


    public static void main(String[] args) {
        GroupTalkV2.start(18686);
    }
}
