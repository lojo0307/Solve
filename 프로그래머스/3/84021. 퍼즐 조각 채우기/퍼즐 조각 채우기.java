import java.util.*;

class Solution {
    public int solution(int[][] game_board, int[][] table) {
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        int answer = 0;
        
        List<List<int[]>> puzzle = new ArrayList<>();
        for (int r = 0; r < table.length; r++) {
            for (int c = 0; c < table[0].length; c++) {
                if(table[r][c] == 0) continue;
                table[r][c] = 0;
                List<int[]> piece = new LinkedList<>();
                piece.add(new int[] {r, c});
                Queue<int[]> q = new LinkedList<>();
                q.offer(new int[] {r, c});
                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    for(int i = 0; i < 4; i++) {
                        int nr = cur[0] + dr[i];
                        int nc = cur[1] + dc[i];
                        if (nr < 0 || nc < 0 || nr >= table.length || nc >= table[0].length || table[nr][nc] == 0) continue;
                        table[nr][nc] = 0;
                        q.offer(new int[] {nr, nc});
                        piece.add(new int[] {nr, nc});
                    }
                }
                puzzle.add(piece);
            }
        }
        
        for (int r = 0; r < game_board.length; r++) {
            loop : for (int c = 0; c < game_board[0].length; c++) {
                if (game_board[r][c] == 1) continue;
                game_board[r][c] = 1;
                PriorityQueue<int[]> blank = new PriorityQueue<>(new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        if (o1[0] == o2[0]) return o1[1] - o2[1];
                        return o1[0] - o2[0];
                    }
                });
                Queue<int[]> q = new LinkedList<>();
                q.offer(new int[] {r, c});
                blank.offer(new int[] {0, 0});
                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    for (int i = 0; i < 4; i++) {
                        int nr = cur[0] + dr[i];
                        int nc = cur[1] + dc[i];
                        if (nr < 0 || nc < 0 || nr >= game_board.length || nc >= game_board[0].length || game_board[nr][nc] == 1) continue;
                        blank.offer(new int[] {nr-r, nc-c});
                        q.offer(new int[] {nr, nc});
                        game_board[nr][nc] = 1;
                    }
                }
                
                // blank에 빈칸 모양이 들어있음. 이것과 puzzle속 맞는 조각을 대조
                for (int i = 0; i < puzzle.size(); i++) {
                    List<int[]> piece = puzzle.get(i);
                // for (List<int[]> piece : puzzle) {
                    if (piece.size() != blank.size()) continue; 
                    for(int[] cur : piece) {
                        PriorityQueue<int[]> check = new PriorityQueue<>(new Comparator<int[]>() {
                            @Override       
                            public int compare(int[] o1, int[] o2) {
                                if (o1[0] == o2[0]) return o1[1] - o2[1];
                                return o1[0] - o2[0];
                            }
                        });
                        
                        // 원방향
                        for (int[] pos : piece) {
                            check.offer(new int[] {pos[0] - cur[0], pos[1] - cur[1]});
                        }
                        // check과 blank가 같다면 맞는 조각
                        if (isSame(check, blank)) {
                            puzzle.remove(i--);
                            answer += check.size();
                            continue loop;
                        }
                        
                        // 회전1
                        check.clear();
                        for (int[] pos : piece) {
                            check.offer(new int[] {pos[1] - cur[1], cur[0] - pos[0]});
                        }
                        // check과 blank가 같다면 맞는 조각
                        if (isSame(check, blank)) {
                            puzzle.remove(i--);
                            answer += check.size();
                            continue loop;
                        }
                        
                        // 회전2
                        check.clear();
                        for (int[] pos : piece) {
                            check.offer(new int[] {cur[1] - pos[1], pos[0] - cur[0]});
                        }
                        // check과 blank가 같다면 맞는 조각
                        if (isSame(check, blank)) {
                            puzzle.remove(i--);
                            answer += check.size();
                            continue loop;
                        }
                        
                        // 회전3
                        check.clear();
                        for (int[] pos : piece) {
                            check.offer(new int[] {cur[0] - pos[0], cur[1] - pos[1]});
                        }
                        // check과 blank가 같다면 맞는 조각
                        if (isSame(check, blank)) {
                            puzzle.remove(i--);
                            answer += check.size();
                            continue loop;
                        }
                    }
                }
            }
        }
        return answer;
    }
    
    public static boolean isSame(PriorityQueue<int[]> check, PriorityQueue<int[]> blank) {
        PriorityQueue<int[]> pq1 = new PriorityQueue<>(check);
        PriorityQueue<int[]> pq2 = new PriorityQueue<>(blank);
        if (pq1.size() != pq2.size()) {
            return false;
        }

        while (!pq1.isEmpty()) {
            int[] element1 = pq1.poll();
            int[] element2 = pq2.poll();

            if (!Arrays.equals(element1, element2)) {
                return false;
            }
        }

        return true;
    }
}