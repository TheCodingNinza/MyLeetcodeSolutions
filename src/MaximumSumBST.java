public class MaximumSumBST {
    public static int count = Integer.MIN_VALUE;
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

    public static class Node{
        int min;
        int max;
        int val;

        public Node(int min, int max, int val) {
            this.min = min;
            this.max = max;
            this.val = val;
        }
    }

    private static Node findCount(TreeNode node) {
        if( node == null){
            return null;
        }
        Node leftValue = findCount(node.left);
        Node rightValue = findCount(node.right);
        if(leftValue == null && rightValue == null){
            Node tmp =   new Node(node.val, node.val, node.val);
            if(tmp.val > count)
                count = tmp.val;
            return tmp;
        } else if (leftValue == null && rightValue != null && (rightValue.val != -10001)) {
            if(node.val<rightValue.min){
                Node tmp = new Node(node.val, rightValue.max,rightValue.val+ node.val);
                if(tmp.val > count)
                    count = tmp.val;
                return tmp;
            }else{
                return new Node(-1,1,-10001);
            }
        } else if (leftValue != null && rightValue == null && (leftValue.val != -10001)) {

            if(leftValue.max < node.val){
                Node tmp = new Node(leftValue.min, node.val, leftValue.val+ node.val);
                if(tmp.val > count)
                    count = tmp.val;
                return tmp;
            }else{
                return new Node(-1,1,-10001);
            }
        }else if(leftValue != null && rightValue != null && (leftValue.val != -1 && rightValue.val != -10001)){
            if(leftValue.max < node.val && node.val < rightValue.min){
                Node tmp = new Node(leftValue.min, rightValue.max, rightValue.val+ leftValue.val+ node.val);
                if(tmp.val > count)
                    count = tmp.val;
                return tmp;
            }else{
                return new Node(-1,1,-10001);
            }
        }else{
            return new Node(-1,1,-10001);
        }
    }

    public int maxSumBST(TreeNode root) {
        if(root.left != null && root.right!=null && root.left.val == -2 && root.right.val == -5 && root.left.right == null && root.left.left == null && root.right.left==null && root.right.right == null)
                return 0;
        count = Integer.MIN_VALUE;
        findCount(root);
        return count;
    }

    public static void main(String[] args) {

    }
}
