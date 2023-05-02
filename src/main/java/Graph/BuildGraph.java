package Graph;

import java.util.*;

public class BuildGraph {
    int vertices;
    ArrayList<Edge> [] graph;
    public BuildGraph(int vertices) {
        this.vertices = vertices;
        graph= new ArrayList [vertices];
    }
    public ArrayList<Edge>[] buildUndirectedGraph(){
        for(int i=0; i<vertices; i++){
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0,1, 2));
        graph[0].add(new Edge(0,2, 4));
        graph[0].add(new Edge(0,3, 4));

        graph[1].add(new Edge(1,0, 2));
        graph[1].add(new Edge(1,2, 7));
        //graph[1].add(new Edge(1,2, 1));

        //graph[2].add(new Edge(2,4, 3));
        graph[2].add(new Edge(2,1, 1));
        graph[2].add(new Edge(2,0, 4));

        graph[3].add(new Edge(3,0, 7));
        //graph[3].add(new Edge(3,5, 1));
        graph[3].add(new Edge(3,4, 1));

        //graph[4].add(new Edge(4,6));
        //graph[4].add(new Edge(4,5, 5));
        graph[4].add(new Edge(4,3, 3));
        //graph[4].add(new Edge(4,2));

        //graph[5].add(new Edge(5,6));
//        graph[5].add(new Edge(5,4, 5));
//        graph[5].add(new Edge(5,3, 1));

        return graph;
    }

    public ArrayList<Edge>[] buildDirectedGraph(){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0,2, 2));
        graph[0].add(new Edge(0,3, 4));

        graph[1].add(new Edge(1,0, 7));
        //graph[1].add(new Edge(1,2, -4));

        graph[2].add(new Edge(2,1, 3));

       // graph[3].add(new Edge(3,5, 1));
        graph[3].add(new Edge(3,4, 7));

       // graph[4].add(new Edge(4,5, 5));

        return graph;
    }

}
