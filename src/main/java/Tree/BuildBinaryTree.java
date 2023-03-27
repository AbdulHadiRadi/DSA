package Tree;


import java.util.Arrays;

public class BuildBinaryTree {
    private int  indx;
    public BuildBinaryTree(){
        int indx =0;
    }

    public Node preOrder(int [] a){
        if(a==null || a.length==0) return null;
        int val = a[0];
        Node root = new Node(val);
        indx = 1;
        while(indx<a.length){
            if(a[indx]>val) break;
            indx++;
        }
        int [] left = Arrays.copyOfRange(a,1, indx);
        int [] right = Arrays.copyOfRange(a, indx, a.length);
        root.left = postOrder(left);
        root.right = preOrder(right);
        //return buildPreOrder(a, Integer.MAX_VALUE);
        return root;
    }

//    private Node buildPreOrder(int[] a, int maxValue) {
//        if(indx==a.length || a[indx]>maxValue) return null;
//        int val = a[indx++];
//        Node root = new Node(val);
//        root.left = buildPreOrder(a, val);
//        root. right = buildPreOrder(a, maxValue);
//        return root;
//    }
    public Node inOrder(int [] a){
        if(a.length==0) return null;
        int mid = a.length/2;
        int val = a[mid];
        Node root = new Node(val);
        root.left = inOrder(Arrays.copyOfRange(a,0,mid));
        root.right = inOrder(Arrays.copyOfRange(a, mid+1, a.length));
        return root;
    }

    public Node postOrder(int[] a) {
        int length = a.length;
        if(length==0) return null;
        int val = a[length-1];
        Node root = new Node(val);
       // if(a.length==1) return root;
        indx = 0;
        while(indx<length-1){
            //if the value is greater than root val than break so that it goes to the right subtree check
            if(a[indx]>val) {
                break;
            }
            indx++;
        }
        int [] left = Arrays.copyOfRange(a,0, indx);
        int [] right = Arrays.copyOfRange(a, indx, a.length-1);
        root.left = postOrder(left);
        root.right = postOrder(right);
        return root;
    }
}
