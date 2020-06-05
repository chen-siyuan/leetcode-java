import java.util.*;

public class Solution {

    public int getMoneyAmount(int n) {
    
        int[][] dp = new int[n + 1][n + 1];
        
        for(int i=1; i < n + 1; i++) for(int j=0; j < n + 1 - i; j++) {
        
            if(i == 1) {
                dp[j][j + i] = 0;
                continue;
            }

            dp[j][j + i] = Integer.MAX_VALUE;
        
            for(int k=j; k < j + i; k++) dp[j][j + i] = Math.min(dp[j][j + i], k + 1 + Math.max(dp[j][k], dp[k + 1][j + i]));
        
        }

        return dp[0][n];
    }

}
