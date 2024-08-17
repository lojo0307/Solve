import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });
        
        int start = Integer.MAX_VALUE;
        int idx = -1;
        for(int i = 0; i < jobs.length; i++) {
            if (start > jobs[i][0]) {
                start = jobs[i][0];
                idx = i;
            }
        }
        int sum = jobs[idx][1];
        start += jobs[idx][1];
        boolean[] visited = new boolean[jobs.length];
        visited[idx] = true;
        int cnt = jobs.length - 1;
        
        loop : while (cnt > 0) {
            // 겹칠 경우
            for (int i = 0; i < jobs.length; i++) {
                if (visited[i]) continue;
                if (jobs[i][0] <= start) {
                    visited[i] = true;
                    start += jobs[i][1];
                    sum += (start - jobs[i][0]);
                    cnt--;
                    continue loop;
                }
            }
            
            // 중간에 공백 존재
            int min = Integer.MAX_VALUE;
            idx = -1;
            for (int i = 0; i < jobs.length; i++) {
                if (visited[i]) continue;
                if (min > jobs[i][0]) {
                    min = jobs[i][0];
                    idx = i;
                }
            }
            
            start = jobs[idx][0] + jobs[idx][1];
            sum += jobs[idx][1];
            cnt--;
            visited[idx] = true;
        }
        
        return sum / jobs.length;
    }
}