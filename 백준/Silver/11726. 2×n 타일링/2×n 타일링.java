import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		BigInteger[] dp = new BigInteger[n+2];
		dp[1] = BigInteger.ONE;
		dp[2] = BigInteger.ONE.add(dp[1]);
		
		for (int i = 3; i < dp.length; i++) {
			dp[i] = dp[i-1].add(dp[i-2]);
		}
		
		System.out.println(dp[n].mod(new BigInteger("10007")));
	}
}