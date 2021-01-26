package Day3.SocketTest;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class CliDemo {
    public static void main(String[] args) throws IOException {
        String ip = "127.0.0.1";
        int port = 18686;
        Socket socket = new Socket(ip, port);
        OutputStream out = socket.getOutputStream();
        String str = "I am Lei";
        out.write(str.getBytes("UTF-8"));
        out.flush();
        System.out.println("数据发送成功");

        byte[] bytes = new byte[1024];
        StringBuffer sb = new StringBuffer();
        InputStream in = socket.getInputStream();
        int len;
        while ((len = in.read(bytes)) != -1) {
            sb.append(new String(bytes, 0, len, "UTF-8"));
        }
        System.out.println("数据接受成功");
        sb.append(new String(bytes));

        //System.out.println(sb.toString());
        System.out.println(sb.toString());

        out.close();
        in.close();
        socket.close();
    }
}
