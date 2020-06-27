public class Solution {

    public int maxProfit(int[] prices) {
    
        int n = prices.length;
        if(n < 2) return 0;

        int hold0 = Integer.MIN_VALUE / 10;
        int sold1 = Integer.MIN_VALUE / 10;
        int hold1 = Integer.MIN_VALUE / 10;
        int sold2 = Integer.MIN_VALUE / 10;

        for(int i=0; i < n; i++) {

            int _hold0 = hold0;
            int _sold1 = sold1;
            int _hold1 = hold1;
        
            hold0 = Math.max(hold0, -prices[i]);
            sold1 = Math.max(sold1, _hold0 + prices[i]);
            hold1 = Math.max(hold1, _sold1 - prices[i]);
            sold2 = Math.max(sold2, _hold1 + prices[i]);
        
        }
    
        return Math.max(Math.max(sold1, sold2), 0);
    }

}
