public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int area = Integer.MIN_VALUE;
        int start  = 0, end = height.length-1;
        while (start < end){
            int currentArea = (Math.min(height[start],height[end]))*(end - start);
            area = Math.max(area,currentArea);
            if(height[start] < height[end]){
                start++;
            }else{
                end--;
            }
        }
        return area;
    }


    public static void main(String[] args) {
        int[] height  = {1,2,4,3};
        System.out.println(maxArea(height));
    }
}
