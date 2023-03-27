package Tree;

public class Node {
    //This class represent the tree node for each root and sub root.
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
        Node(int val, Node left, Node right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
}
