class Solution {
    public int solution(int n) {
        dp = new int[n+1];
        
        return fibonacci(n);
    }
    
    static int[] dp;
    public int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return ((dp[n-1] == 0 ? dp[n-1] = fibonacci(n-1) : dp[n-1]) + (dp[n-2] == 0 ? dp[n-2] = fibonacci(n-2) : dp[n-2])) % 1234567;
    }
}