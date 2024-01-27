import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        if (n > s) return new int[] {-1};
        int a = s / n;
        int b = s - a * n;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = a;
            if (b > 0) {
                arr[i]++;
                b--;
            }
        }
        Arrays.sort(arr);
        return arr;
    }
}