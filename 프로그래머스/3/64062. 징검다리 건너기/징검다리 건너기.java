import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        for(int i = 0; i < stones.length; i++) pq.offer(new int[]{stones[i], i});
        if (pq.peek()[0] == 0 && k <= 1) return 0;
        if (k == 1) return pq.peek()[0];
        int ans = 0;
        
        int[] len = new int[stones.length];
        parent = new int[stones.length];
        for (int i = 1; i < parent.length; i++) parent[i] = i;
        
        while (!pq.isEmpty()) {
            int idx = pq.poll()[1];
            ans = stones[idx];
            stones[idx] = 0;
            len[idx] = 1;
            
            if (idx != 0 && stones[idx-1] == 0) {
                len[idx] += len[find(idx-1)];
                union(idx-1, idx);
            }
            
            if (idx + 1 != stones.length && stones[idx+1] == 0) {
                len[idx] += len[find(idx+1)];
                union(idx+1, idx);
            }
            
            if (len[idx] >= k) return ans;
        }
        
        return -1;
    }
    
    static int[] parent;
    
    public int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }
    
    public void union(int a, int b) {
        parent[find(a)] = find(b);
    }
}