public class Main {
    public static void main(String[] args) {
        System.out.println(countPalindromeSequence("abcdefghfedcbaa"));
    }

    public static int countPalindromeSequence(String s){
        StringBuilder sb=new StringBuilder(s);
        sb.reverse();
        String s2 =  sb.toString();
        int ans = lcs(s,s2,s.length(),s2.length());
        return ans;
    }

    public static int lcs(String s1, String s2, int length1, int length2){
        if(length1 == 0 || length2 == 0){
            return 0;
        }
        if(s1.charAt(length1-1) == s2.charAt(length2-1)){
            return 1 + lcs(s1,s2,length1-1,length2-1);
        }else{
            return Math.max(lcs(s1,s2,length1-1,length2),lcs(s1,s2,length1,length2-1));
        }
    }
}
