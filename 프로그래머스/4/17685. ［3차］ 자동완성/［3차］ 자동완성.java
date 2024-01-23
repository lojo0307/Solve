import java.util.*;

class Solution {
    public int solution(String[] words) {
        int answer = 0;
        Node node = new Node();
        for (String word : words) {
            Node curNode = node;
            for (int i = 0; i < word.length(); i++) {
                if (!curNode.child.containsKey(word.charAt(i)))
                    curNode.child.put(word.charAt(i), new Node());
                curNode = curNode.child.get(word.charAt(i));
                curNode.cnt++;
            }
        }
        
        
        for (String word : words) {
            Node curNode = node;
            for (int i = 0; i < word.length(); i++) {
                curNode = curNode.child.get(word.charAt(i));
                answer++;
                if (curNode.cnt == 1) break;
            }
        }
        
        return answer;
    }
    
    public class Node {
        Map<Character, Node> child = new HashMap<>();
        int cnt;
        public Node() {
            this.child = new HashMap<>();
            this.cnt = 0;
        }
    }
}