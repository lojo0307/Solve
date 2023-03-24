import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] tree;
	static int m, res;
	
	static void binarySearch(int start, int end) {
		while (start <= end) {
			int mid = start + end;
			mid /= 2;
			
			long sum = check(mid);
			if (sum >= m) {
				res = Math.max(res, mid);
				start = mid+1;
			} else {
				end = mid - 1;
			}
		}
		System.out.println(res);
	}
	
	static long check(int height) {
		long sum = 0;
		for (int i = 0; i < tree.length; i++) {
			int diff = tree[i] - height;
			sum += (diff > 0 ? diff : 0);
		}
		return sum;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(token.nextToken());
		m = Integer.parseInt(token.nextToken());
		
		tree = new int[n];
		int max = 0;
		token = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			tree[i] = Integer.parseInt(token.nextToken());
			max = Math.max(max, tree[i]);
		}
		
		int start = max - m > 0 ? max - m : 0;
		int end = max-1;
		binarySearch(start, end);
		
	}
}