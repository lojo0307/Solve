class Solution {
    public int solution(int[] a) {
        int[] cnt = new int[a.length];
        boolean[] checked = new boolean[a.length];
        for (int n : a) cnt[n]++;
        
        int ans = 0;
        
        for (int i = 0; i < a.length; i++) {
            if (cnt[a[i]] == 0 || cnt[a[i]] <= ans || checked[a[i]]) continue;
            checked[a[i]] = true;
            int len = 0;
            for (int j = (i-1 < 0 ? 0 : i-1); j < a.length - 1; j++) {
                if (a[j] == a[i] || a[j+1] == a[i]) {
                    if (a[j] == a[j+1]) continue;
                    len++;
                    j++;
                }
            }
            ans = Math.max(ans, len);
        }
        return ans * 2;
    }
}