package Day1.Error;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.SimpleTimeZone;

public class Heaperror {
    public void error(){
        ArrayList<byte[]> list=new ArrayList<>();
        for (;;)
            list.add(new byte[8*1024*4]);
    }
}
