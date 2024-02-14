import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        
        int a = A.length - 1;
        int b = B.length - 1;
        int cnt = 0;
        
        while (a >= 0 && b >= 0) {
            if (A[a] < B[b]) {
                cnt++;
                b--;
            }
            a--;
        }
        
        return cnt;
    }
}