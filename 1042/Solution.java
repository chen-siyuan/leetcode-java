import java.util.*;

public class Solution {

    public static int n;
    public static List<Integer>[] al;
    public static int[] colors;
    public static boolean flag;

    public static void constructGraph(int[][] paths) {
 
        al = new List[n];
        for(int i=0; i < n; i++) al[i] = new ArrayList<>();
    
        for(int[] path: paths) {
            al[path[0] - 1].add(path[1] - 1);
            al[path[1] - 1].add(path[0] - 1);
        }

    }

    public static boolean check(int index, int color) {
        for(int neighbor: al[index]) if(neighbor < index && colors[neighbor] == color) return false;
        return true;
    }

    public static void DFS(int index) {
        
        if(index == n) flag = true;
        if(flag) return;

        for(int i=1; i <= 4; i++) if(check(index, i)) {

            colors[index] = i;
        
            DFS(index + 1);
            if(flag) return;

            colors[index] = 0;
        
        }
    
    }

    public int[] gardenNoAdj(int numGardens, int[][] paths) {

        n = numGardens;

        constructGraph(paths);

        colors = new int[n];
        flag = false;

        DFS(0);

        return colors;
    }

}
