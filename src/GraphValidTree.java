import java.util.Arrays;

public class GraphValidTree {
    public class DSU{
        int[] arr;

        public  DSU(int n) {
            this.arr = new int[n];
            Arrays.fill(this.arr,-1);
        }

        public int findParent(int node){
            int itr = node;
            while(this.arr[itr]!=-1){
                itr = this.arr[itr];
            }
            return itr;
        }

        public void union(int nodeA, int nodeB){
            int pA = findParent(nodeA);
            int pB = findParent(nodeB);
            this.arr[pB] = pA;
        }

        public boolean ifNodesAlreadyHaveSameParent(int nodeA, int nodeB){
            int pA = findParent(nodeA);
            int pB = findParent(nodeB);
            if (pA == pB)
                return true;
            else
                return false;
        }

        public int countParents(){
            int count = 0;
            for (int i = 0; i < this.arr.length; i++) {
                if(this.arr[i] == -1)
                    count++;
            }
            return count;
        }
    }

    public boolean validTree(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        for(int[] edge: edges){
            if(dsu.ifNodesAlreadyHaveSameParent(edge[0],edge[1]))
                return false;
            else
                dsu.union(edge[0],edge[1]);
        }
        int countOfParent = dsu.countParents();
        if(countOfParent != 1)
            return false;
        return true;
    }
}
