package MyTest;

import MyTest.D1.MyList;

public class Application {
    public static void main(String[] args) {
        MyList<String> list=new MyList<>();
        System.out.println(list.getSize());
        list.addNodeF("aaa");
        list.addNodeF("bbb");
        list.addNodeF("ccc");
        list.addNodeF("ddd");

        System.out.println(list.getSize());
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        list.display();
        list.addNodeL("eee");
        list.display();
        System.out.println(list.selectIndex(3));
        list.updateNode("ccc","fff");
        list.display();
    }
}
