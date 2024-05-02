import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < elements.length; i++) {
            int num = elements[i];
            set.add(num);
            int idx = (i == elements.length - 1 ? 0 : i + 1);
            while (idx != i) {
                num += elements[idx];
                set.add(num);
                if (++idx >= elements.length) idx = 0;
            }
        }
        
        return set.size();
    }
}