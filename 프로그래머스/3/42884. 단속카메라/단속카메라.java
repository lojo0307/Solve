import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);
        int cnt = 0;
        int camera = -30001;
        for (int i = 0; i < routes.length; i++) {
            if (camera < routes[i][0]) {
                camera = routes[i][1];
                cnt++;
            }
        }
        return cnt;
    }
}