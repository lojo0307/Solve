import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        parent = new int[n];
        for (int i = 0; i < parent.length; i++) parent[i] = i;
        
        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < computers[i].length; j++) {
                if (i == j || computers[i][j] == 0) continue;
                union(i, j);
            }
        }
        
        Set<Integer> set = new HashSet<>();
        for (int p : parent) {
            set.add(find(p));
        }
        
        return set.size();
    }
    
    static int[] parent;
    
    static void union(int a, int b) {
        parent[find(Math.max(a, b))] = find(Math.min(a, b));
    }
    
    static int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }
}