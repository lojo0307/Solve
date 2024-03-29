import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> set = new HashSet<>();
        Map<String, Integer> countMap = new HashMap<>();
        int total = 0;
        for (String gem : gems) {
            set.add(gem);
        }
        total = set.size();

        int start = 0;
        int end = 0;
        int minLength = Integer.MAX_VALUE;
        int[] answer = {0, gems.length - 1};

        while (end < gems.length) {
            countMap.put(gems[end], countMap.getOrDefault(gems[end], 0) + 1);
            end++;

            while (countMap.size() == total) {
                if (end - start < minLength) {
                    minLength = end - start;
                    answer[0] = start + 1;
                    answer[1] = end;
                }

                countMap.put(gems[start], countMap.get(gems[start]) - 1);
                if (countMap.get(gems[start]) == 0) {
                    countMap.remove(gems[start]);
                }
                start++;
            }
        }

        return answer;
    }
}
