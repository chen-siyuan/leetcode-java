public class Solution {

    public int skip(TreeNode node) {
        if(node == null) return 0;
        return rob(node.left) + rob(node.right);
    }

    public int rob(TreeNode node) {
        if(node == null) return 0;
        return Math.max(node.val + skip(node.left) + skip(node.right), rob(node.left) + rob(node.right));
    }

}
