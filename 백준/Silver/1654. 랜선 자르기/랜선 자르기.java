import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, k;
	static long max;
	static long[] lines;
	
	static void binarySearch(long num) {
		long start = 1;
		long end = num;
		while (start <= end) {
			long mid = ((start + end) / 2);
			if (check(mid) < n) end = mid - 1;
			else {
				start = mid + 1;
				max = Math.max(max, mid);
			}
		}
	}
	
	static int check(long length) {
		int sum = 0;
		for (int i = 0; i < lines.length; i++) {
			sum += lines[i] / length;
		}
		return sum;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer token = new StringTokenizer(br.readLine());
		k = Integer.parseInt(token.nextToken()); // 이미 가지고 있는 랜선의 개수
		n = Integer.parseInt(token.nextToken()); // 필요한 랜선의 개수
		
		lines = new long[k];
		long temp = 0;
		for (int i = 0; i < k; i++) {
			lines[i] = Integer.parseInt(br.readLine());
			temp = Math.max(temp, lines[i]);
		}
		
		binarySearch(temp);
		
		System.out.println(max);
	}
}