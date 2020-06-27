public class Solution {

    public boolean canJump(int[] nums) {
    
        int n = nums.length;
        if(n < 2) return true;

        int m = n - 1;
        for(int i=n-2; i >= 0; i--) if(i + nums[i] >= m) m = i;

        return m == 0;
    }

}
