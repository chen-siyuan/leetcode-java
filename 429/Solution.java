import java.util.*;

public class Solution {

    public List<List<Integer>> levelOrder(Node root) {

        Queue<Node> queue = new LinkedList<Node>();

        queue.offer(root);
        queue.offer(null);

        List<Integer> cache = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        while(queue.size() != 0) {
            
            Node curr = queue.poll();
        
            if(curr == null) {

                if(cache.size() == 0) return res;
                res.add(cache);

                cache = new ArrayList<>();
                queue.offer(null);

                continue;
            }

            cache.add(curr.val);
        
            for(Node child: curr.children) queue.offer(child);
        
        }

        return null;
    }

}
