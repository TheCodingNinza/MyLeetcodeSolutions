import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GraphTheory {
    static int[] parent;
    static int[] disc;
    static int[] low;
    static boolean[] visited;
    static int time;
    static boolean[] ap;



    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
         int V = scn.nextInt();
         int E = scn.nextInt();

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            int u = scn.nextInt()-1;
            int v = scn.nextInt()-1;
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        parent = new int[V];
        disc = new int[V];
        low = new int[V];
        visited = new boolean[V];
        time = 0;
        ap = new boolean[V];
        parent[0] = -1;
        dfs(0, adjList);

    }

    public static void dfs(int src, List<List<Integer>> adjList){
        visited[src] = true;
        disc[src] = time;
        time++;
        low[src] = src;
        int dfsCount = 0;
        List<Integer> neighbours = adjList.get(src);
        for (int i = 0; i < neighbours.size(); i++) {
            int neighbour = neighbours.get(i);
            if(neighbour == parent[src]){
                continue;
            }else{
                if(visited[neighbour]){
                    low[src] = Math.min(low[src],disc[neighbour]);
                }else{
                    parent[neighbour] = src;
                    dfsCount++;
                    dfs(neighbour, adjList);
                    low[src] = Math.min(low[src],low[neighbour]);
                    if(parent[src] == -1){
                        if(dfsCount >=2){
                            ap[src] = true;
                        }
                    }else{
                        if(low[neighbour] >= disc[src]){
                            ap[src] = true;
                        }
                    }
                }
            }
        }
    }


}
