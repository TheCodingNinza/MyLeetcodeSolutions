public class ShortestSubarraySumAtleastK {
    public static void main(String[] args) {

    }

    public int shortestSubarray(int[] nums, int k) {
        int sums[] = new int[nums.length+1];
        sums[0] = 0;
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i-1] + nums[i-1];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0,j=0; j < nums.length;) {
        }
        return 1;
    }
}
