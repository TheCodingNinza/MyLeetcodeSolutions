import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShortestUnsortedContinuousSubarray {
    public static int findUnsortedSubarray(int[] nums) {
        int[] sortedArray = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sortedArray[i] = nums[i];
        }
        Arrays.sort(sortedArray);
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=sortedArray[i]){
                arr.add(i);
            }
        }
        if(arr.size()>=2)
            return arr.get(arr.size()-1) - arr.get(0)+1;
        else
            return 0;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        System.out.println(findUnsortedSubarray(arr));
    }
}
