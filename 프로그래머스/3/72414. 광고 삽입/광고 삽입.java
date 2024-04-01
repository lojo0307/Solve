class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        int t1 = Integer.parseInt(play_time.substring(0,2))*3600 + Integer.parseInt(play_time.substring(3,5))*60 + Integer.parseInt(play_time.substring(6,8));
        int t2 = Integer.parseInt(adv_time.substring(0,2))*3600 + Integer.parseInt(adv_time.substring(3,5))*60 + Integer.parseInt(adv_time.substring(6,8));
        int[] log = new int[t1+1];
        for (int i = 0; i < logs.length; i++) {
            log[Integer.parseInt(logs[i].substring(0,2))*3600 + Integer.parseInt(logs[i].substring(3,5))*60 + Integer.parseInt(logs[i].substring(6,8))]++;
            log[Integer.parseInt(logs[i].substring(9,11))*3600 + Integer.parseInt(logs[i].substring(12,14))*60 + Integer.parseInt(logs[i].substring(15,17))]--;
        }
        
        for (int i = 1; i < log.length; i++) log[i] += log[i-1];
        
        long sum = 0;
        long max = 0;
        int ans = 0;
        
        for (int i = 0; i < t2-1; i++) sum += log[i];
        
        for (int i = 0; i <= t1 - t2; i++) {
            if (i>0) sum -= log[i-1];
            sum += log[i+t2-1];
            if (sum > max) {
                max = sum;
                ans = i;
            }
        }
        
        return (ans/3600 < 10 ? "0" : "") + ans/3600 + ":" + (ans%3600/60 < 10 ? "0" : "") + ans%3600/60 + ":" + (ans%60 < 10 ? "0" : "") + ans%60;
    }
}