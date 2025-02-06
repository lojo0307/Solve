import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int left = 1;
        int right = 0;
        
        for (int n : diffs) right = Math.max(right, n);
        
        while (right >= left) {
            int mid = (right + left) / 2;
            
            long sum = 0;
            for (int i = 0; i < diffs.length; i++) {
                sum += (diffs[i] > mid ? (diffs[i]-mid) * (times[i-1] + times[i]) + times[i] : times[i]);
            }
            
            if (sum > limit) left = mid + 1;
            else if (sum < limit) right = mid - 1;
            else return mid;
        }
        
        return left;
    }
}