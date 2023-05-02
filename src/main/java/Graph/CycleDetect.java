package Graph;
import java.util.*;
public class CycleDetect {
    //O(V+E)
    public static boolean isCycleUndirected(ArrayList<Edge> graph [], boolean visited [], int cur, int parent){
        visited[cur]=true;

        for (int i=0; i<graph[cur].size(); i++){
            int newCur = graph[cur].get(i).destination;
            if(visited[newCur] && parent!=newCur) {
                return true; // cycle detect for neighbour
            }
            else if (!visited[newCur]){
                if(isCycleUndirected(graph, visited, newCur, cur)) {
                    return true; //cycle detected for neighbour's neighbour
                }
            }
        }

        return false;
    }
    //O(V+E)
    public static boolean isCycleDirected(ArrayList<Edge> graph [], boolean visited [], boolean recurStack [], int cur){
        visited[cur] = true;
        recurStack[cur] = true;

        for (int i=0; i<graph[cur].size(); i++){
            int newCur = graph[cur].get(i).destination;
            if(recurStack[newCur]) {
                return true; // cycle detect for neighbour
            }
            else if (!visited[newCur]){
                if(isCycleDirected(graph, visited, recurStack, newCur)) {
                    return true; //cycle detected for neighbour's neighbour
                }

            }
        }
        System.out.println(cur);
        recurStack[cur] = false; //to make stack free for paths of non cycle
        return false;
    }

    public static void main(String [] args){
        BuildGraph graphBuilder = new BuildGraph(5);
        ArrayList<Edge> [] graph =  graphBuilder.buildDirectedGraph();
        boolean [] visited1 = new boolean[graph.length];
        boolean [] rec = new boolean[graph.length];
        boolean res = false;
        for(int i=0; i< visited1.length; i++){
            if(!visited1[i] && isCycleDirected(graph, visited1, rec, i)) {
                res = true;
                System.out.println("Cycle is detected in the Directed graph");
                break;
            }
        }
        if (!res) {
            System.out.println("Cycle is not detected in the Directed graph");
        }
//        if(res) System.out.println("Cycle is detected in the Directed graph");
//        else System.out.println("Cycle is not detected in the Directed graph");


        ArrayList<Edge> graph2 [] = graphBuilder.buildUndirectedGraph();
        boolean [] visited2 = new boolean[graph2.length];

        for(int i=0; i< visited2.length; i++){
            if(!visited2[i]) {
                System.out.println("Cycle is detected in the Undirected graph "+isCycleUndirected(graph, visited2, 0, -1));
            }
        }
    }
}
