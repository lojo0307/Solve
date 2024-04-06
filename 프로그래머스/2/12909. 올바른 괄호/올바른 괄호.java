class Solution {
    boolean solution(String s) {
        
        int cnt = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') cnt++;
            else if (--cnt < 0) return false;
        }
        if (cnt == 0) return true;
        return false;
    }
}