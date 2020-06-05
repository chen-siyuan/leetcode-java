import java.util.*;

public class Solution {

    public List<Integer> preorderTraversal(TreeNode root) {
    
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        List<Integer> res = new ArrayList<>();

        while(stack.size() != 0) {
        
            TreeNode curr = stack.pop();
            if(curr == null) continue;
            
            res.add(curr.val);

            stack.push(curr.right);
            stack.push(curr.left);

        }

        return res;
    }

}
