package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BuildGraph {
    int vertices;
    ArrayList<Edge> [] graph;
    public BuildGraph(int vertices) {
        this.vertices = vertices;
        graph= new ArrayList [vertices];
    }
    public ArrayList<Edge>[] buildGraph(){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0,1, 2));
        graph[0].add(new Edge(0,2, 4));

        graph[1].add(new Edge(1,3, 7));
        graph[1].add(new Edge(1,2, 1));

        graph[2].add(new Edge(2,4, 3));

        //graph[3].add(new Edge(3,1));
        //graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5, 1));

        //graph[4].add(new Edge(4,6));
        graph[4].add(new Edge(4,5, 5));
        graph[4].add(new Edge(4,3, 2));
        //graph[4].add(new Edge(4,2));

        //graph[5].add(new Edge(5,6));
        //graph[5].add(new Edge(5,4));
        //graph[5].add(new Edge(5,3));

        return graph;
    }


}
