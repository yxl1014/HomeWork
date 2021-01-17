package Day2.Time;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Time {
    public static void main(String[] args) {
        ArrayList<AAA> list=new ArrayList<>();
        long startTime1=System.nanoTime()/1000000L;
        for(int i=0;i<100000;i++){
            list.add(new AAA(1,"aaa",true));
        }
        long endTime1=System.nanoTime()/1000000L;
        System.out.println(endTime1-startTime1);
        System.out.println();
        System.out.println();
        System.out.println();

        long startTime2=System.nanoTime()/1000000L;
        for (int j=0;j<100000;j++){
            AAA a2=new AAA();
            a2.setA(1);
            a2.setB("aaa");
            a2.setC(true);
            list.add(a2);
        }
        long endTime2=System.nanoTime()/1000000L;
        System.out.println(endTime2-startTime2);
    }
}
