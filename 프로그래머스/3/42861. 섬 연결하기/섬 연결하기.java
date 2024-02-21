import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        List<int[]>[] cost = new ArrayList[n];
        for (int i = 0; i < n; i++) cost[i] = new ArrayList<int[]>();
        
        for (int[] c : costs) {
            cost[c[0]].add(new int[] {c[1], c[2]});
            cost[c[1]].add(new int[] {c[0], c[2]});
        }
        
        Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.offer(new int[] {0, 0});
        boolean[] visited = new boolean[n];
        int sum = 0;
        
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (visited[cur[0]]) continue;
            visited[cur[0]] = true;
            sum += cur[1];
            for (int[] c : cost[cur[0]]) {
                if (visited[c[0]]) continue;
                pq.offer(c);
            }
        }
        
        return sum;
    }
}