package Graph;
import java.util.*;
public class CycleDetect {
    public static boolean isCycleUndirected(ArrayList<Edge> graph [], boolean visited [], int cur, int parent){
        visited[cur]=true;

        for (int i=0; i<graph[cur].size(); i++){
            int newCur = graph[cur].get(i).destination;
            if(visited[newCur] && parent!=newCur) return true;//cycle detect
            else if (!visited[newCur]){
                if(isCycleUndirected(graph, visited, newCur, cur)) return true;
            }
        }

        return false;
    }
    public static boolean isCycleDirected(ArrayList<Edge> graph [], boolean visited [], boolean recurStack [], int cur){
        visited[cur] = true;
        recurStack[cur] = true;
        for (int i=0; i<graph[cur].size(); i++){
            int newCur = graph[cur].get(i).destination;
            if(recurStack[newCur]) return true;// cycle detect
            else if (!visited[newCur]){
                if(isCycleDirected(graph, visited, recurStack, newCur)) return true;
            }
        }
        recurStack[cur] = false;
        return false;
    }

    public static void main(String [] args){
        BuildGraph graphBuilder = new BuildGraph(6);
        ArrayList<Edge> [] graph =  graphBuilder.buildDirectedGraph();
        boolean [] visited1 = new boolean[graph.length];
        boolean [] rec = new boolean[graph.length];
        for(int i=0; i< visited1.length; i++){
            if(!visited1[i]) {
                System.out.println("Cycle in Directed graph "+isCycleDirected(graph, visited1,rec, 0));
            }
        }
        ArrayList<Edge> graph2 [] = graphBuilder.buildUndirectedGraph();
        boolean [] visited2 = new boolean[graph2.length];
        for(int i=0; i< visited2.length; i++){
            if(!visited2[i]) {
                System.out.println("Cycle in Undirected graph "+isCycleUndirected(graph, visited2, 0, -1));
            }
        }
    }
}
