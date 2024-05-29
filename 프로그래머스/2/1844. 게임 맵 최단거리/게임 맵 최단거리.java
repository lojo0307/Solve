import java.util.*;

class Solution {
    public int solution(int[][] map) {
        boolean[][] visited = new boolean[map.length][map[0].length];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0, 1});
        visited[0][0] = true;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                if (nr < 0 || nc < 0 || nr >= map.length || nc >= map[0].length || visited[nr][nc] || map[nr][nc] == 0) continue;
                visited[nr][nc] = true;
                if (nr == map.length - 1 && nc == map[0].length - 1) return cur[2] + 1;
                q.offer(new int[] {nr, nc, cur[2] + 1});
            }
        }
        
        return -1;
    }
}