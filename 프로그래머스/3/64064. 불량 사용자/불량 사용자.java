import java.util.*;

class Solution {
    public int solution(String[] user_id, String[] banned_id) {
        possible = new HashSet[banned_id.length];
        visited = new boolean[user_id.length];
        
        for (int i = 0; i < possible.length; i++) {
            possible[i] = new HashSet<>();
        }
        
        for (int i = 0; i < banned_id.length; i++) {
            for (int j = 0; j < user_id.length; j++) {
                if (check(user_id[j], banned_id[i])) {
                    possible[i].add(j);
                }
            }
        }
        
        array = new int[banned_id.length];
        answer = new HashSet<>();
        
        build(0);
        return answer.size();
        
    }
    
    public static boolean[] visited;
    public static int[] array;
    public static Set<String> answer;
    public static Set<Integer>[] possible;
    
    public static void build(int idx) {
        if (idx == array.length) {
            int[] copy = Arrays.copyOf(array, array.length);
            Arrays.sort(copy);
            String temp = "";
            for (int i : copy) {
                temp += i;
            }
            answer.add(temp);
            return;
        }
        for (int element : possible[idx]) {
            if (visited[element]) continue;
            array[idx] = element;
            visited[element] = true;
            build(idx + 1);
            visited[element] = false;
        }
    }
    
    public static boolean check(String a, String b) {
        if (a.length() != b.length()) return false;
        char[] aa = a.toCharArray();
        char[] bb = b.toCharArray();
        for (int i = 0; i < aa.length; i++) {
            if (bb[i] == '*') continue;
            if (aa[i] != bb[i]) return false;
        }
        return true;
    }
}