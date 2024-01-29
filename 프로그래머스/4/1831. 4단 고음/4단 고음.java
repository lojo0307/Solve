class Solution {
    public int solution(int n) {
        return cal(n-2, 2);
    }
    
    public static int cal(int num, int cnt) {
        if (num == 3 && cnt == 2) return 1;
        if (num <= 3 || Math.log(num) / Math.log(3) * 2 < cnt) return 0;
        
        return cal(num - 1, cnt + 1) + (num % 3 == 0 && cnt >= 2 ? cal(num / 3, cnt-2) : 0);
    }
}