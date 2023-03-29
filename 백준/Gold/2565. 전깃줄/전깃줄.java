import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine()); // 전깃줄의 개수
		int[][] lines = new int[n][2];
		
		int max = 0;
		for (int i = 0; i < n; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			lines[i][0] = Integer.parseInt(token.nextToken());
			lines[i][1] = Integer.parseInt(token.nextToken());
			max = Math.max(max, Math.max(lines[i][0], lines[i][1]));
		}
		
		int[][] dp = new int[max+1][max+1];
		Arrays.sort(lines, (e1, e2) -> e1[0] - e2[0]); // 시작지점이 위에 있는것부터 정렬
		int idx = 0;
		for (int i = 1; i < dp.length; i++) {
			int temp = 0;
			if (idx < n && lines[idx][0] <= i) {
				i = lines[idx][0];
				temp = lines[idx++][1]; // temp는 연결 가능한 끝지점
			}
			for (int j = 1; j < dp.length; j++) {
				if (temp != 0 && j >= temp) dp[i][j] = Math.max(dp[i-1][temp-1]+1, Math.max(dp[i][j], dp[i-1][j]));
				else dp[i][j] = dp[i-1][j];
			}
		}
		
		System.out.println(n-dp[max][max]);
//		for (int i = 0; i < lines.length; i++) {
//			System.out.println(Arrays.toString(lines[i]));
//		}
//		for (int i = 0; i < dp.length; i++) {
//			System.out.println(Arrays.toString(dp[i]));
//		}
	}
}