public class LongestRepeatingSubsequence {
    public static void main(String[] args) {
        System.out.println(longestRepeatingSubsequence("AABEBCDD","AABEBCDD",8,8));
    }

    public static int longestRepeatingSubsequence(String s1,String s2, int length1, int length2){
        if(length1 == 0 || length2 == 0){
            return 0;
        }
        if(s1.charAt(length1-1) == s2.charAt(length2-1) && length1 != length2){
            return 1 + longestRepeatingSubsequence(s1,s2,length1-1,length2-1);
        }else{
            return Math.max(longestRepeatingSubsequence(s1,s2,length1-1,length2),longestRepeatingSubsequence(s1,s2,length1,length2-1));
        }
    }
}
