import java.util.*;

class Solution {
    public int solution(int[][] board) {
        int n = board.length;
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        boolean[][][] visited = new boolean[n][n][4];
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[3] - o2[3]); // 비용 순 정렬
        pq.offer(new int[]{0, 0, 0, 0});
        pq.offer(new int[]{0, 0, 1, 0}); // 0 오 1 하 2 좌 3 상
        
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (visited[cur[0]][cur[1]][cur[2]]) continue;
            if (cur[0] == n - 1 && cur[1] == n - 1) return cur[3];
            visited[cur[0]][cur[1]][cur[2]] = true;
            
            for (int i = 0; i < 4; i++) {
                if (i == (cur[2] + 2) % 4) continue;
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                if (nr < 0 || nc < 0 || nr >= n || nc >= n || visited[nr][nc][i] || board[nr][nc] == 1) continue;
                pq.offer(new int[] {nr, nc, i, cur[3] + (i == cur[2] ? 100 : 600)});
            }
        }
        
        return -1;
    }
}