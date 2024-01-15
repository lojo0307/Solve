import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        Stack<Integer> stack = new Stack<Integer>();
        int idx = 0;
        int cnt = 0;
        
        while (idx < ingredient.length) {
            if (ingredient[idx] == 1 && stack.size() > 2) {
                int temp = stack.pop();
                if (temp == 3) {
                    int temp2 = stack.pop();
                    if (temp2 == 2) {
                        int temp3 = stack.pop();
                        if (temp3 == 1) cnt++;
                        else {
                            stack.add(temp3);
                            stack.add(2);
                            stack.add(3);
                            stack.add(1);
                        }
                    } else {
                        stack.add(temp2);
                        stack.add(3);
                        stack.add(1);
                    }
                } else {
                    stack.add(temp);
                    stack.add(1);
                }
            } else stack.add(ingredient[idx]);
            idx++;
        }
        
        return cnt;
    }
}