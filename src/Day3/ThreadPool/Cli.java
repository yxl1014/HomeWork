package Day3.ThreadPool;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Cli {
    public static void main(String[] args) throws IOException {
        Socket socket = null;
        OutputStream out = null;
        try {
            socket = new Socket("localhost", 60000);
            out = socket.getOutputStream();
            String str = "aaaaaaaaaaa";
            out.write(str.getBytes("UTF-8"));
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            out.close();
            socket.close();
        }
    }
}
