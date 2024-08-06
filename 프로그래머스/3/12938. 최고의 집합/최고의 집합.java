class Solution {
    public int[] solution(int n, int s) {
        if (s < n) return new int[] {-1};
        int a = s / n;
        int b = s % n;
        int[] ans = new int[n];
        for (int i = 0; i < n-b; i++) ans[i] = a;
        for (int i = n-b; i < n; i++) ans[i] = a+1;
        return ans;
        
    }
}