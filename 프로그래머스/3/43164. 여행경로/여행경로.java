import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {
        map = new HashMap<>();
        n = tickets.length + 1;
        for(int i = 0; i < tickets.length; i++) {
            if (!map.containsKey(tickets[i][0])) map.put(tickets[i][0], new LinkedList<>());
            map.get(tickets[i][0]).add(new Node(tickets[i][1], i));
        }
        
        visited = new boolean[tickets.length];
        map.forEach((key, value) -> value.sort((o1, o2) -> o1.code.compareTo(o2.code)));
        
        ans = new String[n];
        ans[0] = "ICN";
        dfs(1);
        return ans;
    }
    
    static String[] ans;
    static int n;
    static Map<String, List<Node>> map;
    static boolean[] visited;
    static boolean flag;
    
    public void dfs(int idx) {
        if (idx == n) {
            flag = true;
            return;
        }
        if (!map.containsKey(ans[idx-1])) return;
        for (Node next : map.get(ans[idx-1])) {
            if (visited[next.idx]) continue;
            visited[next.idx] = true;
            ans[idx] = next.code;
            dfs(idx+1);
            if (flag) return;
            visited[next.idx] = false;
        }
    }
}

class Node {
    String code;
    int idx;
    public Node(String code, int idx) {
        this.code = code;
        this.idx = idx;
    }
}