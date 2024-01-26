import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<Integer>[] node = new ArrayList[n+1];
        for (int i = 1; i < n+1; i++) {
            node[i] = new ArrayList<>();
        }
        for (int[] arr : edge) {
            node[arr[0]].add(arr[1]);
            node[arr[1]].add(arr[0]);
        }
        
        boolean[] visited = new boolean[n+1];
        int[] dist = new int[n+1];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {1, 0});
        visited[1] = true;
        while (!q.isEmpty()) {
            int cur = q.peek()[0];
            dist[cur] = q.poll()[1];
            
            for (int next : node[cur]) {
                if (visited[next]) continue;
                visited[next] = true;
                
                q.offer(new int[] {next, dist[cur] + 1});
            }
        }
        
        int max = -1;
        for (int val : dist) {
            max = Math.max(val, max);
        }
        int cnt = 0;
        for (int val : dist) {
            if (val == max) cnt++;
        }
        
        return cnt;
    }
}