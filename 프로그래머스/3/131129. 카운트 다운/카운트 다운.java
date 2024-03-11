class Solution {
    public int[] solution(int target) {
        int[][] dp = new int[(target > 60 ? target+1 : 61)][2];
        for (int i = 1; i <= 20; i++) {
            dp[i][0] = 1;
            dp[i][1] = 1;
        }
        for (int i = 21; i < 61; i++) {
            if (i % 3 == 0) dp[i][0] = 1;
            else if (i == 50) {
                dp[i][0] = 1;
                dp[i][1] = 1;
            }
            else if (i % 2 == 0 && i < 41) dp[i][0] = 1;
            else if (i < 41) {
                dp[i][0] = 2;
                dp[i][1] = 2;
            }
            else if (i < 50) {
                dp[i][0] = 2;
                dp[i][1] = 1;
            }
            else {
                dp[i][0] = 2;
                dp[i][1] = 2;
            }
        }
        
        for (int i = 61; i <= target; i++) {
            int dart = Integer.MAX_VALUE;
            int sb = 0;
            
            for (int gap = 1; gap < 61; gap++) {
                int D = dp[i-gap][0] + dp[gap][0];
                if (D < dart) {
                    dart = D;
                    sb = dp[i-gap][1] + dp[gap][1];
                }
                else if (D == dart) sb = Math.max(sb, dp[i-gap][1] + dp[gap][1]);
            }
            
            dp[i][0] = dart;
            dp[i][1] = sb;
        }
        
        return new int[] {dp[target][0], dp[target][1]};
        
    }
}