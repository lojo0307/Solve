import java.util.*;

class Solution {
    public int solution(int[][] board) {
        boolean[][][] visited = new boolean[board.length][board[0].length][4];
        Queue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.offer(new Node(0, 0, 0, 0));
        pq.offer(new Node(0, 0, 0, 1));
        pq.offer(new Node(0, 0, 0, 2));
        pq.offer(new Node(0, 0, 0, 3));
        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, -1, 0, 1};
        
        
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.r == board.length - 1 && cur.c == board[0].length - 1) return cur.cost;
            if (visited[cur.r][cur.c][cur.dist] || board[cur.r][cur.c] == 1) continue;
            visited[cur.r][cur.c][cur.dist] = true;
            
            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                
                if (nr < 0 || nc < 0 || nr >= board.length || nc >= board[0].length) continue;
                if (visited[nr][nc][i]) continue;
                
                pq.offer(new Node(nr, nc, cur.cost + (cur.dist == i ? 100 : 600), i));
            }
        }
        
        return -1;
    }
}

class Node {
    int r;
    int c;
    int cost;
    int dist; // 0:우 1:하 2:좌 3:상
    public Node(int r, int c, int cost, int dist) {
        this.r = r;
        this.c = c;
        this.cost = cost;
        this.dist = dist;
    }
}