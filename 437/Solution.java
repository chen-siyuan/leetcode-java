public class Solution {

    public static int target;
    public static int res;
    

    public static void DFS(TreeNode node, int curr, boolean flag) {
        
        if(node == null) return;
        if(node.val + curr == target) res++;

        DFS(node.left, node.val + curr, false);
        DFS(node.right, node.val + curr, false);
        if(flag) DFS(node.left, 0, true);
        if(flag) DFS(node.right, 0, true);
    
    }

    public int pathSum(TreeNode root, int sum) {
    
        target = sum;
        res = 0;
        DFS(root, 0, true);

        return res;
    }

}
