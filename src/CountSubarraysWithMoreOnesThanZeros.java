public class CountSubarraysWithMoreOnesThanZeros {
    private static int[] sums;
    public static int subarraysWithMoreZerosThanOnes(int[] nums) {
        sums = new int[nums.length+1];
        sums[0] = 0;
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i-1]+nums[i-1];
        }
        int ans = recursive(nums,nums.length-1);
        return ans;
    }

    private static int recursive(int[] nums, int i) {
        if(i== 0){
            if(nums[0] == 1){
                return 1;
            }else{
                return 0;
            }
        }
        int ans = 0;
        int localAns = recursive(nums,i-1);
        if(nums[i] == 1) {
            ans++;
        }
        ans += localAns;
        return ans;
    }

    public static void main(String[] args) {

        int[] arr = {0,1,1,0,1};
        int ans = subarraysWithMoreZerosThanOnes(arr);
        System.out.println("Answer : "+ans);
    }


}
