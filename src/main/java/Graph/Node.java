package Graph;

import java.util.List;

public class Node {
    int val;
    List<Node> neighbors;
    Node(int val){
        this.val = val;
    }
    Node(int val, List<Node> neighbors){
        this.val = val;
        this.neighbors = neighbors;
    }
}
