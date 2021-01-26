package Day3.SocketTest;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class SocketDemo {
    public static void main(String[] args) throws IOException {
        int port = 18686;
        ServerSocket server = new ServerSocket(port);
        System.out.println("server正在监听访问请求...");
        while (true) {
            Socket socket = server.accept();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    byte[] bytes = new byte[1024];
                    InputStream in = null;//获取输入流
                    try {
                        in = socket.getInputStream();
                        StringBuffer sb = new StringBuffer();
                        int len;
                        while ((len = in.read(bytes)) != -1) {
                            sb.append(new String(bytes, 0, len, "UTF-8"));
                        }

                        System.out.println("server已经获取信息:" + sb.toString() + ",正在处理...");
                        sb.append(new String(",welcome!"));
                        System.out.println(sb.toString());

                        OutputStream out = socket.getOutputStream();//获取输出流
                        out.write(sb.toString().getBytes("UTF-8"));
                        System.out.println("数据返回成功");
                        out.flush();
                        out.close();
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        }
    }
}
