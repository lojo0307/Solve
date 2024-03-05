import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        Node head = new Node(-1);
        Node cur = head;
        for (int i = 0; i < n; i++) {
            Node node = new Node(i);
            cur.next = node;
            node.prev = cur;
            cur = node;
        }
        while (cur.idx != k) {
            cur = cur.prev;
        }
        Stack<Node> stack = new Stack();
        
        for (int i = 0; i < cmd.length; i++) {
            switch (cmd[i].charAt(0)) {
                case 'U':
                    int cnt = Integer.parseInt(cmd[i].substring(2));
                    while (cnt-- > 0) cur = cur.prev;
                    break;
                case 'D': 
                    int cnt1 = Integer.parseInt(cmd[i].substring(2));
                    while (cnt1-- > 0) cur = cur.next;
                    break;
                case 'C': 
                    stack.add(cur);
                    cur.prev.next = cur.next;
                    if (cur.next != null) cur.next.prev = cur.prev;
                    cur = cur.next != null ? cur.next : cur.prev;
                    break;
                case 'Z':
                    Node temp = stack.pop();
                    temp.prev.next = temp;
                    if (temp.next != null) temp.next.prev = temp;
                    break;
            }
        }
        
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append("O");
        while (!stack.isEmpty()) {
            sb.setCharAt(stack.pop().idx ,'X');
        }
        
        return sb.toString();
    }
}

class Node {
    int idx;
    Node prev;
    Node next;
    public Node(int idx) {
        this.idx = idx;
    }
}