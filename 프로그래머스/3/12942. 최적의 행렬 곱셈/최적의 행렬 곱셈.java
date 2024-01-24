class Solution {
    public int solution(int[][] matrix_sizes) {
        number = new int[matrix_sizes.length+1];
        for (int i = 0; i < matrix_sizes.length; i++) {
            number[i] = matrix_sizes[i][0];
        }
        number[number.length-1] = matrix_sizes[matrix_sizes.length-1][1];
        dp = new int[matrix_sizes.length+1][matrix_sizes.length+1];
        return cal(0, matrix_sizes.length);
    }
    
    public static int cal(int start, int end) {
        if (end == start + 1) return 0;
        
        int min = Integer.MAX_VALUE;
        for (int mid = start + 1; mid < end; mid++) {
            int left = memory(start, mid);
            int right = memory(mid, end);
            int multiply = number[start] * number[mid] * number[end];
            min = Math.min(min, left + right + multiply);
        }
        return min;
    }
    
    public static int memory(int a, int b) {
        if (dp[a][b] == 0) dp[a][b] = cal(a, b);
        return dp[a][b];
    }
    
    public static int[] number;
    public static int[][] dp;
}