package Day3.ThreadPool;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

public class Demo {
    public static void main(String[] args) throws IOException {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        ServerSocket server = new ServerSocket(60000);
        while (true) {
            System.out.println("监听中...");
            Socket socket = server.accept();
            InputStream in = socket.getInputStream();
            StringBuffer sb = new StringBuffer();
            int len;
            byte[] bytes = new byte[1024];
            System.out.println("读书数据中...");
            len = in.read(bytes);
            sb.append(new String(bytes, 0, len, "UTF-8"));
            System.out.println("数据读入成功...");
            threadPool.submit(new Run(sb));
            in.close();
            socket.close();
        }
    }
}
