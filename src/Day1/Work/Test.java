package Day1.Work;

public class Test {
    public static void main(String[] args) {
        Tea tea=new Tea();
        Stu stu=new Stu();
        Par par=new Par();
        for(int i=0;i<10;i++){
            Work work=tea.MakeWork(Integer.toString(i));
            stu.GetWork(work);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    par.GetWork(work);
                }
            }).run();
        }
    }
}
