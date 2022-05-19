public class PalindromePartition {
    private static int[][] dp = new int[101][101];
    public static void main(String[] args) {
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                dp[i][j] = -1;
            }
        }
        String input = "butterfly";
        System.out.println(palindrome(input,0,input.length()-1));
    }

    public static int palindrome(String s,int i,int j){
        if(i == j){
            dp[i][j] = 0;
            return 0;
        }
        if(isPalindrome(s,i,j)){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int ans = Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            if(isPalindrome(s,i,k) && isPalindrome(s,k+1,j)){
                return 1;
            }else{
                int sol1 = palindrome(s,i,k);
                int sol2 = palindrome(s,k+1,j);
                int sol = sol1 + sol2 + 1;
                if(ans > sol){
                    ans = sol;
                }
            }
        }
        dp[i][j] = ans;
        return ans;
    }

    public static boolean isPalindrome(String input,int start, int end){
        if(input.isEmpty()) return false;
//        if(input.isBlank()) return false;
        start--;
        end++;
        while(start < end){
            start++;
            end--;
            if(input.charAt(start) != input.charAt(end)){
                return false;
            }
        }
        return true;
    }
}
