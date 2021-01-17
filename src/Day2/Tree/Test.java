package Day2.Tree;

public class Test {
    public static void main(String[] args) {
        Tree tree=new Tree();
        tree.creat("tree");//递归创建树
        System.out.print("先序遍历：");
        tree.firprint(tree.getNode());//先序遍历
        System.out.println();
        System.out.print("中序遍历：");
        tree.midprint(tree.getNode());//中序遍历
        System.out.println();
        System.out.print("后序遍历：");
        tree.lastprint(tree.getNode());//后序遍历
        System.out.println();
        tree.turn(tree.getNode());//反转
        System.out.print("先序遍历：");
        tree.firprint(tree.getNode());//先序遍历
        System.out.println();
        System.out.print("中序遍历：");
        tree.midprint(tree.getNode());//中序遍历
        System.out.println();
        System.out.print("后序遍历：");
        tree.lastprint(tree.getNode());//后序遍历
        System.out.println();
    }
}
