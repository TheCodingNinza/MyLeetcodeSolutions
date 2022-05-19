import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInAString {

    public static List<Integer> findAnagrams(String s, String p) {
        if(p.length() > s.length()){
            return new ArrayList<Integer>();
        }
        int[] pattern = new int[26];
        int[] originStringWindow = new int[26];
        Arrays.fill(pattern,0);
        Arrays.fill(originStringWindow,0);
        for (int i = 0; i < p.length(); i++) {
            pattern[(int)p.charAt(i) - (int)'a'] += 1;
        }
        int start = 0;
        int end;
        for (end = start; end-start+1 <= p.length() ; end++) {
            originStringWindow[(int)s.charAt(end) - (int)'a'] += 1;
        }
        List<Integer> ans = new ArrayList<>();
        end--;
        for (;end < s.length();end++,start++){
            if(start != 0){
                originStringWindow[(int)s.charAt(start-1) - (int)'a'] -= 1;
                originStringWindow[(int)s.charAt(end) - (int)'a'] += 1;
            }
            if(compareAnagram(pattern,originStringWindow)){
                ans.add(start);
            }
        }
        return ans;
    }

    private static boolean compareAnagram(int[] pattern, int[] originStringWindow) {
        for (int i = 0; i < 26; i++) {
            if(pattern[i] != originStringWindow[i])
                return false;
        }
        return true;
    }


    public static void main(String[] args) {
            String s = "cbaebabacd", p =  "abc";
            List<Integer> ans = findAnagrams(s,p);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i)+"\t");
        }
        System.out.println("");
    }


}
