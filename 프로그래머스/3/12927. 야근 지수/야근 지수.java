import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        Arrays.sort(works);
        
        int[] interval = new int[works.length];
        for (int i = interval.length-1; i > 0; i--) {
            interval[i] = works[i] - works[i-1];
        }
        interval[0] = works[0];
        
        for (int i = interval.length - 1; i >= 0; i--) {
            int size = interval.length - i;
            if (interval[i] * size <= n) {
                if (i == 0) return 0;
                n -= (interval[i] * size);
                continue;
            }
            while (n >= size) {
                n -= size;
                interval[i]--;
            }
            for (int k = i; k < works.length; k++) {
                if (n-- > 0) works[k] = (i > 0 ? works[i-1] : 0) + interval[i] - 1;
                else works[k] = (i > 0 ? works[i-1] : 0) + interval[i];
            }
            break;
        }
        
        long sum = 0;
        for (int work : works) {
            sum += Math.pow(work, 2);
        }
        return sum;
    }
}