import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t*m; i++) {
            sb.append(Integer.toString(i, n).toUpperCase());
        }
        
        String tmp = sb.toString();
        
        sb.setLength(0);
        
        for (int i = p-1; sb.length() < t; i += m) {
            sb.append(tmp.charAt(i));
        }
        
        return sb.toString();
    }
}