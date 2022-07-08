import java.util.Arrays;

public class TupleWithSameProduct {
    private static int combinations(int[] nums, int[] combination, int position, int start){
        for (int i = 0; i < 4; i++) {
            System.out.print(combination[i]+"\t");
        }
        System.out.println("");
        if(position == 4){
            System.out.println("1");
           if (combination[0]*combination[2] == combination[1]*combination[3]) {
                return 8;
            } else if (combination[0]*combination[3] == combination[1]*combination[2]) {
                return 8;
            }else{
                return 0;
            }
        }
        int localAns = 0;
        for (int i = start; i+3-position < nums.length; i++) {
            combination[position] = nums[i];
            localAns+= combinations(nums,combination,position+1,i+1);
        }
        return localAns;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,1,5,6};
        Arrays.sort(arr);
        int[] combination = new int[4];
        int ans = combinations(arr,combination, 0,0);
        System.out.println(ans);
    }
}
