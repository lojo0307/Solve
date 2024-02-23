class Solution {
    public int solution(int[] cookie) {
        int ans = 0;
        int max = 0;
        for (int c : cookie) max += c;
        max /= 2;
        
        for (int m = 0; m < cookie.length - 1; m++) {
            int i = m;
            int r = m + 1;
            
            int left = cookie[m];
            int right = cookie[m+1];
            while (i >= 0 && r < cookie.length) {
                if (left == right) {
                    ans = Math.max(ans, left);
                    if (--i < 0 || ++r >= cookie.length) break;
                    if ((left += cookie[i]) > max) break;
                    if ((right += cookie[r]) > max) break;
                } else if (left > right) {
                    if (++r >= cookie.length) break;
                    if ((right += cookie[r]) > max) break;
                }
                else {
                    if (--i < 0) break;
                    if ((left += cookie[i]) > max) break;
                };
            }
        }
        
        return ans;
    }
}