public class Solution {

    public int maxProfit(int[] prices) {
    
        int n = prices.length;
        if(n < 2) return 0;
    
        int hold = Integer.MIN_VALUE;
        int sold = 0;

        for(int i=0; i < n; i++) {

            int temp = sold;

            sold = Math.max(sold, hold + prices[i]);
            hold = Math.max(hold, temp - prices[i]);

        }

        return sold;
    }

}
