import java.util.ArrayList;
import java.util.List;

class BinaryTreeUtility {
    public static boolean isRootNode(TreeNode root) {
        return root.left == null && root.right == null;
    }

    public static void inorderTraversal(TreeNode root) {
        if(root == null) {
            return;
        }

        inorderTraversal(root.left);
        System.out.println(root.val);
        inorderTraversal(root.right);
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class BinaryTree {

    TreeNode root;

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        int[] nums = {-10, -3, 0, 5, 9};
        BinaryTreeUtility.inorderTraversal(binaryTree.sortedArrayToBST(nums));
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTSolve(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayToBSTSolve(int[] nums, int beginIndex, int endIndex) {
        if(beginIndex > endIndex) {
            return null;
        }

        if(beginIndex == endIndex) {
            return new TreeNode(nums[beginIndex]);
        }

        int midIndex = (beginIndex + endIndex)/2;
        TreeNode root = new TreeNode(nums[midIndex]);
        root.left = sortedArrayToBSTSolve(nums, beginIndex, midIndex - 1);
        root.right = sortedArrayToBSTSolve(nums, midIndex + 1, endIndex);
        return root;
    }

    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        if(BinaryTreeUtility.isRootNode(root)) {
            return 1;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
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
