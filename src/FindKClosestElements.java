import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindKClosestElements {
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        int start = -1;
        for (int i = 0; i < arr.length && arr[i] <=x; i++)start = i;
        int end  = start+1;
        System.out.println("start : "+start);
        System.out.println("end : "+end);
        int count = 0;
        while(count<k){
            if(start>=0 && end <= arr.length-1){
                if(Math.abs(x-arr[start]) <= Math.abs(x-arr[end])){
                    start--;
                }else{
                    end++;
                }
            } else if (start<0) {
                end++;
            } else if (end > arr.length-1) {
                start--;
            }
            count++;
        }
        start++;
        end--;
        for (int i = start; i <= end ; i++) {
            ans.add(arr[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int k = 4;
        int x = 3;
        List<Integer> ans;
        ans = findClosestElements(arr,k,x);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i)+"\t");
        }
        System.out.println("");
    }
}
