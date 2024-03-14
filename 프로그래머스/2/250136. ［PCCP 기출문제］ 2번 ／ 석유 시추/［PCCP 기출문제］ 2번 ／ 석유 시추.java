import java.util.*;

class Solution {
    public int solution(int[][] land) {
        int[] dr = {0, 0, 1, -1};
        int[] dc = {1, -1, 0, 0};
        int idx = 0;
        int[][] idxs = new int[land.length][land[0].length];
        for (int r = 0; r < land.length; r++) {
            for (int c = 0; c < land[0].length; c++) {
                if (land[r][c] != 1) continue;
                Queue<int[]> q = new LinkedList<>();
                Queue<int[]> oil = new LinkedList<>();
                q.offer(new int[] {r, c});
                land[r][c] = 0;
                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    oil.add(cur);
                    for (int i = 0; i < 4; i++) {
                        int nr = cur[0] + dr[i];
                        int nc = cur[1] + dc[i];
                        if (nr < 0 || nr >= land.length || nc < 0 || nc >= land[0].length || land[nr][nc] != 1) continue;
                        land[nr][nc] = 0;
                        q.offer(new int[] {nr, nc});
                    }
                }
                int n = oil.size();
                while (!oil.isEmpty()) {
                    int[] cur = oil.poll();
                    land[cur[0]][cur[1]] = n;
                    idxs[cur[0]][cur[1]] = idx;
                }
                idx++;
            }
        }
        
        int ans = 0;
        for (int c = 0; c < land[0].length; c++) {
            int sum = 0;
            boolean[] visited = new boolean[idx];
            for (int r = 0; r < land.length; r++) {
                if (land[r][c] > 0 && !visited[idxs[r][c]]) {
                    visited[idxs[r][c]] = true;
                    sum += land[r][c];
                }
            }
            ans = Math.max(sum, ans);
        }
        
        return ans;
    }
}