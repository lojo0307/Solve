import java.util.*;

class Solution {
    public int solution(String[] maps) {
        boolean[][] map = new boolean[maps.length][maps[0].length()];
        int[] start = new int[2];
        int[] lever = new int[2];
        int[] exit = new int[2];
        
        for (int r=0; r<maps.length; r++) {
            for (int c=0; c<maps[r].length(); c++) {
                if (maps[r].charAt(c) == 'X') map[r][c] = true;
                else if (maps[r].charAt(c) == 'S') {
                    start[0] = r;
                    start[1] = c;
                }
                else if (maps[r].charAt(c) == 'E') {
                    exit[0] = r;
                    exit[1] = c;
                }
                else if (maps[r].charAt(c) == 'L') {
                    lever[0] = r;
                    lever[1] = c;
                }
            }
        }
        
        // 출발점부터 레버까지 이동, bfs
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        visited[start[0]][start[1]] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start[0], start[1]});
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        int cnt = 0;
        boolean flag = false;
        loop : while (!q.isEmpty()) {
            cnt++;
            int size = q.size();
            for (int t = 0; t < size; t++) {
                int[] cur = q.poll();
                int r = cur[0], c = cur[1];
                for (int i=0; i<4; i++) {
                    int nr = r + dr[i], nc = c + dc[i];
                    if (nr < 0 || nc < 0 || nr >= maps.length || nc >= maps[0].length() || visited[nr][nc] || map[nr][nc]) continue;
                    if (nr == lever[0] && nc == lever[1]) {
                        flag = true;
                        break loop;
                    }
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
        
        q.clear();
        visited = new boolean[maps.length][maps[0].length()];
        visited[lever[0]][lever[1]] = true;
        q.offer(new int[]{lever[0], lever[1]});
        boolean flag2 = false;
        loop2 : while (flag && !q.isEmpty()) {
            cnt++;
            int size = q.size();
            for (int t = 0; t < size; t++) {
                int[] cur = q.poll();
                int r = cur[0], c = cur[1];
                for (int i=0; i<4; i++) {
                    int nr = r + dr[i], nc = c + dc[i];
                    if (nr < 0 || nc < 0 || nr >= maps.length || nc >= maps[0].length() || visited[nr][nc] || map[nr][nc]) continue;
                    if (nr == exit[0] && nc == exit[1]) {
                        flag2 = true;
                        break loop2;
                    }
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
        
        int ans = cnt;
        if (!flag || !flag2) ans = -1;
        return ans;
    }
}