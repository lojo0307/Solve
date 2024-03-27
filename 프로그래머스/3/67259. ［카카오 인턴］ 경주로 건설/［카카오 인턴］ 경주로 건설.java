import java.util.*;

class Solution {
    public int solution(int[][] board) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        Queue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        return 1;
    }
}

class Node {
    int r;
    int c;
    int cost;
    int dist; // 0:우 1:하 2:좌 3:상
}