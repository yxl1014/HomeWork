package Day2;

public class ForTest {
    public static void main(String[] args) {
        int a=0;
        fff:
        for(int j=0;j<3;j++) {
            for (int i = 0; a <= 10; i++) {
                if (i >= 3) {
                    break fff;//指定跳出的for循环，这里是外层for循环
                } else {
                    a++;
                }
            }
        }
        System.out.println(a);
    }
}
