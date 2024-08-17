class Solution {
    public long solution(int n, int[] times) {
        long left = 1;
        long right = (long)n * times[0];
        long ans = right;
        
        while (left <= right) {
            long mid = (left + right) / 2;
            long temp = 0;
            for (int t : times) temp += (mid / t);
            if (temp < n) left = mid + 1;
            else {
                ans = Math.min(ans, mid);
                right = mid - 1;
            }
        }
        
        return ans;
    }
}