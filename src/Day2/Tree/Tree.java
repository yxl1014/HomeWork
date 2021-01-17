package Day2.Tree;

import java.util.Scanner;

public class Tree {
    public TreeNode getNode() {
        return node;
    }

    public void setNode(TreeNode node) {
        this.node = node;
    }

    private TreeNode node;

    public TreeNode creat(String des){
        Scanner scanner=new Scanner(System.in);
        System.out.println("提示:"+des);
        int i=scanner.nextInt();
        if(i<0)return null;
        TreeNode root=new TreeNode();
        root.data=i;
        root.lchild=creat(i+"左子树");
        root.rchild=creat(i+"右子树");
        node=root;
        return root;
    }

    public void midprint(TreeNode treeNode){
        //中序遍历
        if(treeNode!=null){
            midprint(treeNode.lchild);
            System.out.print(treeNode.data+"  ");
            midprint(treeNode.rchild);
        }
    }
    public void firprint(TreeNode treeNode){
        //先序遍历
        if(treeNode!=null){
            System.out.print(treeNode.data+" ");
            firprint(treeNode.lchild);
            firprint(treeNode.rchild);
        }
    }
    public void lastprint(TreeNode treeNode){
        //后序遍历
        if(treeNode!=null){
            lastprint(treeNode.lchild);
            lastprint(treeNode.rchild);
            System.out.print(treeNode.data+"  ");
        }
    }

    public void turn(TreeNode n){
        //直到节点为null
        if(n!=null){
            //左右节点互换
            TreeNode t=n.lchild;
            n.lchild=n.rchild;
            n.rchild=t;
            turn(n.lchild);
            turn(n.rchild);
        }
    }
}
