package Liko.Demo1;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class Test {
    public static String longestCommonPrefix(String[] strs) {
        String xxx = "";
        int size = strs.length;
        int l = 0;
        xxx:
        for (int i = 0; ; i++) {
            if(strs[0].length()<=l)
                break;
            char c = strs[0].charAt(l);
            for (int j = 1; j < size; j++) {
                if(strs[j].length()<=l)
                    break xxx;
                if (c == strs[j].charAt(l)) continue;
                else {
                    break xxx;
                }
            }
            xxx+=c;
            l++;
        }
        new Thread(new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                return null;
            }
        })).start();
        return xxx.equals("") ? "输入不存在公共前缀。" : xxx;
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "zlow", "xlight"};
        System.out.println(longestCommonPrefix(strs));
    }
}
