public class MaximumSubarraySum {
    public static void main(String[] args) {
        System.out.println(maxSumAfterOperation(new int[]{2,-1,3,4,-10,2}));
    }

    public static int maxSumAfterOperation(int[] nums) {
        int[] sums = new int[nums.length+1];
        for(int i=1; i<nums.length+1;i++){
            sums[i] = sums[i-1]+nums[i-1];
        }
        for(int i=1; i<nums.length+1;i++){
            sums[i] = sums[i-1]+nums[i-1];
        }
        int max = Integer.MIN_VALUE;
        int indexi = 0;
        int indexj = 0;
        for(int i=0;i<sums.length-1;i++){
            for(int j=i+1;j<sums.length;j++){
                if(sums[j]-sums[i] > max){
                    max = sums[j] - sums[i];
                    indexi = i;
                    indexj = j-1;
                }
            }
        }
        int ans = Integer.MIN_VALUE;
        int index = 0;
        for (int i=indexi;i<=indexj;i++){
            if(Math.abs(nums[i]) > ans){
                ans = Math.abs(nums[i]);
                index = i;
            }
        }
        if(nums[index] < 0){
            max += Math.abs(nums[index])*(Math.abs(nums[index])+1);
        }else{
            max += Math.abs(nums[index])*(Math.abs(nums[index])-1);
        }
        return max;
    }
}
