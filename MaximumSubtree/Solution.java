package MaximumSubtree;

import Util.TreeNode;

/**
 * Created by whong53 on 2/27/17.
 */
public class Solution {
    /**
     * Given a binary tree, find the subtree with maximum sum. Return the root of the subtree.
     *
     * @param root the root of binary tree
     * @return the maximum weight node
     */

    public TreeNode result = null;
    public int max = Integer.MIN_VALUE;

    public TreeNode findSubtree(TreeNode root) {
        helper(root);
        return result;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        if (result == null || left + right + root.val > max) {
            max = left + right + root.val;
            result = root;
        }
        return left + right + root.val;
    }
}
