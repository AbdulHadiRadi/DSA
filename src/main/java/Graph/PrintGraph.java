package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PrintGraph {
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
            int size = graph[cur].size();
            if (!visited[cur]) {
                System.out.println(cur);
                visited[cur] = true;
                for (int i = 0; i < size; i++) {
                    Edge e = graph[cur].get(i);
                    qu.add(e.destination);

                }
            }
        }
    }
    public static void dfs(ArrayList<Edge>[] graph,  boolean [] visited, int cur){
        if(!visited[cur]){
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
    }
    public static void main(String [] args){
        BuildGraph graphBuilder = new BuildGraph(7);
        ArrayList<Edge> [] graph =  graphBuilder.buildGraph();
        //getNeighbours(graph,2);
        boolean [] visited = new boolean[graph.length];
        for(int i=0; i< visited.length; i++){
            if(!visited[i])  bfs(graph, visited, i);
        }
    }
}
