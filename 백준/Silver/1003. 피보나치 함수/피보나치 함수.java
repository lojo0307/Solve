import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] dp0, dp1;
	static int fibonacci0(int n) {
		if (n == 1) return 0;
		if (dp0[n] != 0) return dp0[n];
		return dp0[n] = fibonacci0(n-1) + fibonacci0(n-2);
	}
	
	static int fibonacci1(int n) {
		if (n == 0) return 0;
		if (dp1[n] != 0) return dp1[n];
		return dp1[n] = fibonacci1(n-1) + fibonacci1(n-2);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		dp0 = new int[41];
		dp1 = new int[41];
		
		dp0[0] = 1;
		dp1[1] = 1;
		
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < tc; i++) {
			int tmp = Integer.parseInt(br.readLine());
			sb.append(fibonacci0(tmp)).append(" ").append(fibonacci1(tmp)).append("\n");
		}
		
		System.out.println(sb);
	}
}