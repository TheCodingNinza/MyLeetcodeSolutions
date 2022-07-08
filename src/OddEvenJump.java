import javafx.util.Pair;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class OddEvenJump {

    private static Map<Integer, Pair<Integer,Integer>> dpOddEven;

    private static int[] smallest;

    private static int count = 0;
    private static int[] largest;
    public static int oddEvenJumps(int[] arr) {
        dpOddEven = new HashMap<>();
        smallest = new int[arr.length];
        largest = new int[arr.length];
        Arrays.fill(smallest,-1);
        Arrays.fill(largest,-1);
        smallest[arr.length-1] = arr.length-1;
        largest[arr.length-1] = arr.length-1;
        int ans = 0;
        for (int i=arr.length-1;i>=0;i--) {
            if(i == arr.length-1){
                dpOddEven.put(arr.length-1,new Pair<>(1,1));
                continue;
            }

            int indexOdd = oddNumberedJump(i,arr);
            int indexEven = evenNumberedJump(i,arr);
            int pairA;
            int pairB;
            System.out.println("indexOdd : "+indexOdd);
            if(indexOdd == arr.length-1){
                pairA = 1;
            }else if(indexOdd == i){
                pairA = 0;
            }else if(dpOddEven.get(indexOdd).getValue() == 1){
                pairA = 1;
            }else{
                pairA = 0;
            }

            if(indexEven == arr.length-1){
                pairB = 1;
            }else if(indexEven == i){
                pairB = 0;
            }else if(dpOddEven.get(indexEven).getKey() == 1){
                pairB = 1;
            }else{
                pairB = 0;
            }
            dpOddEven.put(i,new Pair<>(pairA,pairB));

        }
        for(Map.Entry<Integer,Pair<Integer,Integer>> entry: dpOddEven.entrySet()){
            System.out.println("Key : "+entry.getKey()+" Value : "+entry.getValue().getKey()+", "+entry.getValue().getKey());
        }
        for (int i = 0; i < arr.length; i++) {
            if(dpOddEven.get(i).getKey() == 1){
                ans++;
            }
        }
        return ans;
    }

    

    private static int oddNumberedJump(int i, int[] arr) {
        count++;
        if(i == arr.length-1){
            return arr.length-1;
        }

        if(smallest[i+1] == i+1){
            if(arr[i] > arr[i+1]){
                smallest[i] = i;
            }else{
                smallest[i] = i+1;
            }
        }else{
            if(arr[i] <= arr[i+1]){
                smallest[i] = i+1;
            }else{
                for (int j = i+2; j < arr.length; j++) {
                    if(arr[i] <= arr[j]){
                        if(arr[smallest[j]] == arr[j]){
                            smallest[i] = j;
                        }
                        smallest[i] = j;
                    }
                }
            }
        }
//        System.out.println("i : "+i);
//        System.out.println("smallestIndex : "+smallestIndex);
        return smallest[i];
    }

    private static int evenNumberedJump(int i, int[] arr) {
        count++;
        if(i == arr.length-1){
            return arr.length-1;
        }

        if(largest[i]!= -1){
            return largest[i];
        }

        int start = i+1;
        boolean init = true;
        int largestValue = arr[i];
        int largestIndex = i;
        for (int j = start; j < arr.length; j++) {
            if(arr[i] >= arr[j]){
                if(init){
                    largestValue = arr[j];
                    largestIndex = j;
                    init = false;
                    continue;
                }

                if(largestValue<arr[j]){
                    largestValue = arr[j];
                    largestIndex = j;
                }
            }
        }
        largest[i] = largestIndex;
        return largestIndex;
    }


    public static void main(String[] args) {
        int[] arr = {2,3,1,1,4};
        int ans = oddEvenJumps(arr);
        for (int i = 0; i < smallest.length; i++) {
            System.out.print(smallest[i]+"\t");
        }
        System.out.println("");
        System.out.println("Answer : "+ans);
        System.out.println("Count : "+count);
    }

}
