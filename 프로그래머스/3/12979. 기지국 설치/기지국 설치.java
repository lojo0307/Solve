import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        Arrays.sort(stations);
        int idx = 1;
        int cnt = 0;
        int s = 0;
        
        while (idx <= n) {
            int wifi = s >= stations.length ? 222222222 : stations[s];
            if (idx + w < wifi) {
                cnt++;
                idx = idx + w + w + 1;
            } else {
                idx = stations[s] + w + 1;
                s++;
            }
        }
        
        return cnt;
    }
}