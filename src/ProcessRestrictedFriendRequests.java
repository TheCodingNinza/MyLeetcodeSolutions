public class ProcessRestrictedFriendRequests {
    public static void main(String[] args) {
        int n = 7;
        int[][] restrictions = {{0,6},{6,2}};
        int[][] requests = {{0,2},{2,3},{0,2},{6,4},{6,4}};
        boolean[] ans = friendRequests(n,restrictions,requests);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i]+"\t");
        }
        System.out.println("");
    }
    public static boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = -1;
        }
        boolean[] ans = new boolean[requests.length];
        int count = 0;
        for(int[] request: requests){
            int pi = findParent(request[0],arr);
            int pj = findParent(request[1],arr);
            boolean isValid = true;
            if(pi != pj){
                for(int[] restriction: restrictions){
                    int px = findParent(restriction[0],arr);
                    int py = findParent(restriction[1],arr);
                    if (pi == px && pj == py || pi == py && pj == px) {
                        isValid = false;
                        break;
                    }
                }
            }
            ans[count] = isValid;
            if (isValid && pi!=pj)
                union(pi,pj,arr);
            count++;
        }
        return ans;
    }

    public static void union(int node1, int node2, int[] arr) {
        arr[node2] = node1;
    }

    public static int findParent(int i, int[] arr) {
        int itr = i;
        while (arr[itr] != -1){
            itr = arr[itr];
        }
        return itr;
    }


}
