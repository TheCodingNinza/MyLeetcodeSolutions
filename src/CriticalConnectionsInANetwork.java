import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CriticalConnectionsInANetwork {
    static int[] parent;
    static int[] disc;
    static int[] low;
    static boolean[] visited;
    static int time;
    static List<List<Integer>> ans;

    public class DSU{
        int[] arr;

        public DSU(int n) {
            this.arr = new int[n];
            Arrays.fill(arr,-1);
        }

        public int findParent(int node){
            int iterator = node;
            while (this.arr[iterator] != -1){
                iterator = this.arr[iterator];
            }
            return iterator;
        }

        public void union(int nodeA, int nodeB){
            int parentA = findParent(nodeA);
            int parentB = findParent(nodeB);
            if(parentA != parentB){
                this.arr[parentB] = parentA;
            }
        }

        public int findGroupCount(){
            int count = 0;
            for (int i = 0; i < this.arr.length; i++) {
                if(this.arr[i] == -1){
                    count++;
                }
            }
            return count;
        }
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        DSU network = new DSU(n);
        parent = new int[n];
        disc = new int[n];
        low = new int[n];
        visited = new boolean[n];
        time = 0;
        ans = new ArrayList<>();
        parent[0] = -1;
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < connections.size(); i++) {
            adjList.add(new ArrayList<>());
        }
        for(List<Integer> connection: connections){
            adjList.get(connection.get(0)).add(connection.get(1));
            adjList.get(connection.get(1)).add(connection.get(0));
            network.union(connection.get(0),connection.get(1));
        }
        System.out.println(network.findGroupCount());
        dfs(0,adjList);
        
        return ans;
    }

    public static void dfs(int src, List<List<Integer>> adjList){
        visited[src] = true;
        disc[src] = time;
        time++;
        low[src] = src;
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
                    dfs(neighbour, adjList);
                    low[src] = Math.min(low[src],low[neighbour]);
                    if(low[neighbour] > disc[src]){
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(neighbour);
                        tmp.add(src);
                        ans.add(tmp);
                    }

                }
            }
        }
    }
}
