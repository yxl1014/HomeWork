package Day2.Last;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

public class LastK {
    private int k;
    private int[] ints;

    public LastK(int k,int n){//k为前多少个数，n为数组的范围为0~n-1及数组的长度
        this.k=k;
        this.ints=new int[n];
        Random random=new Random();
        for(int i=0;i<n;i++){
            this.ints[i]=random.nextInt(n);//生成随机数组
        }
    }
    public void lastk(){
        Sort sort=new Sort(this.ints);//希尔排序
        this.ints=sort.doSort_I();
        for(int i=0;i<k;i++){
            System.out.print(this.ints[i]+" ");//输出前k个数
        }
    }

    public void dis(){
        for(int i=0;i<this.ints.length;i++){
            System.out.print(this.ints[i]+" ");//打印整个数组
        }
        System.out.println();
    }
}
