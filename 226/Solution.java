 public class Solution {
 
    public TreeNode invertTree(TreeNode node) {
    
        if(node == null) return node;
        
        TreeNode temp = invertTree(node.left);
        node.left = invertTree(node.right);
        node.right = temp;

        return node;
    }
 
 }
