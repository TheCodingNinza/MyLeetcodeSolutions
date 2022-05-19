import java.util.HashMap;
import java.util.Map;

public class BinaryTreeCameras {
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
    Map<String,Result> dp = new HashMap();


      public class Result{
          int val;
          boolean isCameraPresentOnChild;

          public Result(int val, boolean isCameraPresentOnChild) {
              this.val = val;
              this.isCameraPresentOnChild = isCameraPresentOnChild;
          }
      }

    public int minCameraCover(TreeNode root) {
        Result ans = findMinCamera(root,false);
        return ans.val;
    }

    public Result findMinCamera(TreeNode node, boolean isCameraPresentAtParent){
          if(node == null){
              return new Result(0,false);
          }
          String valueLeft = "null";
          String valueRight = "null";
          if(node.left != null){
              valueLeft = node.left.toString();
          }
          if(node.right != null){
              valueRight = node.right.toString();
          }
          if(dp.containsKey(valueLeft+"_"+valueRight+"_"+String.valueOf(isCameraPresentAtParent)))
              return dp.get(valueLeft+"_"+valueRight+"_"+String.valueOf(isCameraPresentAtParent));
          Result leftChildCameraPresentOnRoot = findMinCamera(node.left,true);
          Result leftChildCameraNotPresentOnRoot = findMinCamera(node.left,false);
          Result rightChildCameraPresentOnRoot = findMinCamera(node.right, true);
          Result rightChildCameraNotPresentOnRoot = findMinCamera(node.right,false);
          boolean firstSet = true;
          int localAns = Math.min(leftChildCameraPresentOnRoot.val+rightChildCameraPresentOnRoot.val+1, leftChildCameraNotPresentOnRoot.val+rightChildCameraNotPresentOnRoot.val);
          if(localAns != leftChildCameraPresentOnRoot.val+rightChildCameraPresentOnRoot.val+1){
              firstSet = false;
          }
          if(firstSet){
              Result tmp =  new Result(localAns,true);
              dp.put(valueLeft+"_"+valueRight+"_"+String.valueOf(isCameraPresentAtParent),tmp);
              return tmp;
          }else{
              if (isCameraPresentAtParent == true){
                  Result tmp = new Result(leftChildCameraNotPresentOnRoot.val+rightChildCameraNotPresentOnRoot.val,false);
                  dp.put(valueLeft+"_"+valueRight+"_"+String.valueOf(isCameraPresentAtParent),tmp);
                  return tmp;
              }else{
                  if(leftChildCameraNotPresentOnRoot.isCameraPresentOnChild == true || rightChildCameraNotPresentOnRoot.isCameraPresentOnChild == true){
                      Result tmp  = new Result(leftChildCameraNotPresentOnRoot.val+rightChildCameraNotPresentOnRoot.val,false);
                      dp.put(valueLeft+"_"+valueRight+"_"+String.valueOf(isCameraPresentAtParent),tmp);
                      return tmp;
                  }else{
                      Result tmp =  new Result(leftChildCameraPresentOnRoot.val+ rightChildCameraPresentOnRoot.val+1,true);
                      dp.put(valueLeft+"_"+valueRight+"_"+String.valueOf(isCameraPresentAtParent),tmp);
                      return tmp;
                  }
              }
          }
    }



}
