import java.util.*;

public class BSTIterator {

    private Queue<Integer> res;

    private void DFS(TreeNode node) {
    
        if(node == null) return;

        DFS(node.left);

        res.offer(node.val);

        DFS(node.right);
    
    }

    public BSTIterator(TreeNode root) {
        res = new LinkedList<Integer>();
        DFS(root);
    }

    public int next() {
        return res.poll();
    }

    public boolean hasNext() {
        return res.size() != 0;
    }

}
