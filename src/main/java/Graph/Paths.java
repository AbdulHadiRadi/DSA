package Graph;

import java.util.*;

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
                getAllPaths(graph, visited, path+newCur, newCur, target);
                visited[cur]=false;
            }
        }
    }
    static class Pair implements Comparable<Pair>{
        int src;
        int node;
        int dist;

        public Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
        public Pair(int src, int node, int dist) {
            this.src = src;
            this.node = node;
            this.dist = dist;
        }
        @Override
        public int compareTo(Pair p2){
            return this.dist-p2.dist;// ascending order
        }
    }
    //shortest Path's Algo O(e+ elogv)
    public static void dijkstra(ArrayList<Edge> graph [], boolean [] visited, int start){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int [] distances = new int[graph.length];
        for(int i=0; i<distances.length; i++){
            if(i!=start){
                distances[i] = Integer.MAX_VALUE;
            }
        }
        pq.offer(new Pair(0,0)); //o(elogv)
        while(!pq.isEmpty()){
            Pair pair = pq.remove();
            int cur = pair.node;

            if(!visited[cur]){
                visited[cur] = true;
                //o(e)
                for (int i = 0; i < graph[cur].size(); i++) {
                    Edge edge = graph[cur].get(i);
                    int u = edge.source;
                    int v = edge.destination;
                    int w = edge.weight;
                    //Relaxation perform
                    if (distances[u]!=Integer.MAX_VALUE && distances[u]+w<distances[v]){
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
    public static void bellmanford(ArrayList<Edge> [] graph, int start){
        int ver = graph.length;
        int[] distances = new int[ver];
        for(int i=0; i<ver; i++){
            if(i!=start) distances[i] = Integer.MAX_VALUE;
        }
        //O(v.e)
        for(int i=0; i<ver-1; i++){
            for(int j=0; j<ver; j++){
                for(int z=0; z<graph[j].size(); z++){
                    Edge edge = graph[j].get(z);
                    int u = edge.source;
                    int v = edge.destination;
                    int w = edge.weight;
                    // relaxation perform
                    if(distances[u]!=Integer.MAX_VALUE && distances[u]+w<distances[v]){
                        distances[v] = distances[u]+w;
                    }
                }
            }
        }
        for(int i=0; i<ver; i++){
            for(int j=0; j<graph[i].size(); j++){
                Edge edge = graph[i].get(j);
                int u = edge.source;
                int v = edge.destination;
                int w = edge.weight;
                if(distances[u]+w<distances[v]){
                    System.out.println("Negative (-ve) wt cycle detected");
                    return;
                }
            }
        }
        for(int i : distances){
            System.out.println(i);
        }
    }

    //Minimum Spanning Tree O(eloge)
    public static void primsAlgo(ArrayList<Edge> graph [], int start){
        PriorityQueue<Pair> pq = new PriorityQueue<>();//non mst O(eloge)
        boolean visited [] = new boolean[graph.length];//mst
        pq.add(new Pair(0, 0));
        int mstCost = 0;// totol mst cost
        ArrayList<Edge> result = new ArrayList<>();
        while(!pq.isEmpty()){
            Pair pair = pq.remove();
            int node = pair.node;
            if(!visited[node]){
                visited[node] = true;
                result.add(new Edge(pair.src,node,pair.dist));
                mstCost += pair.dist;

                for(int i=0; i<graph[node].size(); i++){
                    Edge edge =  graph[node].get(i);
                    if(!visited[edge.destination]){
                        pq.add(new Pair(edge.source, edge.destination, edge.weight));
                    }
                }
            }
        }
        for(Edge e: result) System.out.println(e.source+" "+e.destination+" "+e.weight);
        System.out.println("MST "+mstCost);
    }
    public static void main(String [] args){
        BuildGraph graphBuilder = new BuildGraph(6);
        ArrayList<Edge> [] graph =  graphBuilder.buildUndirectedGraph();
        boolean [] visited = new boolean[graph.length];
        System.out.println("Get ALl the Paths");
        getAllPaths(graph, visited, "0", 0, 5);

        visited = new boolean[graph.length];
        System.out.println("Get the shortest Paths DIJKSTRA");
        dijkstra(graph, visited,0);

        System.out.println("Get the shortest Paths Bellman Ford");
        bellmanford(graph, 0);

        System.out.println("PrimeAlgo");
        primsAlgo(graph,0);

    }
}
