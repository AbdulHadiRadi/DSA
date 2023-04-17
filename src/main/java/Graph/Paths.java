package Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Paths {
    public static void getAllPaths(ArrayList<Edge> graph [], boolean [] visited, String path, int cur, int target){
        if(cur == target){
            System.out.println(path);
            return;
        }

        for(int i=0; i<graph[cur].size(); i++){
            int newCur = graph[cur].get(i).destination;
            if (!visited[newCur]) {
                visited[cur]=true;
                //System.out.println(cur+" "+newCur+" "+visited[cur]);
                getAllPaths(graph, visited, path+newCur, newCur, target);
                visited[cur]=false;
            }
        }
        // unmark the current node as visited if it's not the starting node
        visited[cur] = false;
    }
    static class Pair implements Comparable<Pair>{
        int node;
        int dist;

        public Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
        @Override
        public int compareTo(Pair p2){
            return this.dist-p2.dist;
        }
    }
    //Dijkstra's Algo
    public static void shortedPath(ArrayList<Edge> graph [], boolean [] visited, int start){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int [] distances = new int[graph.length];
        for(int i=0; i<distances.length; i++){
            if(i!=start){
                distances[i] = Integer.MAX_VALUE;
            }
        }
        pq.offer(new Pair(0,0));
        while(!pq.isEmpty()){
            Pair pair = pq.remove();
            int cur = pair.node;

            if(!visited[cur]){
                visited[cur] = true;

                for (int i = 0; i < graph[cur].size(); i++) {
                    Edge edge = graph[cur].get(i);
                    int u = edge.source;
                    int v = edge.destination;
                    int w = edge.weight;
                    if (distances[u]+w<distances[v]){
                        distances[v] = distances[u] + w;
                        pq.offer(new Pair(v,distances[v]));
                    }
                }
            }
        }
        for(int i : distances){
            System.out.println(i);
        }
    }
}
