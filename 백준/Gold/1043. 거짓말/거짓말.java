import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int[] person;
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a == b) return;
		person[b] = a;
	}
	
	static int find(int num) {
		if (person[num] == num) return num;
		return person[num] = find(person[num]);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer token = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(token.nextToken()); // 사람의 수
		int m = Integer.parseInt(token.nextToken()); // 파티의 수
		
		person = new int[n+1];
		for (int i = 0; i < n+1; i++) {
			person[i] = i;
		}
		
		
		token = new StringTokenizer(br.readLine());
		// 이야기의 진실을 아는 사람의 수와 번호
		int[] truth = new int[Integer.parseInt(token.nextToken())];
		if (token.hasMoreTokens()) truth[0] = Integer.parseInt(token.nextToken());
		int idx = 1;
		while (token.hasMoreTokens()) {
			truth[idx] = Integer.parseInt(token.nextToken());
			union(truth[idx-1], truth[idx++]);
		}
		
		ArrayList[] parties = new ArrayList[m];
		for (int i = 0; i < m; i++) {
			parties[i] = new ArrayList<Integer>();
			token = new StringTokenizer(br.readLine());
			int cnt = 0;
			cnt = Integer.parseInt(token.nextToken());
			if (cnt == 0) continue;
			int past = Integer.parseInt(token.nextToken());
			parties[i].add(past);
			while (token.hasMoreTokens()) {
				int cur = Integer.parseInt(token.nextToken());
				parties[i].add(cur);
				union(past, cur);
				past = cur;
			}
		}
		
		int cnt = m;
		int std = truth.length == 0 ? 0 : truth[0];
		for (int i = 0; i < parties.length; i++) {
			//parties[i]에 들어있는 요소들 돌면서 걸리는 사람 있으면 합집합 처리
			for (int j = 0; j < parties[i].size(); j++) {
				if (find(std) == find((int)(parties[i].get(j)))) {
					cnt--;
					break;
				}
			}
		}
		
		System.out.println(cnt);
	}
}