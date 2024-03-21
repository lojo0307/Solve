import java.util.*;

class Solution {
    public int solution(int[][] land, int height) {
        int n = land.length;
        int[][] group = new int[n][n];
        int idx = 1;
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        
        // 이동 가능한 구획을 나누고 구획별 번호를 붙여준다
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (group[r][c] != 0) continue;
                group[r][c] = idx;
                Queue<int[]> q = new LinkedList<>();
                q.offer(new int[] {r, c});
                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    for (int i = 0; i < 4; i++) {
                        int nr = cur[0] + dr[i];
                        int nc = cur[1] + dc[i];
                        
                        if (nr < 0 || nc < 0 || nr >= n || nc >= n) continue;
                        if (group[nr][nc] != 0 || Math.abs(land[cur[0]][cur[1]] - land[nr][nc]) > height) continue;
                        group[nr][nc] = idx;
                        q.offer(new int[] {nr, nc});
                    }
                }
                idx++;
            }
        }
        idx--;
        
        // 현재 idx만큼의 구획이 존재, 사다리는 최소 idx-1번 설치해야 한다
        parent = new int[idx + 1];
        for (int i = 0; i < parent.length; i++) parent[i] = i;
        
        Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                for (int i = 0; i < 2; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];
                    if (nr < 0 || nc < 0 || nr >= n || nc >= n) continue;
                    if (group[nr][nc] == group[r][c]) continue;
                    pq.offer(new int[] {group[r][c], group[nr][nc], Math.abs(land[r][c] - land[nr][nc])});
                }
            }
        }
        
        int ans = 0;
        
        while (idx > 1) {
            int[] cur = pq.poll();
            if (find(cur[0]) == find(cur[1])) continue;
            ans += cur[2];
            union(cur[0], cur[1]);
            idx--;
        }
        
        return ans;
        
    }
    
    static int[] parent;
    
    static int find(int i) {
        if (parent[i] == i) return i;
        return parent[i] = find(parent[i]);
    }
    
    static void union(int a, int b) {
        parent[find(a)] = find(b);
    }
}