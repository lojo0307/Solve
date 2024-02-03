import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        parent = new int[n];
        for (int i = 1; i < n; i++) {
            parent[i] = i;
        }
        
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if (computers[i][j] == 1) union(i, j);
            }
        }
        for (int i = 0; i < n; i++) {
            find(i);
        }
        Set<Integer> set = new HashSet<>();
        for (int num : parent) {
            set.add(num);
        }
        return set.size();
    }
    
    static int[] parent;
    public void union (int a, int b) {
        parent[find(b)] = find(a);
    }
    public int find (int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }
}