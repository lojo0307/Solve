import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        boolean[] r = new boolean[n];
        Stack<Integer> stack = new Stack();
        int idx = k;
        
        for(int i = 0; i < cmd.length; i++) {
            switch (cmd[i].charAt(0)) {
                case 'U' : // up
                    int cnt = Integer.parseInt(cmd[i].substring(2));
                    while (cnt-- > 0) {
                        if (r[--idx]) cnt++;
                    }
                    break;
                case 'D' : // down
                    int cnt1 = Integer.parseInt(cmd[i].substring(2));
                    while (cnt1-- > 0) {
                        if (r[++idx]) cnt1++;
                    }
                    break;
                case 'C' : // del + down
                    r[idx] = true;
                    stack.add(idx);
                    int temp = idx - 1;
                    if (idx + 1 == n) {
                        while (r[idx]) {idx--;}
                    } else {
                        loop : while (r[++idx]) {
                        if (idx == n - 1) {
                            idx = temp;
                            while (r[idx]) {idx--;}
                            break loop;
                            }
                        }
                    }
                    
                    break;
                case 'Z' : // restore
                    r[stack.pop()] = false;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (!r[i]) sb.append("O");
            else sb.append("X");
        }
        
        return sb.toString();
    }
}