import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long left = 0;
        long right = (long)Math.pow(10, 18);
        
        while (left < right) {
            long mid = (left + right) / 2;
            long person = 0;
            for (int t : times) person += mid / t;
            if (person < n) left = mid + 1;
            else right = mid;
        }
        
        return left;
    }
}