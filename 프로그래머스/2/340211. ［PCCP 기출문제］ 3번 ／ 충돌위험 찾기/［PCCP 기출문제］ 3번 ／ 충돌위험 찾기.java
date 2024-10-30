import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>(){
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.t != o2.t) return o1.t - o2.t;
                if (o1.r != o2.r) return o1.r - o2.r;
                return o1.c - o2.c;
            }
        });
        
        for (int[] r : routes) {
            Queue<Integer> q = new LinkedList<>();
            for (int i = 1; i < r.length; i++) q.offer(r[i]-1);
            pq.offer(new Node(0, points[r[0]-1][0], points[r[0]-1][1], q));
        }
        
        int ans = 0;
        int t = 0;
        int r = -1;
        int c = -1;
        boolean flag = true;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (t == cur.t && r == cur.r && c == cur.c) {
                if (flag) ans++;
                flag = false;
            } else flag = true;
            
            r = cur.r;
            c = cur.c;
            t = cur.t;
            if (cur.goal.isEmpty()) continue;
            
            int gr = points[cur.goal.peek()][0];
            int gc = points[cur.goal.peek()][1];
            if (cur.r < gr) cur.r++;
            else if (cur.r > gr) cur.r--;
            else if (cur.c < gc) cur.c++;
            else if (cur.c > gc) cur.c--;
            if (cur.r == gr && cur.c == gc) cur.goal.poll();
            cur.t++;
            
            pq.offer(cur);
        }
        
        return ans;
    }
}

class Node {
    int t;
    int r;
    int c;
    Queue<Integer> goal;
    Node(int t, int r, int c, Queue<Integer> goal) {
        this.t = t;
        this.r = r;
        this.c = c;
        this.goal = goal;
    }
}