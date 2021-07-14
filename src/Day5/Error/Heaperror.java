package Day5.Error;

import java.util.ArrayList;

public class Heaperror {
    public void error(){
        ArrayList<byte[]> list=new ArrayList<>();
        for (;;)
            list.add(new byte[8*1024*4]);
    }
}
