import java.util.*;

public class Solution {

    public static List<Integer> res; 

    public static void DFS(TreeNode node, int level) {
    
        if(node == null) return;
        
        if(res.size() == level) res.add(node.val);
        else res.set(level, node.val);

        DFS(node.left, level + 1);
        DFS(node.right, level + 1);
    
    }

    public List<Integer> rightSideView(TreeNode root) {
        
        res = new ArrayList<>();

        DFS(root, 0);

        return res;
    }

}
