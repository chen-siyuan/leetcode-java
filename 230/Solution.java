public class Solution {

    public static int count;
    public static TreeNode res;

    public static void search(TreeNode node) {
    
        if(node == null) return;

        search(node.left);

        if(--count == 0) res = node;

        if(res == null) search(node.right);
    
    }

    public int kthSmallest(TreeNode root, int k) {
    
        count = k;
        res = null;

        search(root);

        return res.val;
    }

}
