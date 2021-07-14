package Day5.Er;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        Thread t = Thread.currentThread();
        while (Er.i.intValue() < Er.str.length()-2)
            synchronized (Er.str) {
                File file = new File("/data/test/aaa.txt");

                OutputStream out = null;
                try {

                    out = new FileOutputStream(file, true);
                    out.write(Er.str.substring(Er.i.intValue(), Er.i.intValue() + 1).getBytes(StandardCharsets.UTF_8));
                    Er.i.getAndIncrement();
                    out.flush();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        out.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
    }
}
