import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Stream;

public class CriticalConnectionsInANetwork {

    public class Node{
        int val;
        int parent;
        int rank;

        boolean visited;

        public Node(int val, int parent, int rank, boolean visited) {
            this.val = val;
            this.parent = parent;
            this.rank = rank;
            this.visited = visited;
        }
    }
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
        public List<Integer> findAllParents(){
            List<Integer> parents = new ArrayList<>();
            int count = 0;
            for (int i = 0; i < this.arr.length; i++) {
                if(this.arr[i] == -1){
                    parents.add(i);
                }
            }
            return parents;
        }


    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> ans = new ArrayList<>();
        DSU originalNetwork = new DSU(n);
        for(List<Integer> connection: connections){
            originalNetwork.union(connection.get(0),connection.get(1));
        }
        List<Integer> parents = originalNetwork.findAllParents();

        for (int i = 0; i < parents.size(); i++) {
            List<List<Integer>> tmp  = discardEdgesFormingCycle(parents.get(i),connections,n);
            List<List<Integer>> newList = new ArrayList<>();
            Stream.of(ans, tmp).forEach(newList::addAll);
            ans = newList;
        }

        return ans;
    }

    private List<List<Integer>> discardEdgesFormingCycle(int root, List<List<Integer>> connections,int n) {
        List<List<Integer>> adjList = new ArrayList<>();
        Node[] metaData = new Node[n];
        for (int i = 0; i < n; i++) {
            adjList = new ArrayList<>();
        }
        for (int i = 0; i < connections.size(); i++) {
            adjList.get(connections.get(i).get(0)).add(connections.get(i).get(1));
            adjList.get(connections.get(i).get(1)).add(connections.get(i).get(0));
        }
        Stack<Integer> stk = new Stack<>();
        metaData[root] = new Node(root,-1,0,true);
        stk.push(root);
        while (!stk.empty()){
            int itr = stk.pop();
            List<Integer> adjNodes = adjList.get(itr);
            for (int i = 0; i < adjNodes.size(); i++) {

            }

        }
        return adjList;
    }


}
