package Tree;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BuildBinaryTreeTest {

    private TreeNode preRoot, inRoot, postRoot;
    @BeforeEach
    void setUp() {
        int[]  a = {10, 7,11, 5, 9, 11, 8, 20,15, 30};
        int [] b = {7,8,4,9,10,12,6,11,20};
        int[]  c = {1, 7, 5, 50, 40, 10};
        preRoot = new BuildBinaryTree().preOrder(a);
        inRoot = new BuildBinaryTree().inOrder(b);
        postRoot = new BuildBinaryTree().postOrder(c);
    }

    @AfterEach
    void tearDown() {
        preRoot = null;
        postRoot = null;
    }
    @Test
    public void testPreOrder(){
        PrintTree.printInOrder(preRoot);
        Assertions.assertEquals(10, preRoot.val);
    }
    @Test
    public void testInOrder(){
        PrintTree.printPreOrder(inRoot);
        Assertions.assertEquals(10, inRoot.val);
    }
    @Test
    public void testPostOrder(){
        PrintTree.printInOrder(postRoot);
        Assertions.assertEquals(10, postRoot.val);
    }

}