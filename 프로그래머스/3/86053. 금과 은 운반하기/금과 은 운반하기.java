import java.util.*;

class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long start = 0;
        long end = 0;
        long answer = 0;
        
        long gold = a;
        long silver = b;
        // 최악의 케이스 계산
        for (int i = 0; i < g.length; i++) {
            long sum = g[i] + s[i];
            end += ((sum / w[i] + 1) * 2 - 1) * t[i];
            gold -= g[i];
            silver -= s[i];
            if (gold <= 0 && silver <= 0) break;
        }
        
        while (start <= end) {
            long middle = (start + end) / 2;
            gold = 0;
            silver = 0;
            
            long maxGold = 0;
            long maxSilver = 0;
            long maxWeight = 0;
            for (int i = 0; i < t.length; i++) {
                long cnt = middle / t[i];
                if (cnt % 2 == 0) cnt = cnt / 2;
                else cnt = cnt / 2 + 1;
                
                if (g[i] + s[i] <= cnt * w[i]) {
                    gold += g[i];
                    silver += s[i];
                } else {
                    if (g[i] / w[i] >= cnt) maxGold += cnt * w[i];
                    else maxGold += g[i];
                    
                    if (s[i] / w[i] >= cnt) maxSilver += cnt * w[i];
                    else maxSilver += s[i];
                    
                    maxWeight += w[i] * cnt;
                }
            }
            
            if (gold + maxGold >= a && silver + maxSilver >= b && maxWeight >= (a - gold + b - silver)) {
                answer = middle;
                end = middle - 1;}
            else start = middle + 1;
        }
        return answer;
    }
}