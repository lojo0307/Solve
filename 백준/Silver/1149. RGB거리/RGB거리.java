import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] cost = new int[n][3];
		int[][] dp = new int[n][3];
		for (int i = 0; i < cost.length; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				cost[i][j] = Integer.parseInt(token.nextToken());
				if (i == 0) dp[i][j] = cost[i][j];
				else {
					if (j == 0) dp[i][j] = Math.min(dp[i-1][1], dp[i-1][2]) + cost[i][j];
					else if (j == 1) dp[i][j] = Math.min(dp[i-1][0], dp[i-1][2]) + cost[i][j];
					else dp[i][j] = Math.min(dp[i-1][0], dp[i-1][1]) + cost[i][j];
				}
			}
		}
		System.out.println(Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2])));
	}
}