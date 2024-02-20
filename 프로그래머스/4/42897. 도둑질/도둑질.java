class Solution {
    public int solution(int[] money) {
        int[] dp = new int[money.length];
        
        // 0번 털 경우
        dp[0] = money[0];
        dp[1] = money[0];
        for (int i = 2; i < money.length-1; i++) {
            dp[i] = Math.max(dp[i-2] + money[i], dp[i-1]);
        }
        
        int res1 = dp[dp.length-2];
        
        // 0번 방문 X
        dp[0] = 0;
        dp[1] = money[1];
        for (int i = 2; i < money.length; i++) {
            dp[i] = Math.max(dp[i-2] + money[i], dp[i-1]);
        }
        
        return Math.max(res1, dp[dp.length-1]);
    }
}