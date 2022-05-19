import java.util.*;
class Djikstra{
    public static void main(String args[]){
        int n = 5;
        int[][] adj = new int[n+1][n+1];

        for (int i = 0; i < adj.length; i++) {
            for (int j = 0; j < adj[0].length; j++) {
                adj[i][j] = -1;
            }
        }
        adj[1][2] = 15;
        adj[1][3] = 10;
        adj[2][3] = 2;
        adj[2][4] = 10;
        adj[3][4] = 5;
        adj[3][5] = 1;
        adj[5][4] = 3;
        int[] distance = djikstra(adj,1);
        System.out.println("The distance table is as below ");
        for (int i = 1; i < distance.length; i++) {
            System.out.print(distance[i]+"\t");
        }
        System.out.println("");
    }

    public static class Node{
        int value;
        int weight;

        public Node(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
    }


    public static class CompareByWeight implements Comparator<Node>{

        @Override
        public int compare(Node o1, Node o2) {
            return o1.weight - o2.weight;
        }
    }

    public static int[] djikstra(int[][] adj, int source){
        System.out.println(adj.length);
        boolean[] visited = new boolean[adj.length];
        int[] distance = new int[adj.length];
        for (int i = 0; i < distance.length; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[source] = 0;
        PriorityQueue<Node> pq = new PriorityQueue(new CompareByWeight());
        pq.add(new Node(source, 0));
        while(!pq.isEmpty()){
            Node itr = pq.poll();
            System.out.println("The value of itr : "+itr);
            visited[itr.value] = true;
            for(int j = 1; j < adj[0].length;j++){
                if(adj[itr.value][j] != -1){
                    System.out.println("adj "+itr+" "+j);
                    if(distance[j] > distance[itr.value]+adj[itr.value][j]){
                        distance[j] = distance[itr.value]+adj[itr.value][j];
                    }
                    if(visited[j] == false){
                        pq.add(new Node(j, distance[j]));
                    }
                }
            }
        }
        return distance;
    }
}

