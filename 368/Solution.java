import java.util.*;

public class Solution {

    public List<Integer> largestDivisibleSubset(int[] nums) {
    
        int n = nums.length;
        if(n == 0) return new ArrayList<>();

        Arrays.sort(nums);

        int[] dp = new int[n];
        int[] prev = new int[n];
        
        for(int i=0; i < n; i++) {
            dp[i] = 1;
            prev[i] = -1;
        }

        int max = dp[0];
        int index = 0;

        for(int i=1; i < n; i++) for(int j=0; j < i; j++) if(nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {

            dp[i] = dp[j] + 1;
            prev[i] = j;

            if(max < dp[i]) {
                max = dp[i];
                index = i;
            }
            
        }

        List<Integer> res = new ArrayList<>();
        res.add(nums[index]);

        while(prev[index] != -1) {
            index = prev[index];
            res.add(0, nums[index]);
        }

        return res;
    }

}
