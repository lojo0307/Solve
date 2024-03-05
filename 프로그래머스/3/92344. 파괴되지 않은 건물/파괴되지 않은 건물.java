class Solution {
    public int solution(int[][] board, int[][] skill) {
        
        int[][] degree = new int[board.length][board[0].length];
        for (int[] s : skill) {
            int d = (s[0] == 1 ? -1 : 1);
            d *= s[5];
            degree[s[1]][s[2]] += d;
            if (s[4] + 1 < degree[0].length) degree[s[1]][s[4]+1] -= d;
            if (s[3] + 1 < degree.length) degree[s[3]+1][s[2]] -= d;
            if (s[4] + 1 < degree[0].length && s[3] + 1 < degree.length) degree[s[3]+1][s[4]+1] += d;
        }
        
        for (int r = 0; r < board.length; r++) {
            for (int c = 1; c < board[0].length; c++) degree[r][c] += degree[r][c-1];
        }
        for (int c = 0; c < board[0].length; c++) {
            for (int r = 1; r < board.length; r++) degree[r][c] += degree[r-1][c];
        }
        
        int ans = 0;
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) if (board[r][c] + degree[r][c] > 0) ans++;
        }
        return ans;
    }
}