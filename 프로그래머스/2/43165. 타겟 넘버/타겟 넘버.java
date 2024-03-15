class Solution {
    public int solution(int[] numbers, int target) {
        num = new int[numbers.length];
        tar = target;
        cnt = 0;
        for (int i = 0; i < numbers.length; i++) num[i] = numbers[i];
        
        cal(0, 0);
        return cnt;
    }
    
    static int cnt;
    static int[] num;
    static int tar;
    
    public void cal(int idx, int n) {
        if (idx == num.length) {
            if (n == tar) cnt++;
            return;
        }
        cal(idx+1, n+num[idx]);
        cal(idx+1, n-num[idx]);
    }
}