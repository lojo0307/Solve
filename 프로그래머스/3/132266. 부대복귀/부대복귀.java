import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        List<Integer>[] list = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) list[i] = new ArrayList<>();
        for(int[] road : roads) {
            list[road[0]].add(road[1]);
            list[road[1]].add(road[0]);
        }
        boolean[] visited = new boolean[n+1];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < sources.length; i++) map.put(sources[i], i);
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {destination, 0});
        visited[destination] = true;
        int[] ans = new int[sources.length];
        for (int i = 0; i < ans.length; i++) ans[i] = -1;
        if (map.containsKey(destination)) ans[map.get(destination)] = 0;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for (int next : list[cur[0]]) {
                if (visited[next]) continue;
                visited[next] = true;
                q.offer(new int[] {next, cur[1] + 1});
                if (map.containsKey(next)) ans[map.get(next)] = cur[1] + 1;
            }
        }
        
        return ans;
    }
}