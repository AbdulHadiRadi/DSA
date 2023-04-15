package Tree;
import java.util.LinkedList;
import java.util.Queue;
public class Trees {
        public static void main (String [] args) {
            int [] nums = {1,2,4,-1,-1,5,-1,-1,3,9,-1,-1,6,-1,-1};
            TreeNode tree = buildTrees(nums);
            levelOrder(tree);
            //System.out.println("preOrder");
            //TreeNode doublyLinked = fattenDoubly(tree);
            //  System.out.println("inOrder");
            // print(doublyLinked);
//        System.out.println("postOrder");
//        postOrder(tree);
//        System.out.println("levelOrder");
//        levelOrder(tree);
//        System.out.println("Num of Nodes "+countNodes(tree));
//        System.out.println("Sum of Nodes "+sumNodes(tree));
//        System.out.println("Height of Tree "+getHeight(tree));
        }



        private static int getHeight(TreeNode tree) {
            if(tree==null) return 0;
            int lh = getHeight(tree.left);
            int rh = getHeight(tree.right);
            return Math.max(lh,rh)+1;
        }

        private static int countNodes(TreeNode root){
            int total = 0;
            if(root==null){
                return 0;
            }
            return countNodes(root.left)+countNodes(root.right)+1;
        }
        private static int sumNodes(TreeNode root){
            if(root == null){
                return 0;
            }
            return sumNodes(root.left)+sumNodes(root.right)+root.val;
        }
        //BFS
        private static void levelOrder(TreeNode tree) {
            Queue<TreeNode> level = new LinkedList<>();
            level.add(tree) ;
            while(!level.isEmpty()){
                //ArrayList<Integer> ls = new ArrayList<>();
                int size = level.size();
                for(int i=0; i<size; i++){
                    TreeNode cur = level.remove();
                    System.out.print(cur.val);
                    // ls.add(cur.val);
                    if(cur.left!=null)level.add(cur.left);
                    if(cur.right!=null)level.add(cur.right);
                }
                System.out.println();
                //System.out.println(ls);
            }

//        level.add(null);
//        while(!level.isEmpty()){
//            TreeNode cur = level.remove();
//            if(cur==null){
//                System.out.println();
//                if(level.isEmpty()) break;
//                level.add(null);
//            }
//            else{
//                System.out.print(cur.val+" ");
//                if(cur.left!=null) level.add(cur.left);
//                if(cur.right!=null) level.add(cur.right);
//            }
//        }
        }


        static int indx = -1;
        // preOrder Tree
        public static TreeNode buildTrees(int [] nums){
            if(nums[++indx]==-1) return null;
            TreeNode tree = new TreeNode(nums[indx]);
            tree.left = buildTrees(nums);
            tree.right = buildTrees(nums);
            return tree;
        }

        //DFS
        public static void preOrder(TreeNode node){
            if(node==null) {
                // System.out.println("-1");
                return;
            }
            System.out.println(node.val);
            preOrder(node.left);
            preOrder(node.right);
        }
        public static void inOrder(TreeNode node){
            if(node==null) return;
            inOrder(node.left);
            System.out.println(node.val);
            inOrder(node.right);
        }

        private static void postOrder(TreeNode node) {
            if(node==null) return;
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.val);
        }
        private static TreeNode prev = null, head =null;
        private static TreeNode fattenDoubly(TreeNode root){
            if(root==null) return null;
            fattenDoubly(root.left);
            if(prev == null){
                head = root;
            }
            else{
                root.left = prev;
                prev.right = root;
            }
            prev = root;
            fattenDoubly(root.right);
            return head;
        }


        private static void print(TreeNode doublyLinked){
            TreeNode head = doublyLinked;
            while(head!=null){
                System.out.println(head.val);
                head = head.right;
            }
        }
}


