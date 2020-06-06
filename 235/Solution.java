public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val == p.val || root.val == q.val || (root.val < p.val && root.val > q.val) || (root.val > p.val && root.val < q.val)) return root;
        return p.val < root.val ? lowestCommonAncestor(root.left, p, q) : lowestCommonAncestor(root.right, p, q);
    }

}
