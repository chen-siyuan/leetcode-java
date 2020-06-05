public class Solution {

    public int countNumbersWithUniqueDigits(int n) {
    
        if(n == 0) return 1;

        int wi = 0;
        int wo = 9;
        int sum = 9;

        for(int i=0; i < n - 1; i++) {

            wi = wi * (9 - i) + wo;
            wo = wo * (8 - i);

            sum += wi + wo;

        }

        return sum + 1;
    }

}
