import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int[] tree;
	static ArrayList<Integer>[] child;
	static int max, n, k, appleCnt, root;
	
	static void comb(int start, int cnt) {
		if (cnt == appleCnt || cnt == k) {
			if (tree[root] == 1) return;
			max = Math.max(max, dfs(root));
			return;
		}
		for (int i = start; i < n; i++) {
			if (tree[i] != 1) continue;
			tree[i] = 0;
			comb(i+1, cnt+1);
			tree[i] = 1;
		}
	}
	
	static int dfs(int node) {
		int tmp = tree[node] == 2 ? 1 : 0;
		for (int i = 0; i < child[node].size(); i++) {
			int next = child[node].get(i);
			if (tree[next] == 1) continue;
			tmp += dfs(next);
		}
		return tmp;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer token = new StringTokenizer(br.readLine());
		n = Integer.parseInt(token.nextToken());
		k = Integer.parseInt(token.nextToken());
		max = 0;
		appleCnt = 0;
		
		Set<Integer> s = new HashSet<>();
		
		child = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			child[i] = new ArrayList<>();
			s.add(i);
		}
		
		for (int i = 0; i < n-1; i++) {
			token = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(token.nextToken());
			int c = Integer.parseInt(token.nextToken());
			child[p].add(c);
			if (s.contains(c)) s.remove(c);
		}
		
		for (Integer integer : s) {
			root = integer;
		}
		
		tree = new int[n];
		token = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			tree[i] = Integer.parseInt(token.nextToken());
			if (tree[i] == 1) appleCnt++;
		}
		
		comb(0, 0);
		
		System.out.println(max);
		
	}
}