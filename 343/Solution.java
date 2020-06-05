public class Solution {

    public int integerBreak(int n) {
        if(n < 6) return (n / 2) * (n - n / 2);
        return n % 3 == 0 ? (int)Math.pow(3, n / 3) : (n % 3 == 1 ? (int)Math.pow(3, (n - 4) / 3) * 4 : (int)Math.pow(3, (n - 2) / 3) * 2);
    }

}
