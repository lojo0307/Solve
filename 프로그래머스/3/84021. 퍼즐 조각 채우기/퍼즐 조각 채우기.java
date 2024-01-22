import java.util.*;

class Solution {
    public int solution(int[][] game_board, int[][] table) {
        boolean[][] visited = new boolean[game_board.length][game_board[0].length];
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        int answer = 0;
        
        // 퍼즐 리스트를 각 조각의 크기 오름차순으로 정렬하는 우선순위 큐 생성
        // PriorityQueue<PriorityQueue<int[]>> puzzle = new PriorityQueue<int[]>((o1, o2) -> o1.size() - o2.size());
        List<List<int[]>> puzzle = new LinkedList<>();
        for (int r = 0; r < table.length; r++) {
            for (int c = 0; c < table[0].length; c++) {
                if (table[r][c] == 0) continue;
                List<int[]> piece = new ArrayList<>();
                piece.add(new int[] {r, c});
                table[r][c] = 0;
                Queue<int[]> q = new LinkedList<int[]>();
                q.offer(new int[] {r, c});
                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    for (int i = 0; i < 4; i++) {
                        int nr = cur[0] + dr[i];
                        int nc = cur[1] + dc[i];
                        if (nr < 0 || nr >= table.length) continue;
                        if (nc < 0 || nc >= table[0].length) continue;
                        if (table[nr][nc] == 0) continue;
                        game_board[nr][nc] = 0;
                        piece.add(new int[] {nr, nc});
                        q.offer(new int[] {nr, nc});
                    }
                }
                puzzle.add(piece);
            }
        }
        
        for (int r = 0; r < game_board.length; r++) {
            loop : for (int c = 0; c < game_board[0].length; c++) {
                if (game_board[r][c] == 1) continue;
                // 빈칸에 도달했으므로 현재 모양을 파악
                PriorityQueue<int[]> blank = new PriorityQueue<int[]>(new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        if (o1[0] == o2[0]) return o1[1] - o2[1];
                        return o1[0] - o2[0];
                    }
                });
                Queue<int[]> q = new LinkedList<int[]>();
                blank.offer(new int[] {0, 0});
                q.offer(new int[] {r, c});
                game_board[r][c] = 1;
                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    for (int i = 0; i < 4; i++) {
                        int nr = cur[0] + dr[i];
                        int nc = cur[1] + dc[i];
                        if (nr < 0 || nr >= game_board.length) continue;
                        if (nc < 0 || nc >= game_board[0].length) continue;
                        if (game_board[nr][nc] == 1) continue;
                        game_board[nr][nc] = 1;
                        blank.offer(new int[] {nr-r, nc-c});
                        q.offer(new int[] {nr, nc});
                    }
                }
                // 이제 blank에는 빈칸의 모양이 들어 있음
                for (List<int[]> piece : puzzle) {
                    if (piece.size() != blank.size()) continue;
                    for (int[] cur : piece) {
                        // 도형 돌리는건 전부 마이너스, 혹은 자리바꿔서 한쪽만 마이너스
                        PriorityQueue<int[]> check = new PriorityQueue<int[]>(new Comparator<int[]>() {
                            @Override
                            public int compare(int[] o1, int[] o2) {
                                if (o1[0] == o2[0]) return o1[1] - o2[1];
                                return o1[0] - o2[0];
                            }
                        });
                        Queue<int[]> temp = new LinkedList<>();
                        for (int[] pos : piece) {
                            check.add(new int[] {pos[0] - cur[0], pos[1] - cur[1]});
                        }
                        while (true) {
                            int[] c1 = blank.poll();
                            int[] c2 = check.poll();
                            if (c1[0] != c2[0] || c1[1] != c2[1]) break;
                            temp.add(c1);
                            if (blank.size() == 0) {
                                answer += temp.size();
                                continue loop;
                            }
                        }
                        while (!temp.isEmpty()) {
                            blank.offer(temp.poll());
                        }
                        check.clear();
                        for (int[] pos : piece) {
                            check.add(new int[] {cur[1] - pos[1], pos[0] - cur[0]});
                        }
                        while (true) {
                            int[] c1 = blank.poll();
                            int[] c2 = check.poll();
                            if (c1[0] != c2[0] || c1[1] != c2[1]) break;
                            temp.add(c1);
                            if (blank.size() == 0) {
                                answer += temp.size();
                                continue loop;
                            }
                        }
                        while (!temp.isEmpty()) {
                            blank.offer(temp.poll());
                        }
                        check.clear();
                        for (int[] pos : piece) {
                            check.add(new int[] {pos[1] - cur[1], cur[0] - pos[0]});
                        }
                        while (true) {
                            int[] c1 = blank.poll();
                            int[] c2 = check.poll();
                            if (c1[0] != c2[0] || c1[1] != c2[1]) break;
                            temp.add(c1);
                            if (blank.size() == 0) {
                                answer += temp.size();
                                continue loop;
                            }
                        }
                        while (!temp.isEmpty()) {
                            blank.offer(temp.poll());
                        }
                        check.clear();
                        for (int[] pos : piece) {
                            check.add(new int[] {cur[0] - pos[0], cur[1] - pos[1]});
                        }
                        while (true) {
                            int[] c1 = blank.poll();
                            int[] c2 = check.poll();
                            if (c1[0] != c2[0] || c1[1] != c2[1]) break;
                            temp.add(c1);
                            if (blank.size() == 0) {
                                answer += temp.size();
                                continue loop;
                            }
                        }
                        while (!temp.isEmpty()) {
                            blank.offer(temp.poll());
                        }
                        check.clear();
                    }
                    
                }
            }
        }
        return answer;
    }
}