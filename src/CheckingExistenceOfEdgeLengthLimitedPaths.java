import java.util.*;

public class CheckingExistenceOfEdgeLengthLimitedPaths {


    public static boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        boolean[] ans = new boolean[queries.length];
        int[] arr = new int[n];
        Arrays.fill(arr,-1);
        Arrays.sort(queries, Comparator.comparingInt(a -> a[2]));
        HashMap<int[], Integer> dp = new HashMap<>();
        for(int[] query: queries){
            System.out.println(query[0]+", "+query[1]+", "+query[2]);
            System.out.println("");
        }
        int[][] adjMatrix = new int[n][n];
        for (int[] row: adjMatrix)
            Arrays.fill(row,-1);
        for (int[] edge: edgeList){
            if(adjMatrix[edge[0]][edge[1]] == -1 ){
                union(arr,edge[0],edge[1]);
                adjMatrix[edge[0]][edge[1]] = edge[2];
                adjMatrix[edge[1]][edge[0]] = edge[2];
            }else{
                if(edge[2] < adjMatrix[edge[0]][edge[1]] ){
                    adjMatrix[edge[0]][edge[1]] = edge[2];
                    adjMatrix[edge[1]][edge[0]] = edge[2];
                }
            }
        }
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i]+"\t");
//        }
//        System.out.println("");
        for (int i = 0; i < queries.length; i++) {
            if(dp.containsKey(new int[] {queries[i][0],queries[i][2]})){
                if(dp.get(new int[] {queries[i][0],queries[i][2]}) < queries[i][2]){
                    ans[i] = true;
                }
            }
            if(parent(arr,queries[i][0]) != parent(arr,queries[i][1]))
                ans[i] = false;
            else{
                boolean answer = bfs(adjMatrix,queries[i][0],queries[i][1],queries[i][2]);
                if(answer){
                    dp.put(new int[]{queries[i][0],queries[i][2]},queries[i][2]);
                }
                ans[i] = answer;
            }

        }

        return ans;
    }

    public static void union(int[] arr, int nodeA, int nodeB){
        int p1 = parent(arr,nodeA);
        int p2 = parent(arr,nodeB);
        if(p1!=p2){
            arr[p2] = p1;
        }
    }

    public static int parent(int[] arr,int node){
        int itr = node;
        while(arr[itr] != -1){
            itr = arr[itr];
        }
        return itr;
    }

    public static boolean bfs(int[][] adjMatrix, int src, int dest, int limit){
        boolean[] visited = new boolean[adjMatrix.length];
        Queue<Integer> que = new LinkedList<>();
        que.add(src);
        while (!que.isEmpty()){
            int itr = que.poll();
            visited[itr] = true;
            for (int j = 0; j < adjMatrix[0].length; j++) {
                if(adjMatrix[itr][j] != -1) {
                  if(adjMatrix[itr][j] < limit){
                      if(visited[j] == false){
                          que.add(j);
                      }
                  }
                }
            }
        }
        return visited[dest];
    }

    public static void main(String[] args) {
        int n = 30;
        int[][] edgeList = {{0,1,2},{1,2,4},{2,0,8},{1,0,16}};
        int[][] queries = {{0,2,5},{0,1,2}};

        boolean[] ans = distanceLimitedPathsExist(n,edgeList,queries);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i]+"\t");
        }
        System.out.println("");
    }
}
