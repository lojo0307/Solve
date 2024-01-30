import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        Queue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int work : works) {
            pq.offer(work);
        }
        
        while (n-- > 0 && !pq.isEmpty()) {
            int num = pq.poll();
            if (num != 1) pq.offer(num - 1);
        }
        
        int answer = 0;
        while (!pq.isEmpty()) {
            answer += Math.pow(pq.poll(), 2);
        }
        return answer;
    }
}