import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        int n = 0;
        int node = 0;
        for (int[] e : edges) {
            n = Math.max(e[0], n);
            n = Math.max(e[1], n);
        }
        List<Integer>[] link = new LinkedList[n+1];
        for (int i = 1; i <= n; i++) link[i] = new LinkedList<>();
        for (int[] e : edges) link[e[0]].add(e[1]);
        
        for (int i = 1; i <= n; i++) if (link[i].size() > 2) node = i;
        
        if (node == 0) { // 그래프가 2개
            Set<Integer> set = new HashSet<>();
            for (int[] e : edges) set.add(e[1]);
            for (int i = 1; i <= n; i++) {
                if (!set.contains(i) && link[i].size() == 2) node = i;
            }
        }
        
        int[] ans = new int[] {node, 0, 0, 0};
        boolean[] visited = new boolean[n+1];
        for (int next : link[node]) {
            while (true) {
                if (link[next].size() == 0) {
                    ans[2]++;
                    break;
                } else if (link[next].size() > 1) {
                    ans[3]++;
                    break;
                } else if (visited[next]) {
                    ans[1]++;
                    break;
                }
                visited[next] = true;
                next = link[next].get(0);
            }
        }
        
        return ans;
    }
}