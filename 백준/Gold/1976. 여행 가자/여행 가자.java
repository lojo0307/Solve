import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] linked;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine()); // 도시의 수
		int m = Integer.parseInt(br.readLine()); // 여행을 계획중인 도시들의 수
		
		linked = new int[n+1];
		
		for (int i = 0; i < n+1; i++) {
			linked[i] = i;
		}
		
		for (int r = 1; r < linked.length; r++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			for (int c = 1; c < linked.length; c++) {
				if (token.nextToken().equals("0")) continue;
				union(r, c);
			}
		}
		
		StringTokenizer token = new StringTokenizer(br.readLine());
		int past = Integer.parseInt(token.nextToken());
		boolean res = true;
		while (token.hasMoreTokens()) {
			int cur = Integer.parseInt(token.nextToken());
			if (find(past) != find(cur)) {
				res = false;
				break;
			}
			past = cur;
		}
		
		if (res) System.out.println("YES");
		else System.out.println("NO");
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a != b) linked[b] = a;
	}
	
	static int find(int num) {
		if (linked[num] == num) return num;
		return linked[num] = find(linked[num]);
	}
}