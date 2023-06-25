package Graph;

import java.util.ArrayList;

public class ArticularPoint {
    public static void getArticularPoint(ArrayList<Edge> graph []){
        int v = graph.length;
        int [] dt = new int [v];
        int [] low = new int [v];
        boolean [] visited = new boolean[v];
        boolean [] artPoints = new boolean[v];
        int time = 0;
        for(int i=0; i<v; i++){
            if(!visited[i]){
                dfs(graph, visited, artPoints, dt, low, i, time, -1);
            }
        }
        for(int i=0; i<v; i++){
            if(artPoints[i]){
                System.out.println("Articular Point "+ i);;
            }
        }
    }
    public static void dfs(ArrayList<Edge> graph [], boolean [] visited, boolean [] ap, int [] dt, int [] low, int cur, int time, int parent){
        visited [cur] = true;
        dt[cur] = low[cur] = ++time;
        int child = 0;// trace the disconnected neighbours

        for(int i=0; i<graph[cur].size(); i++){
            Edge edge = graph[cur].get(i);
            int neighbour = edge.destination;
            System.out.println(cur +" neighbour is "+neighbour+ " and child has "+ child);
            if(neighbour==parent){
                continue; // if neighbour is parent then ignore
            }
            // not visited neighbour
            else if (!visited[neighbour]){
                dfs(graph, visited, ap, dt, low, neighbour, time, cur);
                low [cur] = Math.min(low[cur], low[neighbour]); // update low
                if(dt[cur]<=low[neighbour] && parent!=-1){
                    // Articular Point detected non-starting vertices
                    ap[cur] = true;
                }
                child++; // disconnected neighbour
            }
            // visited neighbour so back-edged detected
            else {
                low [cur] = Math.min(low[cur], dt[neighbour]); // update low
            }
            // Articular Point detected for starting vertices
            if(parent==-1 && child>1){
                ap[cur] = true;
            }
        }
    }
    public static void main(String [] args){
//        BuildGraph builder = new BuildGraph(5);
//        ArrayList<Edge> graph [] = builder.buildUndirectedGraph();
//        getArticularPoint(graph);
        //System.out.println(3^1);
        boolean r [] =  new boolean [5];

        System.out.println(r[4]==true);
    }
}
