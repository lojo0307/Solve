import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<Integer>[] list = new LinkedList[n+1];
        for (int i = 1; i <= n; i++) list[i] = new LinkedList<>();
        for (int[] e : edge) {
            list[e[0]].add(e[1]);
            list[e[1]].add(e[0]);
        }
        
        boolean[] visited = new boolean[n+1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.offer(new int[] {1, 0}); // 노드 번호, 거리
        visited[1] = true;
        int[] dist = new int[n+1];
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            for (int next : list[cur[0]]) {
                if (visited[next]) continue;
                visited[next] = true;
                dist[next] = cur[1] + 1;
                pq.offer(new int[] {next, dist[next]});
            }
        }
        
        int max = 0;
        for (int d : dist) max = Math.max(d, max);
        int cnt = 0;
        for (int d : dist) if (d == max) cnt++;
        
        return cnt;
    }
}