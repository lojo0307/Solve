import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int start = 0;
        int end = 0;
        int sum = sequence[0];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        while (end < sequence.length) {
            if (sum > k) {
                sum -= sequence[start++];
            } else if (sum < k) {
                if (end == sequence.length - 1) break;
                sum += sequence[++end];
            } else {
                pq.offer(new int[] {end - start, start, end});
                if (end == sequence.length - 1) break;
                sum += sequence[++end];
                sum -= sequence[start++];
            };
        }
        
        int[] answer = pq.poll();
        return new int[] {answer[1], answer[2]};
    }
}