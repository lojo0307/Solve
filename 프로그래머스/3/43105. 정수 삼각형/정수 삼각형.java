class Solution {
    public int solution(int[][] triangle) {
        for (int i = 1; i < triangle.length; i++) {
            triangle[i][0] += triangle[i-1][0];
            triangle[i][triangle[i].length-1] += triangle[i-1][triangle[i-1].length-1];
            for (int j = 1; j < triangle[i].length - 1; j++) {
                triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
            }
        }
        
        int max = 0;
        for (int n : triangle[triangle.length-1]) max = Math.max(max, n);
        
        return max;
    }
}