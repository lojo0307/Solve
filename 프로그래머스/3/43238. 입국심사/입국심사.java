class Solution {
    public long solution(int n, int[] times) {
        long left = 0;
        long right = (long) times[0] * n;
        
        while (left <= right) {
            long mid = (left + right) / 2;
            long temp = 0;
            for (int t : times) temp += (mid / t);
            if (temp < n) left = mid + 1;
            else right = mid - 1;
        }
        
        return left;
    }
}