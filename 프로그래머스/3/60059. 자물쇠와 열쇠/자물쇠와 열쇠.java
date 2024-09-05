class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        int n = key.length;
        int N = lock.length;
        int m = n+N-1;
        int[][] k = new int[n][n];
        int[][] map = new int[N+n+n-2][N+n+n-2];
        
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                map[n-1+r][n-1+c] = lock[r][c];
            }
        }
        
        for (int i = 0; i < 4; i++) {
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    k[r][c] = key[c][n-r-1];
                }
            }
            
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    key[r][c] = k[r][c];
                }
            }
            
            for (int kr = 0; kr < m; kr++) {
                loop : for (int kc = 0; kc < m; kc++) {
                    // 열쇠의 0,0 지점이 kr, kc에 위치
                    for (int r = n-1; r < m; r++) {
                        for (int c = n-1; c < m; c++) {
                            if (r-kr < n && c-kc < n && r-kr >= 0 && c-kc >= 0) {
                                if (map[r][c] == k[r-kr][c-kc]) continue loop;
                            }
                           else if (map[r][c] == 0) continue loop;
                        }
                    }
                    
                    return true;
                }
            }
        }
        
        return false;
    }
}