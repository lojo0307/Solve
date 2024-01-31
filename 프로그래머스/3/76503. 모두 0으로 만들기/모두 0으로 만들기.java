import java.util.*;

class Solution {
    public long solution(int[] a, int[][] edges) {
        
        long[] copy = new long[a.length];
        for (int i = 0; i < copy.length; i++) {
            copy[i] = a[i];
        }
        
        long sum = 0;
        for (int num : a) {
            sum += num;
        }
        if (sum != 0) return -1;
        
        Set<Integer>[] links = new HashSet[a.length];
        for (int i = 0; i < links.length; i++) {
            links[i] = new HashSet<>();
        }
        for (int[] edge : edges) {
            links[edge[0]].add(edge[1]);
            links[edge[1]].add(edge[0]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < links.length; i++) {
            if (links[i].size() == 1) q.offer(i);
        }
        
        long cnt = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            int next = -1;
            for (int num : links[cur]) next = num;
            if (next == -1) return cnt + Math.abs(copy[cur]);
            copy[next] += copy[cur];
            cnt += Math.abs(copy[cur]);
            links[next].remove(cur);
            if (links[next].size() == 1) q.offer(next);
        }
        
        return cnt;
    }
}