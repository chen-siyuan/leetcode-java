import java.util.*;

public class Solution {

    public static final int[][] DIRECTIONS = new int[][]{new int[]{1, 0}, new int[]{0, 1}, new int[]{-1, 0}, new int[]{0, -1}};

    public void solve(char[][] board) {
    
        int m = board.length;
        if(m == 0) return;
        int n = board[0].length;

        Queue<Point> queue = new LinkedList<Point>();

        for(int j=0; j < n; j++) if(board[0][j] == 'O') queue.offer(new Point(0, j));
        for(int i=0; i < m; i++) if(board[i][0] == 'O') queue.offer(new Point(i, 0));
        for(int j=0; j < n; j++) if(board[m - 1][j] == 'O') queue.offer(new Point(m - 1, j));
        for(int i=0; i < m; i++) if(board[i][n - 1] == 'O') queue.offer(new Point(i, n - 1));

        while(queue.size() != 0) {
            
            Point curr = queue.poll();

            if(board[curr.x][curr.y] == 'Y') continue;
            board[curr.x][curr.y] = 'Y';
        
            for(int[] direction: DIRECTIONS)
                if(curr.x + direction[0] >= 0 && curr.x + direction[0] < m && curr.y + direction[1] >= 0 && curr.y + direction[1] < n
                        && board[curr.x + direction[0]][curr.y + direction[1]] == 'O') queue.offer(new Point(curr.x + direction[0], curr.y + direction[1]));
        
        }

        for(int i=0; i < m; i++) for(int j=0; j < n; j++) {
            if(board[i][j] == 'O') board[i][j] = 'X';
            if(board[i][j] == 'Y') board[i][j] = 'O';
        }
    
    }

}

class Point {

    public final int x;
    public final int y;

    public Point(int _x, int _y) {
        x = _x;
        y = _y;
    }


}
