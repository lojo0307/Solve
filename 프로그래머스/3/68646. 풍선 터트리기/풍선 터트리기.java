import java.util.*;

class Solution {
    public int solution(int[] a) {
        PriorityQueue<Integer> left = new PriorityQueue<>();
        PriorityQueue<int[]> right = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        
        for (int i = 2; i < a.length; i++) right.offer(new int[] {a[i], i});
        left.offer(a[0]);
        
        if (a.length == 1) return 1;
        int ans = 2;
        
        for (int i = 1; i < a.length - 1; i++) {
            while (right.peek()[1] <= i) right.poll();
            if (!(left.peek() < a[i] && right.peek()[0] < a[i]))ans++;
            left.offer(a[i]);
        }
        
        return ans;
    }
}