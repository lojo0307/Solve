import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int w : works) pq.offer(w);
        while (n-- > 0) {
            int num = pq.poll();
            if (num == 0) return 0;
            pq.offer(num-1);
        }
        
        long ans = 0;
        while (!pq.isEmpty()) ans += Math.pow(pq.poll(), 2);
        
        return ans;
    }
}