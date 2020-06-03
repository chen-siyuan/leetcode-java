import java.util.*;

public class Solution {

    public static int[] nums;

    public static void convert(ListNode head) {
    
        ArrayList<Integer> temp = new ArrayList<>();

        while(head != null) {
            temp.add(head.val);
            head = head.next;
        }

        nums = new int[temp.size()];

        int pointer = 0;

        for(int num: temp) nums[pointer++] = num;

    }

    public static TreeNode arrayToBST(int start, int end) {
    
        if(start == end) return null;
        if(start == end - 1) return new TreeNode(nums[start]);

        int mid = (start + end) / 2;

        TreeNode node = new TreeNode(nums[mid]);

        node.left = arrayToBST(start, mid);
        node.right = arrayToBST(mid + 1, end);
        
        return node;
    }

    public TreeNode sortedListToBST(ListNode head) {
        convert(head);
        return arrayToBST(0, nums.length);
    }

}
