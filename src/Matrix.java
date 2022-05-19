import java.util.*;
public class Matrix {
    public static class Node{
        int i;
        int j;
        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static int[][] updateMatrix(int[][] mat) {
        int[][] dist = new int[mat.length][mat[0].length];
        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist[0].length; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if(mat[i][j] == 0){
                    bfs(mat,dist,new Node(i,j));
                }
            }
        }
        return dist;
    }

    public static void bfs(int[][] mat, int[][] dist, Node source){
        Queue<Node> que = new LinkedList<>();
        dist[source.i][source.j] = 0;
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        que.add(source);
        while (!que.isEmpty()){
            Node itr = que.poll();
            visited[itr.i][itr.j] = true;
            if(itr.i - 1 >= 0){
                if(dist[itr.i-1][itr.j] > dist[itr.i][itr.j]+1){
                    dist[itr.i-1][itr.j] = dist[itr.i][itr.j]+1;
                }
                if(visited[itr.i-1][itr.j] == false){
                    que.add(new Node(itr.i-1, itr.j));
                }
            }
            if(itr.i + 1 < mat.length){
                if(dist[itr.i+1][itr.j] > dist[itr.i][itr.j]+1){
                    dist[itr.i+1][itr.j] = dist[itr.i][itr.j]+1;
                }
                if(visited[itr.i+1][itr.j] == false){
                    que.add(new Node(itr.i+1, itr.j));
                }
            }
            if(itr.j - 1 >= 0){
                if(dist[itr.i][itr.j-1] > dist[itr.i][itr.j]+1){
                    dist[itr.i][itr.j-1] = dist[itr.i][itr.j]+1;
                }
                if(visited[itr.i][itr.j-1] == false){
                    que.add(new Node(itr.i, itr.j-1));
                }
            }
            if(itr.j + 1 < mat[0].length){
                if(dist[itr.i][itr.j+1] > dist[itr.i][itr.j]+1){
                    dist[itr.i][itr.j+1] = dist[itr.i][itr.j]+1;
                }
                if(visited[itr.i][itr.j+1] == false){
                    que.add(new Node(itr.i, itr.j+1));
                }
            }
        }
    }
}
