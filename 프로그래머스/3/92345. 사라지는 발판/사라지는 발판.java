import java.util.*;

class Solution {
    public int solution(int[][] board, int[] aloc, int[] bloc) {
        // 누가 이기는지는 모름. 최소 횟수를 찾아보자
        // 보드 크기가 작으니깐 완전탐색 고고
        copy = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                copy[i][j] = board[i][j];
            }
        }
        min = Integer.MAX_VALUE;
        move(true, aloc, bloc, 0);
        return min;
    }
    
    static int[][] copy;
    static int min;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    private void move (boolean turn, int[] a, int[] b, int cnt) {
        if (turn) { // A가 이동할 순서
            copy[a[0]][a[1]] = 0;
            boolean lose = true; // 움직일 경우의 수가 존재하는지, 즉 패배인지를 판별
            boolean flag = false; // B가 있는 말에 가는 경우밖에 없는지 판별
            for (int i = 0; i < 4; i++) {
                int nr = a[0] + dr[i];
                int nc = a[1] + dc[i];
                if (nr < 0 || nr >= copy.length || nc < 0 || nc >= copy[0].length || copy[nr][nc] == 0) continue;
                if (nr == b[0] && nc == b[1]) {
                    flag = true;
                    continue; // B 위치로 가면 지니깐 가지 않음
                }
                lose = false;
                move(false, new int[] {nr, nc}, b, cnt + 1);
            }
            if (lose && flag) { // 갈 수 있는 곳이 B위치밖에 없는 경우 이동해야 한다
                move(false, b, b, cnt + 1);
            } else if (lose) min = Math.min(min, cnt);
            copy[a[0]][a[1]] = 1;
        } else { // B가 이동할 순서
            copy[b[0]][b[1]] = 0;
            boolean lose = true;
            boolean flag = false;
            for (int i = 0; i < 4; i++) {
                int nr = b[0] + dr[i];
                int nc = b[1] + dc[i];
                if (nr < 0 || nc < 0 || nr >= copy.length || nc >= copy[0].length || copy[nr][nc] == 0) continue;
                if (nr == a[0] || nc == a[1]) {
                    flag = true;
                    continue;
                }
                lose = false;
                move(true, a, new int[] {nr, nc}, cnt+1);
            }
            if (lose && flag) move(true, a, a, cnt+1);
            else if (lose) min = Math.min(min, cnt);
            copy[b[0]][b[1]] = 1;
        }
    }
}