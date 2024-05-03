import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        char bef = s.charAt(0);
        stack.add(bef);
        
        for (int i = 1; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (bef == cur) {
                stack.pop();
                if (stack.size() != 0) {
                    bef = stack.peek();
                    continue;
                } else {
                    if (i == s.length() - 1) continue;
                    bef = s.charAt(++i);
                    stack.add(bef);
                }
            } else {
                bef = cur;
                stack.add(cur);
            }
        }
        
        return stack.size() == 0 ? 1 : 0;
    }
}