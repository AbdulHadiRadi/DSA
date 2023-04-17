package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TraverseGraph {
    public static void getNeighbours(ArrayList<Edge> [] graph,int val){
        int size = graph[val].size();
        int [] neighbours = new int[size];
        for(int i=0; i<size; i++){
            neighbours[i] = graph[val].get(i).destination;
            System.out.println(graph[val].get(i).destination);
        }
    }

    public static void bfs(ArrayList<Edge>[] graph, boolean [] visited, int start){
        Queue<Integer> qu = new LinkedList<>();
        qu.add(start);
        while(!qu.isEmpty()) {
            int cur = qu.remove();
            if (!visited[cur]) {
                System.out.println(cur);
                visited[cur] = true;
                for (int i = 0; i < graph[cur].size(); i++) {
                    Edge e = graph[cur].get(i);
                    qu.add(e.destination);
                }
            }
        }
    }
    public static void dfs(ArrayList<Edge>[] graph,  boolean [] visited, int cur){
        System.out.println(cur);
        visited[cur] = true;
        for(int i=0; i<graph[cur].size(); i++){
            Edge e = graph[cur].get(i);
            int neighbour = e.destination;
            if(!visited[neighbour]){
                dfs(graph, visited, neighbour);
            }
        }
    }


    public static void main(String [] args){
        BuildGraph graphBuilder = new BuildGraph(7);
        ArrayList<Edge> [] graph =  graphBuilder.buildGraph();
        //getNeighbours(graph,2);
        boolean [] visited = new boolean[graph.length];
        Paths.shortedPath(graph, visited,0);
//        boolean [] rec = new boolean[graph.length];
//        boolean res = false;
 //       Stack<Integer> stack= new Stack<>();
//        for(int i=0; i< visited.length; i++){
//            if(!visited[i]) {
//                CycleDetect.topologicalSort(graph, visited, stack, 0);
//                //bfs(graph, visited, 0);
//                //dfs(graph, visited, 0)
//            }
//        }
//        while(!stack.isEmpty()) {
//            System.out.println(stack.pop());
//        }
        //Paths.getAllPaths(graph, visited, "0", 0, 5);

    }
}
