import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        List<int[]>[] list = new LinkedList[n+1];
        for (int i = 1; i <= n; i++) list[i] = new LinkedList<>();
        for (int[] f : fares) {
            list[f[0]].add(new int[] {f[1], f[2]});
            list[f[1]].add(new int[] {f[0], f[2]});
        }
        
        int[] fee = new int[n+1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        boolean[] visited = new boolean[n+1];
        pq.offer(new int[] {s, 0});
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (visited[cur[0]]) continue;
            visited[cur[0]] = true;
            fee[cur[0]] = cur[1];
            for (int[] next : list[cur[0]]) {
                if (visited[next[0]]) continue;
                pq.offer(new int[] {next[0], cur[1] + next[1]});
            }
        }
        
        pq.offer(new int[] {a, 0});
        visited = new boolean[n+1];
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (visited[cur[0]]) continue;
            visited[cur[0]] = true;
            fee[cur[0]] += cur[1];
            for (int[] next : list[cur[0]]) {
                if (visited[next[0]]) continue;
                pq.offer(new int[] {next[0], cur[1] + next[1]});
            }
        }
        
        pq.offer(new int[] {b, 0});
        visited = new boolean[n+1];
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (visited[cur[0]]) continue;
            visited[cur[0]] = true;
            fee[cur[0]] += cur[1];
            for (int[] next : list[cur[0]]) {
                if (visited[next[0]]) continue;
                pq.offer(new int[] {next[0], cur[1] + next[1]});
            }
        }
        
        int min = Integer.MAX_VALUE;
        for (int i : fee) {
            if (i == 0) continue;
            min = Math.min(min, i);
        }
        
        return min;
    }
}