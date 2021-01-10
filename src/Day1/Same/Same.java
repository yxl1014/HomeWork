package Day1.Same;

import java.util.Random;

public class Same {
    private int[] ints;

    public Same(int n){
        this.ints=new int[n];
        for(int i=0;i<n;i++){
            this.ints[i]= new Random().nextInt(n);
        }
    }

    public void find(){
        boolean out=false;
        int len=this.ints.length;
        for(int i=0;i<len;i++){
            if(this.ints[i]<0)
                continue;
            for(int j=i+1;j<len;j++){
                if(this.ints[j]<0)
                    continue;
                if(this.ints[i]==this.ints[j]){
                    out=true;
                    this.ints[j]=-1;
                }
            }
            if(out){
                System.out.print(this.ints[i]+" ");
                this.ints[i]=-1;
                out=false;
            }
        }
        System.out.println();
    }

    public void dis(){
        for(int i=0;i<this.ints.length;i++){
            System.out.print(this.ints[i]+" ");
        }
        System.out.println();
    }
}
