import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        List<Node>[] list = new LinkedList[n];
        for (int i = 0; i < n; i++) list[i] = new LinkedList<>();
        for (int[] c : costs) {
            list[c[0]].add(new Node(c[1], c[2]));
            list[c[1]].add(new Node(c[0], c[2]));
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.offer(new Node(0, 0));
        boolean[] visited = new boolean[n];
        int ans = 0;
        
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            if (visited[cur.node]) continue;
            visited[cur.node] = true;
            ans += cur.cost;
            for (Node next : list[cur.node]) {
                if (visited[next.node]) continue;
                pq.offer(new Node(next.node, next.cost));
            }
        }
        
        return ans;
    }
}

class Node {
    int node;
    int cost;
    public Node(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
}