import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {-1, 0});
        while (!q.isEmpty()) {
            int cur = q.peek()[0];
            int cnt = q.poll()[1];
            
            String word = cur == -1 ? begin : words[cur];
            for (int i = 0; i < words.length; i++) {
                if (visited[i]) continue;
                if (check(words[i], word)) {
                    if (words[i].equals(target)) return cnt+1;
                    visited[i] = true;
                    q.offer(new int[] {i, cnt+1});
                }
            }
        }
        return 0;
    }
    
    private boolean check (String a, String b) {
        int cnt = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                cnt++;
                if (cnt > 1) return false;
            }
        }
        if (cnt == 1) return true;
        return false;
    }
}