import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dp;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer token = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(token.nextToken());
		int K = Integer.parseInt(token.nextToken());
		
		int[] W = new int[N+1];
		int[] V = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			token = new StringTokenizer(br.readLine());
			W[i] = Integer.parseInt(token.nextToken());
			V[i] = Integer.parseInt(token.nextToken());
		}
		
		int[][] dp = new int[N+1][K+1];
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				dp[i][j] = dp[i-1][j];
				if (j - W[i] >= 0) {
					dp[i][j] = Math.max(dp[i][j], V[i] + dp[i-1][j-W[i]]);
				}
			}
		}
		
		System.out.println(dp[N][K]);
	}
}