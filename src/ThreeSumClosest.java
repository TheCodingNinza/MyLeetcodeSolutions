import java.util.Arrays;

public class ThreeSumClosest {

    public static int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE;
        int ans = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            int start = i+1;
            int end = nums.length-1;
            int sum;
            while (start<end){
               sum = nums[i]+nums[start]+nums[end];
               if(target == sum){
                   return target;
               } else if (Math.abs(sum-target) < diff) {
                   diff = Math.abs(sum-target);
                   ans = sum;
               }
               if(sum>target)end--;
               else start++;
            }
        }
        return ans;
    }




    public static void main(String[] args) {
        int[] nums = {-1,2,1};
        int target = 1;
        int ans = threeSumClosest(nums,target);
        System.out.println(ans);
    }
}
