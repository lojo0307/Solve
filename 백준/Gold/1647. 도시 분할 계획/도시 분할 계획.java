import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] parent;
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		parent[a] = b;
	}
	
	static int find(int a) {
		if (parent[a] == a) return a;
		else return parent[a] = find(parent[a]);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer token = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(token.nextToken());
		m = Integer.parseInt(token.nextToken());
		
		parent = new int[n+1];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}
		
		int[][] edges = new int[m][3]; // 간선 배열, 0,1 : 연결 노드, 2: 가중치
		for (int i = 0; i < edges.length; i++) {
			token = new StringTokenizer(br.readLine());
			edges[i][0] = Integer.parseInt(token.nextToken());
			edges[i][1] = Integer.parseInt(token.nextToken());
			edges[i][2] = Integer.parseInt(token.nextToken());
		}
		
		Arrays.sort(edges, (e1, e2) -> e1[2] - e2[2]); // 가중치 오름차순으로 정렬
		
		int cnt = n;
		int sum = 0;
		int idx = 0;
		while (cnt > 2) {
			if (find(edges[idx][0]) != find(edges[idx][1])) {
				union(edges[idx][0], edges[idx][1]);
				cnt--;
				sum += edges[idx][2];
			}
			idx++;
		}
		
		System.out.println(sum);
	}
}