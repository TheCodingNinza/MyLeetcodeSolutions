public class SumOfNodesWithEvenValuedGrandparent {


      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;

          TreeNode() {
          }

          TreeNode(int val) {
              this.val = val;
          }

          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }




    public static int sumEvenGrandparent(TreeNode root) {
        int ans = recursion(root,-1,-1);
        return ans;
    }

    public static int recursion(TreeNode node, int grandparent, int parent){
          if(node == null){
              return 0;
          }
          int leftChild = recursion(node.left, parent, node.val);
          int rightChild = recursion(node.right, parent, node.val);
          if(grandparent%2 == 0){
              return leftChild+rightChild+ node.val;
          }else{
              return leftChild+rightChild;
          }
    }
}
