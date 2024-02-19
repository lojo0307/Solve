class Solution {
    public int solution(int n) {
        open = n;
        close = n;
        return cal(2 * n);
    }
    
    static int open;
    static int close;
    // static int cnt;
    
    public int cal(int idx) {
        if (idx == 0) return 1;
        int cnt = 0;
        if (close == open) {
            // 무조건 닫아야
            close--;
            cnt = cal(idx-1);
            close++;
        } else {
            // 열어도 되고 닫아도 되고
            if (close > 0) {
                close--;
                cnt += cal(idx-1);
                close++;
            }
            open--;
            cnt += cal(idx-1);
            open++;
        }
        return cnt;
    }
}