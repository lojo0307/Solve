import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        
        int wanho = scores[0][0] + scores[0][1];
        int a = scores[0][0];
        int b = scores[0][1];
        
        List<int[]> list = new LinkedList<>();
        for (int[] s : scores) list.add(s);
        Collections.sort(list, new Comparator<>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) return o2[0] - o1[0];
                return o1[1] - o2[1];
            }
        });
        
        int idx = 1;
        while (idx < list.size()) {
            if (list.get(idx)[1] < list.get(idx-1)[1]) {
                if (list.get(idx)[0] == a && list.get(idx)[1] == b) return -1;
                list.remove(idx);
                continue;
            }
            idx++;
        }
        
        int ans = 1;
        for (int[] i : list) {
            if (i[0] + i[1] > wanho) ans++;
        }
        
        return ans;
    }
}