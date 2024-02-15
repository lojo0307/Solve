class Solution {
    public int solution(int n, int[] stations, int w) {
        int cur = 1;
        int idx = 0;
        int cnt = 0;
        
        while (cur <= n && idx < stations.length) {
            if (cur < stations[idx] - w) {
                cnt++;
                cur += (w * 2 + 1);
            } else {
                cur = stations[idx] + w + 1;
                idx++;
            }
        }
        while (cur <= n) {
            cnt++;
            cur += (w * 2 + 1);
        }
        
        return cnt;
    }
}