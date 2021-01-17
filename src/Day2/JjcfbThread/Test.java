package Day2.JjcfbThread;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        JjcfbThread jt=new JjcfbThread("/data/jjcfb.txt");
        jt.print();
        jt.close();
    }
}
