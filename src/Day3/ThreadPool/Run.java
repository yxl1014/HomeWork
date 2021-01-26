package Day3.ThreadPool;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Run implements Runnable {
    private StringBuffer bytes;
    private File file = new File("/data/ThreadPoolTest.txt");

    public Run(StringBuffer bytes) {
        this.bytes = bytes;
    }

    @Override
    public void run() {
        if (!file.exists()) {
            try {
                System.out.println("没有此文件,正在新建文件...");
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            OutputStream out = new FileOutputStream(file, true);
            System.out.println("正在往文件内写入数据...");
            out.write(new String(bytes).getBytes("UTF-8"));
            System.out.println("写入成功...");
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}