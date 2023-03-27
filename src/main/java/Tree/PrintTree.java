package Tree;

public class PrintTree {
    // This Class is for printing Binary Trees pre/in/post ordered
    public static void printPreOrder(Node root){
        if(root==null) return;
        System.out.println(root.val);
        printPreOrder(root.left);
        printPreOrder(root.right);
    }
    public static void printInOrder(Node root){
        if(root==null) return;
        printInOrder(root.left);
        System.out.println(root.val);
        printInOrder(root.right);
    }
    public static void printPostOrder(Node root){
        if(root==null) return;
        printPostOrder(root.left);
        printPostOrder(root.right);
        System.out.println(root.val);
    }
}
