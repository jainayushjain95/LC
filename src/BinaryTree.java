import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
}

public class BinaryTree {

    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        inorderTraversalSolve(root, list);
        return list;
    }

    public void inorderTraversalSolve(TreeNode root, List<Integer> list) {
       if(root == null) {
           return;
       }

       inorderTraversalSolve(root.left, list);
       list.add(root.val);
       inorderTraversalSolve(root.right, list);

    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        return isSymmetricSolve(root.left, root.right);
    }

    public boolean isSymmetricSolve(TreeNode rootLeft, TreeNode rootRight) {
        if(rootLeft == null && rootRight == null) {
            return true;
        }
        if(rootLeft == null || rootRight == null) {
            return false;
        }
        return rootLeft.val == rootRight.val && isSymmetricSolve(rootLeft.left, rootRight.right) && isSymmetricSolve(rootLeft.right, rootRight.left);
    }
}
