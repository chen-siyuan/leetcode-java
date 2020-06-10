public class Solution2 {

    public int findJudge(int n, int[][] pairs) {
    
        int[] ins = new int[n];
        int[] outs = new int[n];

        for(int[] pair: pairs) {
            ins[pair[1] - 1]++;
            outs[pair[0] - 1]++;
        }

        for(int i=0; i < n; i++) if(ins[i] == n - 1 && outs[i] == 0) return i - 1;

        return -1;
    }

}
