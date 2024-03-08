class Solution {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        if (m == 1 && n == 1) return 1;
        
        int[][][] dp = new int[m][n][2];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (r == 0 && c == 0) continue;
                if (r == 1 && c == 0) {
                    dp[r][c][1] = 1;
                    continue;
                }
                if (r == 0 && c == 1) {
                    dp[r][c][0] = 1;
                    continue;
                }
                
                if (cityMap[r][c] == 1) continue;
                
                if (c > 0) {
                    if (cityMap[r][c-1] == 0) dp[r][c][0] += dp[r][c-1][1];
                    dp[r][c][0] += dp[r][c-1][0];
                    dp[r][c][0] %= MOD;
                }
                if (r > 0) {
                    if (cityMap[r-1][c] == 0) dp[r][c][1] += dp[r-1][c][0];
                    dp[r][c][1] += dp[r-1][c][1];
                    dp[r][c][1] %= MOD;
                }
            }
        }
        
        return (dp[m-1][n-1][0] + dp[m-1][n-1][1]) % MOD;
    }
}