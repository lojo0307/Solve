import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) {
        int[][] routes1 = {{-20, 15}, {-14, -5}, {-18, -13}, {-5, -3}};
        System.out.println(solution(routes1)); // 2
        
        int[][] routes2 = {{-2, -1}, {1, 2}, {-3, 0}};
        System.out.println(solution(routes2)); // 2
    }

    public static int solution(int[][] routes) {
        // 진입 지점을 기준으로 정렬
        Arrays.sort(routes, Comparator.comparingInt(o -> o[0]));

        int answer = 0;
        int cameraPosition = Integer.MIN_VALUE;

        for (int[] route : routes) {
            int start = route[0];
            int end = route[1];

            // 현재 카메라의 위치보다 더 뒤에 있는 차량이 포함된 경우
            if (start > cameraPosition) {
                answer++;
                cameraPosition = end; // 카메라 위치 업데이트
            } else {
                cameraPosition = Math.min(cameraPosition, end);
            }
        }

        return answer;
    }
}
