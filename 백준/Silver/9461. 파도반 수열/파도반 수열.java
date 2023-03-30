import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static long[] P;
	
	static long seq(int n) {
		if (P[n] != 0) return P[n];
		return P[n] = seq(n-5) + seq(n-1);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// f(n) = f(n-5) + f(n-1)
		P = new long[101];
		P[1] = 1;
		P[2] = 1;
		P[3] = 1;
		P[4] = 2;
		P[5] = 2;
		
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < tc; i++) {
			sb.append(seq(Integer.parseInt(br.readLine()))).append("\n");
		}
		System.out.println(sb);
	}
}