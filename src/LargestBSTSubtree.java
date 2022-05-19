public class LargestBSTSubtree {
    public static int count = Integer.MIN_VALUE;
    public static class TreeNode {
        int val;
        LargestBSTSubtree.TreeNode left;
        LargestBSTSubtree.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, LargestBSTSubtree.TreeNode left, LargestBSTSubtree.TreeNode right) {
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


    public static int largestBSTSubtree(TreeNode root) {
        if(root == null){
            return 0;
        }
        findCount(root);
        return count;
    }

    private static Node findCount(TreeNode node) {
        if( node == null){
            return null;
        }
        Node leftValue = findCount(node.left);
        Node rightValue = findCount(node.right);
        if(leftValue == null && rightValue == null){
            Node tmp =   new Node(node.val, node.val, 1);
            if(tmp.val > count)
                count = tmp.val;
            return tmp;
        } else if (leftValue == null && rightValue != null && (rightValue.val != -10001)) {
            if(node.val<rightValue.min){
                Node tmp = new Node(node.val, rightValue.max,rightValue.val+1);
                if(tmp.val > count)
                    count = tmp.val;
                return tmp;
            }else{
                return new Node(-1,1,-10001);
            }
        } else if (leftValue != null && rightValue == null && (leftValue.val != -10001)) {

            if(leftValue.max < node.val){
                Node tmp = new Node(leftValue.min, node.val, leftValue.val+1);
                if(tmp.val > count)
                    count = tmp.val;
                return tmp;
            }else{
                return new Node(-1,1,-10001);
            }
        }else if(leftValue != null && rightValue != null && (leftValue.val != -1 && rightValue.val != -10001)){
            if(leftValue.max < node.val && node.val < rightValue.min){
                Node tmp = new Node(leftValue.min, rightValue.max, rightValue.val+ leftValue.val+1);
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


}
