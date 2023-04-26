package Graph;

import java.util.ArrayList;
import java.util.Stack;

public class Conected {

    public static void topologicalSort(ArrayList<Edge> [] graph, boolean [] visited, Stack<Integer> st, int cur){
        visited[cur] = true;
        for(int i=0; i<graph[cur].size(); i++){
            Edge e = graph[cur].get(i);
            if(!visited[e.destination])topologicalSort(graph, visited, st, e.destination);
        }
        st.push(cur);
    }
    public static void kosarajuAlgo(ArrayList<Edge> [] graph){
        //topological sort
        int ver = graph.length;
        boolean [] visited = new boolean[ver];
        Stack<Integer> st = new Stack<>();
        topologicalSort(graph,visited, st, 0);
        //Transpose the graph
        ArrayList<Edge> [] transpose = new ArrayList[ver];
        for(int i=0; i<ver; i++){
            transpose[i]= new ArrayList<Edge>();
            visited[i] = false;
        }
        for(int i=0; i<ver; i++){
            for(int j=0; j<graph[i].size(); j++){
                Edge e = graph[i].get(j);
                transpose[e.destination].add(new Edge(e.destination, e.source, e.weight));
            }
        }
        //calling dfs to print transpose
        while(!st.isEmpty()){
            int cur=st.pop();
            if(!visited[cur]){
                TraverseGraph.dfs(transpose, visited, cur);
                System.out.println();
            }
        }
    }
    public static void main(String[] args){
        BuildGraph buildGraph = new BuildGraph(5);
        ArrayList<Edge>[] graph = buildGraph.buildDirectedGraph();
        kosarajuAlgo(graph);

    }
}
