import java.util.Scanner;

public class Main {
	
	static Integer[] dp; // 메모이제이션 할 배열
	 
	static int recur(int N) {
		if (N == 1) return 0;
		if (dp[N] == null) {
			// 6으로 나눠지는 경우 
			if (N % 6 == 0) {
				dp[N] = Math.min(recur(N - 1), Math.min(recur(N / 3), recur(N / 2))) + 1;
			}
			// 3으로만 나눠지는 경우 
			else if (N % 3 == 0) {
				dp[N] = Math.min(recur(N / 3), recur(N - 1)) + 1;
			}
			// 2로만 나눠지는 경우 
			else if (N % 2 == 0) {
				dp[N] = Math.min(recur(N / 2), recur(N - 1)) + 1;
			}
			// 2와 3으로 나누어지지 않는 경우
			else {
				dp[N] = recur(N - 1) + 1;
			}
		}
		return dp[N];
	}
//	static int[] res;
//	
//	static int cal(int a) {
//		if (res[a] != 0) return res[a];
//		if (a == 1) return 0;
//		//a-1
//		int temp = cal(a-1);
//		//a/2
//		if (a%2 == 0) {
//			temp = Math.min(temp, cal(a/2));
//		}
//		//a/3
//		if (a%3 == 0) {
//			temp = Math.min(temp, cal(a/3));
//		}
//		return res[a] = temp + 1;
//	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		dp = new Integer[n+1];
		System.out.println(recur(n));
	}
}