class Solution {
    public int solution(int[][] board, int[][] skill) {
        int[][] map = new int[board.length+1][board[0].length+1];
        for (int[] s : skill) {
            switch (s[0]) {
                case 1 : // 공격
                    map[s[1]][s[2]] -= s[5];
                    map[s[3]+1][s[2]] += s[5];
                    map[s[1]][s[4]+1] += s[5];
                    map[s[3]+1][s[4]+1] -= s[5];
                    break;
                case 2 : // 회복
                    map[s[1]][s[2]] += s[5];
                    map[s[3]+1][s[2]] -= s[5];
                    map[s[1]][s[4]+1] -= s[5];
                    map[s[3]+1][s[4]+1] += s[5];
            }
        }
        
        for (int c = 0; c < map[0].length; c++) {
            for (int r = 1; r < map.length; r++) map[r][c] += map[r-1][c];
        }
        
        for (int r = 0; r < map.length; r++) {
            for (int c = 1; c < map[0].length; c++) map[r][c] += map[r][c-1];
        }
        
        int ans = 0;
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (map[r][c] + board[r][c] > 0) ans++;
            }
        }
        
        return ans;
    }
}