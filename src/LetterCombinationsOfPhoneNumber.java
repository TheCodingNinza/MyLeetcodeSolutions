import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfPhoneNumber {
    static List<String> ans;
    public static List<String> letterCombinations(String digits) {
        Map<Integer, char[]> map = new HashMap<>();
        map.put(2,new char[]{'a','b','c'});
        map.put(3,new char[]{'d','e','f'});
        map.put(4,new char[]{'g','h','i'});
        map.put(5,new char[]{'j','k','l'});
        map.put(6,new char[]{'m','n','o'});
        map.put(7,new char[]{'p','q','r','s'});
        map.put(8,new char[]{'t','u','v'});
        map.put(9,new char[]{'w','x','y','z'});
        List<char[]> parameters = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
                parameters.add(map.get(Integer.parseInt(digits.substring(i,i+1))));
        }
        ans = new ArrayList<>();
        recursiveFind(parameters,0,"");
        return ans;
    }

    private static void recursiveFind(List<char[]> parameters, int index, String incomingValue) {
        if(index < parameters.size() - 1){
            for (int i = 0; i < parameters.get(index).length; i++) {
                recursiveFind(parameters,index+1, incomingValue+ parameters.get(index)[i]);
            }
        }else if( index == parameters.size()-1){
            for (int i = 0; i < parameters.get(index).length; i++) {
                ans.add(incomingValue+parameters.get(index)[i]);
            }
        }
    }

    public static void main(String[] args) {
        List<String> ans = letterCombinations("9334263863");
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }
}
