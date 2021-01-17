package Day2.TheSameNum;

import java.util.HashSet;
import java.util.Random;

public class Num {

    private int[] ints;

    private int num;

    public Num(int n,int target){
        this.num=target;
        this.ints=new int[n];
        //随机生成数组
        Random random=new Random();
        for(int i=0;i<n;i++){
            this.ints[i]=random.nextInt(n);
        }
    }

    public int Same(){
        HashSet<Integer> set=new HashSet<>();
        set.add(this.num);//将目标值加入set
        int sum=0;
        for (int i:ints){
            if(!set.add(i)&&i==num)//若不能存入set并且与目标值相sum++
                sum++;
        }
        return sum;
    }

    public void dis(){
        //输出整个数组
        for(int i=0;i<this.ints.length;i++){
            System.out.print(this.ints[i]+" ");
        }
        System.out.println();
    }
}
