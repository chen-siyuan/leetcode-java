import java.util.*;

public class Solution {

    public static List<Integer>[] al;

    public boolean check(int index) {
        for(int i=0; i < al.length; i++) if(i != index && !al[i].contains(index)) return false;
        return true;
    }

    public int findJudge(int n, int[][] pairs) {

        al = new List[n];
        for(int i=0; i < n; i++) al[i] = new ArrayList<>();
    
        for(int[] pair: pairs) al[pair[0] - 1].add(pair[1] - 1);

        for(int i=0; i < n; i++) if(al[i].size() == 0 && check(i)) return i + 1;

        return -1;
    }

}
