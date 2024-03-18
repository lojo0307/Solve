import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < name.length; i++) map.put(name[i], yearning[i]);
        
        int[] ans = new int[photo.length];
        for (int i = 0; i < ans.length; i++) for (String n : photo[i]) if (map.containsKey(n)) ans[i] += map.get(n);
        return ans;
    }
}