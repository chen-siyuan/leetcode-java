import java.util.*;

public class Solution {

    public List<Integer> postorderTraversal(TreeNode root) {
    
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        List<Integer> res = new ArrayList<>();

        while(stack.size() != 0) {
            
            TreeNode curr = stack.pop();
            if(curr == null) continue;
            
            res.add(0, curr.val);
        
            stack.push(curr.left);
            stack.push(curr.right);
        
        }
    
        return res;
    }

}
