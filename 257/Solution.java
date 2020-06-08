import java.util.*;

public class Solution {

    public static List<String> cache;
    public static List<String> res;

    public static void DFS(TreeNode node) {
    
        if(node == null) return;

        cache.add(Integer.toString(node.val));

        if(node.left == null && node.right == null) {
           res.add(String.join("->", cache));
        } else {
            DFS(node.left);
            DFS(node.right);
        }
        
        cache.remove(cache.size() - 1);

    }

	public List<String> binaryTreePaths(TreeNode root) {
	    
        cache = new ArrayList<>();
        res = new ArrayList<>();

        DFS(root);

        return res;
	}

}
