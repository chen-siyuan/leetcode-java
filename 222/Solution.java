public class Solution {

    public int countNode(TreeNode node) {
        if(node == null) return 0;
        return 1 + countNode(node.left) + countNode(node.right);
    }

}
