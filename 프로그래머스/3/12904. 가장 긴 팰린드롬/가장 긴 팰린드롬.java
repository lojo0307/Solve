class Solution
{
    public int solution(String s)
    {
        char[] a = s.toCharArray();
        int max = 0;
        for (int i = 0; i < a.length; i++) { // 문자열이 홀수길이
            if (max / 2 + i >= a.length) break;
            int len = 1;
            while (i - len >= 0 && i + len < a.length) {
                if (a[i-len] != a[i+len]) break;
                len++;
            }
            max = Math.max(--len * 2 + 1, max);
        }
        for (int i = 0; i < a.length; i++) { // 문자열이 짝수길이
            if (max / 2 + i >= a.length) break;
            int len = 1;
            while (i - len >= 0 && i + len - 1 < a.length) {
                if (a[i-len] != a[i+len-1]) break;
                len++;
            }
            max = Math.max(--len * 2, max);
        }
        return max;
    }
}