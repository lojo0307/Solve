class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[m][n];
        for (int[] p : puddles) dp[p[0]-1][p[1]-1] = -1;
        
        dp[0][0] = 1;
        for (int c = 1; c < n; c++) dp[0][c] = (dp[0][c] < 0 ? 0 : dp[0][c-1]);
        
        for (int r = 1; r < m; r++) {
            dp[r][0] = dp[r][0] < 0 ? 0 : dp[r-1][0];
            for (int c = 1; c < n; c++) {
                dp[r][c] = dp[r][c] < 0 ? 0 : dp[r-1][c] + dp[r][c-1];
                dp[r][c] %= 1000000007;
            }
        }
        
        return dp[m-1][n-1];
    }
}