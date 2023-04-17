package Graph;
import java.util.*;
public class CycleDetect {
    public static boolean isCycleUndirected(ArrayList<Edge> graph [], boolean visited [], int cur, int parent){
        visited[cur]=true;

        for (int i=0; i<graph[cur].size(); i++){
            int newCur = graph[cur].get(i).destination;
            if(visited[newCur] && parent!=newCur) return true;
            else if (!visited[newCur]){
                System.out.println(cur+" "+newCur);
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
                System.out.println(cur+" "+newCur);
                if(isCycleDirected(graph, visited, recurStack, newCur)) return true;
            }
        }
        recurStack[cur] = false;
        return false;
    }
    public static void topologicalSort(ArrayList<Edge> graph[], boolean visited [], Stack<Integer> stack, int cur){
        visited[cur] = true;

        for (int i=0; i<graph[cur].size(); i++){
            int newCur = graph[cur].get(i).destination;
            if (!visited[newCur]){
                topologicalSort(graph, visited, stack, newCur) ;
            }
        }
        stack.push(cur);
    }
}
