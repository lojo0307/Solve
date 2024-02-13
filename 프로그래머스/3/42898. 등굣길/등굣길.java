class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[m][n];
        
        for (int[] puddle : puddles) {
            map[puddle[0]-1][puddle[1]-1] = -1;
        }
        
        map[0][0] = 1;
        
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (map[r][c] < 0) continue;
                if (r > 0 && map[r-1][c] > 0) map[r][c] += map[r-1][c] % 1000000007;
                if (c > 0 && map[r][c-1] > 0) map[r][c] += map[r][c-1] % 1000000007;
            }
        }
        
        return map[m-1][n-1] % 1000000007;
    }
}