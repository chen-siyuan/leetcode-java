public class Solution {

    public int[] countBits(int num) {
    
        int[] res = new int[num + 1];
        res[0] = 0;

        int mul = 1;

        for(int i=1; i < num + 1; i++) {
            if(i >= mul * 2) mul *= 2;
            res[i] = res[i - mul] + 1;
        }

        return res;
    }

}
