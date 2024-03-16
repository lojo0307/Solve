class Solution {
    public int solution(int[] arr) {
        int ans = cal(arr[0], arr[1]);
        int idx = 2;
        
        while (idx < arr.length) ans = cal(ans, arr[idx++]);
        
        return ans;
    }
    
    public int cal(int a, int b) {
        int k = Math.min(a, b);
        int max = 1;
        for (int i = 1; i <= k; i++) if (a % i == 0 && b % i == 0) max = i;
        return a * b / max;
    }
}