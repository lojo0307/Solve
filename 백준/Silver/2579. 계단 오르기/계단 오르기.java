import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] step = new int[n];
		for (int i = 0; i < step.length; i++) {
			step[i] = Integer.parseInt(br.readLine());
		}

		int[][] dp = new int[n][2]; // 0은 한칸 오름, 1은 두칸 오름
		
		dp[0][0] = step[0];
		if (n != 1) dp[1][0] = step[0] + step[1];
		if (n != 1) dp[1][1] = step[1];
		
		for (int i = 2; i < n; i++) {
			dp[i][0] = dp[i-1][1] + step[i];
			dp[i][1] = Math.max(dp[i-2][0], dp[i-2][1]) + step[i];
		}
		
		System.out.println(Math.max(dp[n-1][0], dp[n-1][1]));
	}
}