import java.util.*;

class Solution {
    public int solution(String[] user_id, String[] banned_id) {
        arr = new ArrayList[banned_id.length];
        for (int i = 0; i < banned_id.length; i++) {
            arr[i] = new ArrayList<>();
            for (int j = 0; j < user_id.length; j++) {
                if (check(user_id[j], banned_id[i])) arr[i].add(j);
            }
        }
        
        n = banned_id.length;
        set = new HashSet<>();
        ans = new int[n];
        visited = new boolean[user_id.length];
        dfs(0);
        
        return set.size();
    }
    
    static List<Integer>[] arr;
    static int[] ans;
    static Set<String> set;
    static boolean[] visited;
    static int n;
    
    public void dfs(int i) {
        if (i == n) {
            int[] copy = Arrays.copyOf(ans, n);
            Arrays.sort(copy);
            String str = "";
            for(int j = 0; j < n; j++) str += copy[j];
            set.add(str);
            return;
        }
        
        for (int j = 0; j < arr[i].size(); j++) {
            int cur = arr[i].get(j);
            if (visited[cur]) continue;
            visited[cur] = true;
            ans[i] = cur;
            dfs(i+1);
            visited[cur] = false;
        }
        return;
    }
    
    public boolean check(String uid, String bid) {
        if (uid.length() != bid.length()) return false;
        for (int i = 0; i < uid.length(); i++) {
            char a = bid.charAt(i);
            if (a == '*') continue;
            if (a != uid.charAt(i)) return false;
        }
        
        return true;
    }
}