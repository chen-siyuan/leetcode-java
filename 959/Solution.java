import java.util.*;

public class Solution {

    public static int n;
    public static int[][] map;
    public static boolean[][][] searched;

    public static void constructGraph(String[] grid) {
        
        n = grid.length;
        map = new int[n][n];

        for(int i=0; i < n; i++) {
            
            int j=0;

            for(char c: grid[i].toCharArray()) switch(c) {

                case '\\':
                    map[i][j++] = -1;
                    break;
                case ' ':
                    map[i][j++] = 0;
                    break;
                case '/':
                    map[i][j++] = 1;
                    break;
        
            }
        
        } 

    }

    public static void DFS(int x, int y, int z) {
        
        if(searched[x][y][z]) return;
        searched[x][y][z] = true;

        if(map[x][y] == -1) DFS(x, y, 3 - z);
        if(map[x][y] == 0) for(int i=0; i < 4; i++) DFS(x, y, i);
        if(map[x][y] == 1) DFS(x, y, (5 - z) % 4);

        if(z == 0 && x != n - 1) DFS(x + 1, y, 2);
        if(z == 1 && y != n - 1) DFS(x, y + 1, 3);
        if(z == 2 && x != 0) DFS(x - 1, y, 0);
        if(z == 3 && y != 0) DFS(x, y - 1, 1);

    }

    public int regionsBySlashes(String[] grid) {

        constructGraph(grid);
        
        searched = new boolean[n][n][4];

        int count = 0;

        for(int i=0; i < n; i++) for(int j=0; j < n; j++)
            for(int k=0; k < 4; k++) if(!searched[i][j][k]) {
            DFS(i, j, k);
            count++;
        }

        return count;
    }

}
