import java.util.*;

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        StringTokenizer token = new StringTokenizer(play_time, ":");
        int[] play = new int[time(token) + 1];
        
        for (String log : logs) {
            token = new StringTokenizer(log.substring(0, 8), ":");
            play[time(token)]++;
            token = new StringTokenizer(log.substring(9, 17), ":");
            play[time(token)]--;
        }
        
        for (int i = 1; i < play.length; i++) play[i] += play[i-1];
        
        token = new StringTokenizer(adv_time, ":");
        int t = time(token);
        int ans = 0;
        long sum = 0;
        for (int i = 0; i < t; i++) sum += play[i];
        long max = sum;
        for (int i = t; i < play.length; i++) {
            sum -= play[i-t];
            sum += play[i];
            if (sum > max) {
                max = sum;
                ans = i - t + 1;
            }
        }
        
        return (ans / 3600 < 10 ? "0" : "") + ans / 3600 + (ans % 3600 / 60 < 10 ? ":0" : ":") + ans % 3600 / 60 + (ans % 60 < 10 ? ":0" : ":") + ans % 60;
    }
    
    public int time(StringTokenizer token) {
        return Integer.parseInt(token.nextToken()) * 3600 + Integer.parseInt(token.nextToken()) * 60 + Integer.parseInt(token.nextToken());
    }
}