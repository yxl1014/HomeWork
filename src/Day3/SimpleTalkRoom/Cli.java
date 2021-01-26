package Day3.SimpleTalkRoom;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class Cli {
    public static void main(String[] args) throws IOException {
        Socket socket=null;
        while (true){
            socket=new Socket("localhost",12321);
            InputStream in=socket.getInputStream();
            OutputStream out=socket.getOutputStream();

            int len;
            byte[] bytes=new byte[512];
            StringBuffer stringBuffer=new StringBuffer();

            Scanner scanner=new Scanner(System.in);
            String str=scanner.nextLine();
            out.write(str.getBytes("UTF-8"));
            out.flush();
            System.out.println(new Date()+" :"+str);

            len=in.read(bytes);
            stringBuffer.append(new String(bytes,0,len,"UTF-8"));
            System.out.println(new Date()+" :"+stringBuffer);

            out.close();
            in.close();
            socket.close();
        }
    }
}
