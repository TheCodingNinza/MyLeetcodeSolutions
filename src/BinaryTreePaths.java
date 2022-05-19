import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class BinaryTreePaths {
    public class TreeNode {
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
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = recursive(root);
        return ans;
    }

    private static List<String> recursive(TreeNode node) {
        if(node.left == null && node.right == null){
            List<String> tmp = new ArrayList<>();
            tmp.add(String.valueOf(node.val));
            return tmp;
        }
        List<String> ans = new ArrayList<>();
        List<String> rightChild = new ArrayList<>();
        if(node.right!=null)
                rightChild = recursive(node.right);
        List<String> leftChild = new ArrayList<>();
        if(node.left != null)
                leftChild = recursive(node.left);
        for (int i = 0; i < rightChild.size(); i++) {
            ans.add(node.val+"->"+rightChild.get(i));
        }
        for (int i = 0; i < leftChild.size(); i++) {
            ans.add(node.val+"->"+leftChild.get(i));
        }
        return ans;
    }

    public static void main(String args[]){

    }


}
