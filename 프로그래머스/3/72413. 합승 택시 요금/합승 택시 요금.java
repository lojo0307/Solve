import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        List<int[]>[] edges = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) edges[i] = new ArrayList<>();
        for (int[] fare : fares) {
            edges[fare[0]].add(new int[]{fare[1], fare[2]});
            edges[fare[1]].add(new int[]{fare[0], fare[2]});
        }

        int[] distS = dijkstra(n, s, edges);
        int[] distA = dijkstra(n, a, edges);
        int[] distB = dijkstra(n, b, edges);

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            if (distS[i] == -1 || distA[i] == -1 || distB[i] == -1) continue;
            min = Math.min(min, distS[i] + distA[i] + distB[i]);
        }

        return min;
    }

    private int[] dijkstra(int n, int start, List<int[]>[] edges) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (dist[cur[0]] != -1) continue;
            dist[cur[0]] = cur[1];

            for (int[] next : edges[cur[0]]) {
                if (dist[next[0]] != -1) continue;
                pq.offer(new int[]{next[0], next[1] + cur[1]});
            }
        }

        return dist;
    }
}
