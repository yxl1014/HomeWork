package Day5.Er;

import java.util.concurrent.atomic.AtomicInteger;

public class Er {
    static String str=new String("李哥说什么都对");
    //static int i=0;
    static AtomicInteger i=new AtomicInteger(0);
    public static void main(String[] args) throws InterruptedException {
        System.out.println(str+ i);
        Thread t1=new Thread(new MyRunnable());
        Thread t2=new Thread(new MyRunnable());
        Thread t3=new Thread(new MyRunnable());
        t1.start();
        t2.start();
        t3.start();
        Thread.sleep(5000);
        System.out.println(str);
    }
}
