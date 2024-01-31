import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        Queue<Integer> pq = new PriorityQueue<>();
        
        for (String msg : operations) {
            if (msg.charAt(0) == 'I') {
                int num = Integer.parseInt(msg.substring(2, msg.length()));
                pq.offer(num);
            } else if (msg.charAt(2) == '1') {
                if (pq.isEmpty()) continue;
                Queue<Integer> copy = new PriorityQueue<>();
                while (pq.size() != 1) {
                    copy.offer(pq.poll());
                }
                pq = copy;
            } else {
                if (pq.isEmpty()) continue;
                pq.poll();
            }
        }
        
        if (pq.isEmpty()) return new int[] {0, 0};
        int[] answer = new int[2];
        answer[1] = pq.poll();
        if (pq.isEmpty()) answer[0] = answer[1];
        else {
            while (pq.size() != 1) {
                pq.poll();
            }
            answer[0] = pq.poll();
        }
        
        return answer;
    }
}