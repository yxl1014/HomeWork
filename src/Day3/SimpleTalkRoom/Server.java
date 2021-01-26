package Day3.SimpleTalkRoom;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss=new ServerSocket(12321);
        while(true){
            Socket socket=ss.accept();
            InputStream in=socket.getInputStream();
            OutputStream out=socket.getOutputStream();

            int len;
            byte[] bytes=new byte[512];
            StringBuffer stringBuffer=new StringBuffer();

            len=in.read(bytes);
            stringBuffer.append(new String(bytes,0,len,"UTF-8"));
            System.out.println(new Date()+" :"+stringBuffer);

            Scanner scanner=new Scanner(System.in);
            String str=scanner.nextLine();
            System.out.println(new Date()+" :"+str);
            out.write(str.getBytes("UTF-8"));
            out.flush();


            out.close();
            in.close();
            socket.close();
        }
    }
}
