package Day2.TheSameNum;

public class Test {
    public static void main(String[] args) {
        Num num=new Num(10,5);//随机数组长度与目标值
        num.dis();//打印整个随机数组
        System.out.println("一共有"+num.Same()+"个");//输出
    }
}
