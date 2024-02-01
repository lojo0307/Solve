import java.util.*;

class Solution {
    static List<int[]>[] edges;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        edges = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) edges[i] = new ArrayList<>();
        for (int[] fare : fares) {
            edges[fare[0]].add(new int[] {fare[1], fare[2]});
            edges[fare[1]].add(new int[] {fare[0], fare[2]});
        }
        
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            int d1 = dist(s, i);
            int d2 = dist(i, a);
            int d3 = dist(i, b);
            
            if (d1 < 0 || d2 < 0 || d3 < 0) continue;
            min = Math.min(min, d1 + d2 + d3);
        }
        
        return min;
    }
    
    private int dist(int start, int end) {
        Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        boolean[] visited = new boolean[edges.length];
        
        pq.offer(new int[] {start, 0}); // 0: 노드, 1: 거리
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (visited[cur[0]]) continue;
            if (cur[0] == end) return cur[1];
            visited[cur[0]] = true;
            
            for (int[] next : edges[cur[0]]) {
                if (visited[next[0]]) continue;
                pq.offer(new int[] {next[0], next[1] + cur[1]});
            }
        }
        return -1;
    }
}