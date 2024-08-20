class Solution
{
    public int solution(String s)
    {
        int max = 1;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            int len = 1;
            while (i - len >= 0 && i + len < arr.length) {
                if (arr[i-len] != arr[i+len]) break;
                len++;
            }
            len = (len - 1) * 2 + 1;
            max = Math.max(max, len);
            
            len = 0;
            while (i - len >= 0 && i + len + 1 < arr.length) {
                if (arr[i-len] != arr[i+len+1]) break;
                len++;
            }
            len = len * 2;
            max = Math.max(max, len);
        }
        
        return max;
    }
}