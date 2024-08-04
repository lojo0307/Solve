import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(begin, 0));
        boolean[] visited = new boolean[words.length];
        while (!q.isEmpty()) {
            int cnt = q.peek().cnt;
            String word = q.poll().word;
            
            for (int i = 0; i < words.length; i++) {
                if (visited[i] || !next(word, words[i])) continue;
                if (words[i].equals(target)) return cnt + 1;
                visited[i] = true;
                q.offer(new Node(words[i], cnt+1));
            }
        }
        
        return 0;
    }
    
    static boolean next(String w1, String w2) {
        int cnt = 0;
        for(int i = 0; i < w1.length(); i++) {
            if (w1.charAt(i) == w2.charAt(i)) continue;
            cnt++;
        }
        
        return cnt == 1 ? true : false;
    }
}

class Node {
    int cnt;
    String word;
    Node(String word, int cnt) {
        this.cnt = cnt;
        this.word = word;
    }
}