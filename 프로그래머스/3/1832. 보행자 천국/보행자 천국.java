class Solution {
    final int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        int[][][] map = new int[m][n][2]; // 우 하
        map[0][0][0] = 1;
        map[0][0][1] = 1;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                switch (cityMap[r][c]) {
                    case 0 :
                        if (r > 0) {
                            map[r][c][0] += map[r-1][c][1];
                            map[r][c][1] += map[r-1][c][1];
                        }
                        if (c > 0) {
                            map[r][c][0] += map[r][c-1][0];
                            map[r][c][1] += map[r][c-1][0];
                        }
                        break;
                    case 2 :
                        if (c > 0) map[r][c][0] += map[r][c-1][0];
                        if (r > 0) map[r][c][1] += map[r-1][c][1];
                        break;
                }
                
                map[r][c][0] %= MOD;
                map[r][c][1] %= MOD;
            }
        }
        
        return map[m-1][n-1][0];
    }
}