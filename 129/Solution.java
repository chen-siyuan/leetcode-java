public class Solution {

    public static int sum;

    public static void DFS(TreeNode node, int count) {

        if(node == null) return;
        if(node.left == null && node.right == null) {
            sum += count * 10 + node.val;
            return;
        }

        DFS(node.left, count * 10 + node.val);
        DFS(node.right, count * 10 + node.val);
    
    }

    public int sumNumbers(TreeNode root) {
    
        sum = 0;

        DFS(root, 0);

        return sum;
    }

}
