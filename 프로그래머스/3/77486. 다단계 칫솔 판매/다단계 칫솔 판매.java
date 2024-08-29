import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, String> refer = new HashMap<>();
        for (String e : enroll) map.put(e, 0);
        for (int i = 0; i < enroll.length; i++) if (!referral[i].equals("-")) refer.put(enroll[i], referral[i]);
        
        for (int i = 0; i < seller.length; i++) {
            String nn = seller[i];
            int dif = amount[i] * 100;
            map.put(nn, map.get(nn) + dif);
            
            while (true) {
                if (!refer.containsKey(nn)) {
                    map.put(nn, map.get(nn) - dif / 10);
                    break;
                }
                dif /= 10;
                if (dif == 0) break;
                map.put(nn, map.get(nn) - dif);
                nn = refer.get(nn);
                map.put(nn, map.get(nn) + dif);
            }
        }
        
        int[] ans = new int[enroll.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = map.get(enroll[i]);
        }
        
        return ans;
    }
}