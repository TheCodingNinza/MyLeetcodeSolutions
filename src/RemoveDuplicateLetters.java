import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateLetters {
    Set<Character> set;
    public String removeDuplicateLetters(String s) {
        set = new HashSet<>();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(set.contains(s.charAt(i))){
                ans.append(s.charAt(i));
            }else{
                set.add(s.charAt(i));
            }
        }
        return ans.toString();
    }
}
