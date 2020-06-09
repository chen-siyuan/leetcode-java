public class Solution2 {

    public static int[] parent;

    public void solve(char[][] board) {

        if(board.length == 0 || board[0].length == 0) return;

        int m = board.length;
        int n = board[0].length;

        parent = new int[m * n];
        for(int i=0; i < parent.length; i++) parent[i] = i;
        
        for(int j=0; j < n; j++) if(board[0][j] == 'O') parent[j] = -1;
        for(int i=0; i < m; i++) if(board[i][0] == 'O') parent[i * n] = -1;
        for(int j=0; j < n; j++) if(board[m - 1][j] == 'O') parent[(m - 1) * n + j] = -1;
        for(int i=0; i < m; i++) if(board[i][n - 1] == 'O') parent[i * n + n - 1] = -1;

        for(int i=0; i < m; i++) for(int j=0; j < n; j++) {
            if(i != m - 1 && board[i][j] == board[i + 1][j]) union(i * n + j, (i + 1) * n + j);
            if(j != n - 1 && board[i][j] == board[i][j + 1]) union(i * n + j, i * n + j + 1);
        }

        for(int i=0; i < m; i++) for(int j=0; j < n; j++) if(find(i * n + j) != -1) board[i][j] = 'X'; 
    
    }

    public static void union(int a, int b) {
        
        int p = find(a);
        int q = find(b);

        if(p != -1) parent[p] = q;
        else if(q != -1) parent[q] = p;

    }

    public static int find(int a) {
        return parent[a] == a || parent[a] == -1 ? parent[a] : find(parent[a]);
    }

}
