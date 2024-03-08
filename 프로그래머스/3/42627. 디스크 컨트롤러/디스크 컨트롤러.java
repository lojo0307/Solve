import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) return o1[0] -o2[0];
                else return o1[1] - o2[1];
            }
        });
        
        int t = jobs[0][0] + jobs[0][1];
        int idx = 1;
        int work = jobs[0][1];
        Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
        while (idx < jobs.length || pq.size() > 0) {
            while (idx < jobs.length) {
                if (jobs[idx][0] > t) break;
                pq.offer(jobs[idx++]);
            }
            
            if (pq.size() == 0) {
                t = jobs[idx][0] + jobs[idx][1];
                work += jobs[idx++][1];
                continue;
            }
            
            int[] cur = pq.poll();
            work += (t - cur[0] + cur[1]);
            t += cur[1];
        }
        
        return work / jobs.length;
    }
}