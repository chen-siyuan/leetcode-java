public class Solution {

    public void flatten(TreeNode node) {
    
        if(node == null || (node.left == null && node.right == null)) return;

        flatten(node.left);
        flatten(node.right);
        
        if(node.left == null) return;

        TreeNode temp = node.left;
        
        while(temp.right != null) temp = temp.right;
    
        temp.right = node.right;
        node.right = node.left;
        node.left = null;

    }

}
