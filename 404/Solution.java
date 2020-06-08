public class Solution {

    public static int DFS(TreeNode node, boolean flag) {

        if(node == null) return 0;
        if(node.left == null && node.right == null) return flag ? node.val : 0;

        return DFS(node.left, true) + DFS(node.right, false);
    }

    public int sumOfLeftLeaves(TreeNode root) {
        return DFS(root, false);
    }

}
