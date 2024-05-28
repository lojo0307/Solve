import java.util.*;

class Solution {
    static void dfs(String start, int i) {
        if (i == num + 1) {
            flag = true;
            return;
        }
        
        List<Next> list = map.getOrDefault(start, new ArrayList<>());
        for (Next n : list) {
            if (visited[n.idx]) continue;
            visited[n.idx] = true;
            ans[i] = n.arr;
            dfs(n.arr, i + 1);
            if (flag) return;
            visited[n.idx] = false;
        }
    }
    
    static Map<String, List<Next>> map;
    static boolean[] visited;
    static String[] ans;
    static int num;
    static boolean flag;
    
    public String[] solution(String[][] tickets) {
        num = tickets.length;
        ans = new String[tickets.length + 1];
        map = new HashMap<>();
        for (int i = 0; i < tickets.length; i++) {
            if (!map.containsKey(tickets[i][0])) map.put(tickets[i][0], new ArrayList<>());
            map.get(tickets[i][0]).add(new Next(tickets[i][1], i));
        }
        map.forEach((key, val) -> {
            Collections.sort(val, (a, b) -> a.arr.compareTo(b.arr));
        });
        
        visited = new boolean[tickets.length];
        ans[0] = "ICN";
        dfs("ICN", 1);
        return ans;
    }
}

class Next {
    String arr;
    int idx;
    public Next(String arr, int idx) {
        this.arr = arr;
        this.idx = idx;
    }
}