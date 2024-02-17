import java.util.*;

class Solution {
    public int solution(int sticker[]) {
        if (sticker.length == 1) return sticker[0];
        
        int[][] dp = new int[sticker.length][2];
        
        // 1. 0번을 쓴다고 가정
        dp[0][0] = sticker[0];
        if (sticker.length > 1) dp[1][1] = sticker[0];
        if (sticker.length > 2) {
            dp[2][0] = sticker[0] + sticker[2];
            dp[2][1] = sticker[0];
        }
        
        for (int i = 3; i < sticker.length; i++) {
            dp[i][0] = dp[i-1][1] + sticker[i];
            dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1]);
        }
        
        int temp = dp[sticker.length-1][1];
        
        // 2. 0번을 쓰지 않는다고 가정
        dp[0][0] = 0;
        for (int i = 1; i < sticker.length; i++) {
            dp[i][0] = dp[i-1][1] + sticker[i];
            dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1]);
        }
        
        return Math.max(temp, Math.max(dp[sticker.length-1][0], dp[sticker.length-1][1]));
    }
}