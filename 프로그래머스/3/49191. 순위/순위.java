import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        List<Integer>[] win = new LinkedList[n+1];
        List<Integer>[] lose = new LinkedList[n+1];
        for (int i = 1; i <= n; i++) {
            win[i] = new LinkedList<>();
            lose[i] = new LinkedList<>();
        }
        for (int[] r : results) {
            win[r[0]].add(r[1]);
            lose[r[1]].add(r[0]);
        }
        
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            int num = 1;
            Queue<Integer> q = new LinkedList<>();
            boolean[] visited = new boolean[n+1];
            q.offer(i);
            while(!q.isEmpty()) {
                int cur = q.poll();
                for (int next : win[cur]) {
                    if (visited[next]) continue;
                    visited[next] = true;
                    num++;
                    q.offer(next);
                }
            }
            
            q.clear();
            q.offer(i);
            while(!q.isEmpty()) {
                int cur = q.poll();
                for (int next : lose[cur]) {
                    if (visited[next]) continue;
                    visited[next] = true;
                    num++;
                    q.offer(next);
                }
            }
            
            if (num == n) ans++;
        }
        
        return ans;
    }
}