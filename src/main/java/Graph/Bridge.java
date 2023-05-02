package Graph;

import java.util.ArrayList;

public class Bridge {
    public static void dfs(ArrayList<Edge> [] graph, boolean[] visited, int [] discT, int [] lowT, int cur, int time, int parent){
        visited [cur] = true;
        discT[cur]=lowT[cur] = ++time;
        for(int i=0; i<graph[cur].size(); i++){
            Edge edge = graph[cur].get(i);
            int neighbour = edge.destination;
            if(neighbour==parent){
                continue;
            }
            else if(!visited[neighbour]){
                dfs(graph, visited, discT, lowT, neighbour, time, cur);
                lowT[cur] = Math.min(lowT[cur], lowT[neighbour]);
                //Bridge detected
                if(discT[cur]<lowT[neighbour]){
                    System.out.println(cur +" Bridge "+ neighbour);
                }
            }
            else {
                lowT[cur] = Math.min(lowT[cur], discT[neighbour]);
            }
        }
    }
    public static void getBridge(ArrayList<Edge>[] graph){
        int v = graph.length;
        boolean [] visited = new boolean[v];
        int [] discT = new int[v];
        int [] lowT = new int[v];
        for(int i=0; i<graph.length; i++){
            if (!visited[i]){
                dfs(graph, visited, discT,lowT,0,0,-1);
            }
        }
    }
    public static void main(String [] args){
        BuildGraph graphBuilder = new BuildGraph(6);
        ArrayList<Edge> [] graph =  graphBuilder.buildUndirectedGraph();
        getBridge(graph);
    }
}
