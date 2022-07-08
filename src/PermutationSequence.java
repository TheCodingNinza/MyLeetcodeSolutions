import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PermutationSequence {
    private boolean[] numbersAlreadyUsed;

    public String getPermutation(int n, int k) {
        numbersAlreadyUsed = new boolean[10];
        Map<Integer,Integer> fact = new HashMap<>();
        fact.put(9,362880);
        fact.put(8,40320);
        fact.put(7,5040);
        fact.put(6,720);
        fact.put(5,120);
        fact.put(4,24);
        fact.put(3,6);
        fact.put(2,2);
        fact.put(1,1);
        int factorialValue = fact.get(n);
        StringBuilder sb = new StringBuilder();
        return recursiveAnalysis(sb, n, k, factorialValue,n);
    }

    private String recursiveAnalysis(StringBuilder input, int n, int k, int factorialValue, int originalN) {
        if(input.length() == originalN){
            return input.toString();
        }
        factorialValue = factorialValue/n;
        int count = 1;
        for (int i = 1; i <= originalN; i++) {
            if(!numbersAlreadyUsed[i]){
                if((count - 1)* factorialValue <= k && k <= (count)*factorialValue){
                    numbersAlreadyUsed[i] = true;
                    k -= (count-1)*factorialValue;
                    return recursiveAnalysis(input.append(i),n-1,k,factorialValue,originalN);
                }
                count++;
            }
        }
        return "";
    }

    public static void main(String[] args) {

    }
}
