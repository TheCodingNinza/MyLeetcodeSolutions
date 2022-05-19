public class SolvingQuestionsWithBrainpower {
    public static void main(String[] args) {
        int[][] arr = new int[][] {{1,1}};
        int ans = solve(arr,0);
        System.out.println("The answer is "+ans);
    }

    public static int solve(int[][] arr,int dist){
        if(dist >= arr.length){
            return 0;
        }
        int tmpAns = Math.max(solve(arr,dist+1),arr[dist][0]+solve(arr,dist+1+arr[dist][1]));
        System.out.println("The tmpAns is "+tmpAns);
        return tmpAns;
    }
}
