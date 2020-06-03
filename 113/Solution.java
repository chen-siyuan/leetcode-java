import java.util.*;

public class Solution {

    public static List<Integer> answer;
    public static List<List<Integer>> answers;

    public static void DFS(TreeNode node, int curr) {
    
        if(node == null) return;

        answer.add(node.val);

        if(node.left == null && node.right == null && curr == node.val) answers.add(new ArrayList<>(answer));

        DFS(node.left, curr - node.val);
        DFS(node.right, curr - node.val);

        answer.remove(answer.size() - 1);

    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
    
        answer = new ArrayList<>();
        answers = new ArrayList<>();

        DFS(root, sum);
        
        return answers;
    }

}
