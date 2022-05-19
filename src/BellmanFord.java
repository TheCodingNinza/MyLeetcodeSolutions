import java.util.ArrayList;
import java.util.List;

public class BellmanFord {
    public static class Node{
        int value;
        int weight;

        public Node(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
    }
    public static void main(String[] args) {

        List<List<Node>> adj = new ArrayList<>();
        for(int i=0;i<5;i++){
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(new Node(4,5));
        adj.get(1).add(new Node(2,3));
        adj.get(2).add(new Node(0,2));
        adj.get(0).add(new Node(3,5));
        adj.get(4).add(new Node(1,10));
        int[] distance = bellmanFord(adj);
        for (int i = 0; i < distance.length; i++) {
            System.out.print(distance[i]+"\t");
        }
        System.out.println("");
    }

    public static int[] bellmanFord(List<List<Node>> adj){
        int[] distance = new int[adj.size()];
        for (int i = 0; i < distance.length; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[0] = 0;
        for (int k = 0; k <= adj.size()-1; k++) {
            for (int i = 0; i < adj.size(); i++) {
                List<Node> itrList = adj.get(i);
                for (int j = 0; j < itrList.size(); j++) {
                    int u = i;
                    int v = itrList.get(j).value;
                    if(distance[u] != Integer.MAX_VALUE && distance[v] > distance[u] + itrList.get(j).weight){
                        distance[v] = distance[u] +  itrList.get(j).weight;
                    }
                }
            }
        }
        return distance;
    }
}
