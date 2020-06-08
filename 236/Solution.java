public class Solution {

    public static boolean isAncestor(TreeNode root, TreeNode node) {
        if(root == null) return false;
        return root == node || isAncestor(root.left, node) || isAncestor(root.right, node);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == p || root == q || (isAncestor(root.left, p) && isAncestor(root.right, q)) || (isAncestor(root.right, p) && isAncestor(root.left, q))) return root;
        return isAncestor(root.left, p) ? lowestCommonAncestor(root.left, p, q) : lowestCommonAncestor(root.right, p, q);
    }

}
