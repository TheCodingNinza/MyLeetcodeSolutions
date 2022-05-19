public class MatrixMultiplication {
    static int[][] dp = new int[100][100];
    public static void main(String[] args) {
        int[] arr = new int[] {2,5,6,7};

        System.out.println(solve(arr,0,arr.length-2));
    }

    public static int solve(int[] arr, int i,int j){
        System.out.println("Value of i : "+i+" and the value of j: "+j);
        if( i == j ){
//            System.out.println("returning 0");
            dp[i][j] = 0;
            return 0;
        }
        if(dp[i][j] != 0){
            return dp[i][j];
        }
        int mn = Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int tmpCost1 = solve(arr,i,k);
            int tmpCost2 = solve(arr,k+1, j);
            int tmpCost = arr[i]*arr[k+1]*arr[j+1];
            tmpCost += tmpCost1 + tmpCost2;

            if(mn > tmpCost){
                mn = tmpCost;
            }
        }
//        System.out.println("returning "+mn);
        dp[i][j] = mn;
        return mn;
    }
}
