class Solution {
    public int solution(int[] cookie) {
        int ans = 0;
        // for (int i = 1; i < cookie.length; i++) cookie[i] += cookie[i-1];
        
        for (int m = 0; m < cookie.length - 1; m++) {
            int i = m;
            int r = m + 1;
            
            int left = cookie[m];
            int right = cookie[m+1];
            while (i >= 0 && r < cookie.length) {
                if (left == right) {
                    ans = Math.max(ans, left);
                    if (--i < 0 || ++r >= cookie.length) break;
                    left += cookie[i];
                    right += cookie[r];
                } else if (left > right) {
                    if (++r >= cookie.length) break;
                    right += cookie[r];
                }
                else {
                    if (--i < 0) break;
                    left += cookie[i];
                };
            }
        }
        
        return ans;
    }
}