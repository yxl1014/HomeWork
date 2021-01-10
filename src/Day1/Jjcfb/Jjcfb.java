package Day1.Jjcfb;

public class Jjcfb {
    public void printf(){
        int i,j;
        for(i=1;i<=9;i++){
            for (j=1;j<=i;j++){
                System.out.print(j+" * "+i+" = "+i*j+"   ");
            }
            System.out.println();
        }
    }
}
