import java.util.*;

class Solution {
    public String solution(String s) {
        StringTokenizer str = new StringTokenizer(s);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        while (str.hasMoreTokens()) {
            int n = Integer.parseInt(str.nextToken());
            max = Math.max(max, n);
            min = Math.min(min, n);
        }
        
        return min + " " + max;
    }
}