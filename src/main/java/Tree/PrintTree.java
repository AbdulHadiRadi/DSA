package Tree;
import java.util.*;

public class PrintTree {
    // This Class is for printing Binary Trees pre/in/post ordered
    public static void printPreOrder(TreeNode root){
        if(root==null) return;
        System.out.println(root.val);
        printPreOrder(root.left);
        printPreOrder(root.right);
    }
    public static void printInOrder(TreeNode root){
        if(root==null) return;
        printInOrder(root.left);
        System.out.println(root.val);
        printInOrder(root.right);
    }
    public static void printPostOrder(TreeNode root){
        if(root==null) return;
        printPostOrder(root.left);
        printPostOrder(root.right);
        System.out.println(root.val);
    }
    public static void printLevelOrder(TreeNode root){
        Queue<TreeNode> level = new LinkedList<>();
        level.add(root) ;
        while(!level.isEmpty()){
            ArrayList<Integer> ls = new ArrayList<>();
            int size = level.size();
            for(int i=0; i<size; i++){
                TreeNode cur = level.remove();
                //System.out.print(cur.val);
                ls.add(cur.val);
                if(cur.left!=null)level.add(cur.left);
                if(cur.right!=null)level.add(cur.right);
            }
            System.out.println(ls);
            //System.out.println(ls);
        }
    }
}
