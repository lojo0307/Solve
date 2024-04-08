class Solution {
    public int solution(int n) {
        String bin = Integer.toBinaryString(n);
        int cnt = 0;
        for (int i = 0; i < bin.length(); i++) if (bin.charAt(i) == '1') cnt++;
        
        int num = n + 1;
        while (true) {
            String newBin = Integer.toBinaryString(num);
            int cnt1 = 0;
            for (int i = 0; i < newBin.length(); i++) if (newBin.charAt(i) == '1') cnt1++;
            if (cnt == cnt1) return num;
            num++;
        }
    }
}