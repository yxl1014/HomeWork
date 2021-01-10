package Day1.Work;

public class Tea {
    public Work MakeWork(String workname){
        Work work=new Work(workname);
        System.out.println("老师布置了一门作业名字叫做："+work.getName());
        return work;
    }
}
