import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        
        int res = 0;
        int b = 0;
        loop : for (int a = 0; a < A.length; a++) {
            while (A[a] >= B[b]) if (++b == B.length) break loop;
            res++;
            if (++b == B.length) break loop;
        }
        
        return res;
    }
}