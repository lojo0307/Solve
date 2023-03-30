import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int cnt;
	
	static void cal(int n) {
		if (n < 0) return;
		if (n == 0) {
			cnt++;
			return;
		}
		cal (n-1);
		cal(n-2);
		cal(n-3);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] dp = new int[11];
		dp[1] = 1;
		dp[2] = 2;
		
		for (int i = 3; i < dp.length; i++) {
			dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
		}
		
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int t = 0; t < tc; t++) {
			cnt = 0;
			cal(Integer.parseInt(br.readLine()));
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
}