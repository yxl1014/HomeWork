package Day1.Add;

import java.util.Random;

public class Add {
    private int[] ints;
    private int target;

    public Add(int n,int target){
        this.ints=new int[n];
        for(int i=0;i<n;i++){
            this.ints[i]= new Random().nextInt(n);
        }
        this.target=target;
    }

    public void find(){
        boolean ok=false;
        int[] x=this.ints;
        for(int i=0;i<x.length&&!ok;i++){
            for(int j=i+1;j<x.length&&!ok;j++){
                if (x[i]+x[j]==target){
                    System.out.println("["+i+","+j+"]");
                    ok=true;
                }
            }
        }
    }
    public void findAll(){
/*        boolean ok=false;*/
        int[] x=this.ints;
        for(int i=0;i<x.length;i++){
            for(int j=i+1;j<x.length;j++){
                if (x[i]+x[j]==target){
                    System.out.print("["+i+","+j+"]  ");
                   /* ok=true;*/
                }
            }
        }
    }

    public void dis(){
        for(int i=0;i<this.ints.length;i++){
            System.out.print(this.ints[i]+" ");
        }
        System.out.println();
    }
}
