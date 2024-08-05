class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n][m];
        for (int[] p : puddles) dp[p[1]-1][p[0]-1] = -1;
        dp[0][0] = 1;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (dp[r][c] < 0) {
                    dp[r][c] = 0;
                    continue;
                }
                if (r > 0) dp[r][c] += dp[r-1][c];
                if (c > 0) dp[r][c] += dp[r][c-1];
                
                dp[r][c] %= 1000000007;
            }
        }
        
        return dp[n-1][m-1];
    }
}