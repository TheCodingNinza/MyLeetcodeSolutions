import java.util.*;

public class HummingDistance {

    public static class DSU {
        int[] arr;

        public DSU(int n) {
            this.arr = new int[n];
            Arrays.fill(arr, -1);
        }

        public int findParent(int node) {
            int iterator = node;
            while (this.arr[iterator] != -1) {
                iterator = this.arr[iterator];
            }
            return iterator;
        }

        public void union(int nodeA, int nodeB) {
            int parentA = findParent(nodeA);
            int parentB = findParent(nodeB);
            if (parentA != parentB) {
                this.arr[parentB] = parentA;
            }
        }

        public List<Integer> allParents(){
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < this.arr.length; i++) {
                if(this.arr[i] == -1){
                    ans.add(i);
                }
            }
            return ans;
        }
    }

    public static int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int ans = 0;
        DSU dsu = new DSU(source.length);
        for(int[] allowedSwap: allowedSwaps){
            dsu.union(allowedSwap[0],allowedSwap[1]);
        }
        for (int i = 0; i < dsu.arr.length; i++) {
            System.out.print(dsu.arr[i]+"\t");
        }
        System.out.println("");
        List<Integer> parents = dsu.allParents();
        Map<Integer, ArrayList<Integer>> groups = new HashMap<>();
        for (int i = 0; i < parents.size(); i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(parents.get(i));
            groups.put(parents.get(i),temp);
        }
        for (int i = 0; i < dsu.arr.length; i++) {
            if(dsu.arr[i] != -1){
                int value = dsu.findParent(i);
                ArrayList<Integer> temp = groups.get(value);
                temp.add(i);
                groups.put(dsu.findParent(i),temp);
            }
        }
//        System.out.println("Group");
//        for (Map.Entry<Integer, ArrayList<Integer>> entry: groups.entrySet()){
//            System.out.println("Key: "+entry.getKey());
//            System.out.print("Value: ");
//            for (int i = 0; i < entry.getValue().size(); i++) {
//                System.out.print(entry.getValue().get(i)+"\t");
//            }
//            System.out.println("");
//        }
        for (Map.Entry<Integer, ArrayList<Integer>> entry: groups.entrySet()){
            Map<Integer,Integer> sourceMap = new HashMap<>();
            Map<Integer,Integer> targetMap = new HashMap<>();
            ArrayList<Integer> temp = entry.getValue();
            for (int i = 0; i < temp.size(); i++) {
                int index = temp.get(i);
                sourceMap.put(source[index],sourceMap.getOrDefault(source[index],0)+1);
                targetMap.put(target[index],targetMap.getOrDefault(target[index],0)+1);
            }
//            System.out.println("SourceMap");
//            for (Map.Entry<Integer, Integer> entrySource: sourceMap.entrySet()){
//                System.out.print("Key: "+entrySource.getKey()+"\t");
//                System.out.print("Value: "+entrySource.getValue());
//                System.out.println("");
//            }
//            System.out.println("TargetMap");
//            for (Map.Entry<Integer, Integer> entryTarget: targetMap.entrySet()){
//                System.out.print("Key: "+entryTarget.getKey()+"\t");
//                System.out.print("Value: "+entryTarget.getValue());
//                System.out.println("");
//            }
            for(Map.Entry<Integer,Integer> comparisonEntry: targetMap.entrySet()){
                System.out.println(comparisonEntry.getKey());
                if(!sourceMap.containsKey(comparisonEntry.getKey())){
                    ans += comparisonEntry.getValue();
                }else{
                    int value = comparisonEntry.getValue() - sourceMap.get(comparisonEntry.getKey());
                    if(value >= 0)
                        ans += Math.abs(sourceMap.get(comparisonEntry.getKey()) - comparisonEntry.getValue());
                }
            }
        }

//        for (Map.Entry<Integer, ArrayList<Integer>> entry: groups.entrySet()){
//            System.out.println("Key: "+entry.getKey());
//            System.out.print("Value: ");
//            for (int i = 0; i < entry.getValue().size(); i++) {
//                System.out.print(entry.getValue().get(i)+"\t");
//            }
//            System.out.println("");
//        }
        return ans;
    }

    public static void main(String[] args) {
        int[] src = {1,2,3,4};
        int[] target = {1,3,2,4};
        int[][] allowedSwaps = {};
        int ans  = minimumHammingDistance(src,target,allowedSwaps);
        System.out.println("Answer : "+ans);
    }
}
