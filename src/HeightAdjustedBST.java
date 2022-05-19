public class HeightAdjustedBST {

      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
             this.right = right;
          }
     }


    public static TreeNode sortedArrayToBST(int[] nums) {
          TreeNode root = findMidAndAdd(nums,0,nums.length-1);
          return root;
    }

    public static TreeNode findMidAndAdd(int[] arr,int start, int end){
          if(start == end){
              return new TreeNode(arr[start],null,null);
          }
          if(start > end){
              return null;
          }
          int mid = -555;
          if((end - start) % 2 == 0){
              mid = (end - start )/2;
          }else{
              mid = ((end - start)/2)+1;
          }
          mid += start;
          TreeNode left = findMidAndAdd(arr,start,mid-1);
          TreeNode right = findMidAndAdd(arr,mid+1,end);
          TreeNode node = new TreeNode(arr[mid],left,right);
          return node;
    }

    public static void main(String[] args) {
        int[] nums = {-10};
        sortedArrayToBST(nums);
        System.out.println("done");
    }
}
