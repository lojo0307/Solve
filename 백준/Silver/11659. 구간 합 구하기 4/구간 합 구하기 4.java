import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer token = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(token.nextToken());
		int m = Integer.parseInt(token.nextToken());
		
		token = new StringTokenizer(br.readLine());
		int[] sum = new int[n+1];
		
		for (int i = 1; i <= n; i++) {
			sum[i] = sum[i-1] + Integer.parseInt(token.nextToken());
		}
		
		for (int i = 0; i < m; i++) {
			token = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(token.nextToken());
			sb.append(sum[Integer.parseInt(token.nextToken())]-sum[a-1]).append("\n");
		}
		System.out.println(sb);
	}
}