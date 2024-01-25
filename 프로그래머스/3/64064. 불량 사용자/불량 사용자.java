class Solution {
    public int solution(String[] user_id, String[] banned_id) {
        possible = new HashSet[banned_id.length];
        visited = new boolean[user_id.length];
        
        for (List<Integer> a : possible) {
            a = new HashSet<>();
        }
        
        for (int i = 0; i < banned_id.length; i++) {
            for (int j = 0; j < user_id.length; j++) {
                if (check(user_id[j], banned_id[i])) {
                    possible[i].add(j);
                }
            }
        }
        
        array = new int[banned_id.length];
        for (int e : array) {
            e = -1;
        }
        int idx = 0;
        while (idx < banned_id.length) {
            if (possible[idx].size() == 1) {
                int temp = -1;
                possible[idx].stream().findFirst().ifPresent(element ->
                    temp = element
                );
                array[idx] = temp;
                visited[temp] = true;
                for (Set<Integer> set : possible) {
                    if (set.contains(temp)) set.remove(temp);
                }
                idx = 0;
                continue;
            }
            idx++;
        }
        
        answer = new HashSet<>();
        build(0);
        return answer.size();
        
        
    }
    
    public static boolean[] visited;
    public static int[] array;
    public static Set<int[]> answer;
    public static Set<Integer>[] possible;
    
    public static void build(int idx) {
        if (idx == array.length) {
            answer.add(Arrays.sort(Arrays.copyOf(array)));
            return;
        }
        if (possible[idx].size() == 0) build(++idx);
        for (int element : possible[idx]) {
            if (visited[element]) continue;
            array[idx] = element;
            visited[element] = true;
            build(++idx);
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