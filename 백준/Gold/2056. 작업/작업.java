import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] first, next;
	static int[] precede, time;
	static int res;
	
	static void check(int i) {
//		System.out.printf("%d를 체크\n",i);
		int max = 0;
		for (int j = 0; j < first[i].size(); j++) {
			max = Math.max(max, time[first[i].get(j)]);
		} 
		time[i] += max;
		res = Math.max(res, time[i]);
		for (int j = 0; j < next[i].size(); j++) {
			if (--precede[next[i].get(j)] == 0) check(next[i].get(j));
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		first = new ArrayList[n+1];
		next = new ArrayList[n+1];
		for (int i = 1; i < first.length; i++) {
			first[i] = new ArrayList<>();
			next[i] = new ArrayList<>();
		}
		
		precede = new int[n+1];
		time = new int[n+1];
		Queue<Integer> q = new LinkedList<Integer>();
		
		StringTokenizer token;
		for (int i = 1; i <= n; i++) {
			token = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(token.nextToken());
			precede[i] = Integer.parseInt(token.nextToken());
			if (precede[i] == 0) q.offer(i);
			for (int j = 0; j < precede[i]; j++) {
				int sun = Integer.parseInt(token.nextToken());
				first[i].add(sun);
				next[sun].add(i);
			}
		}
		while (!q.isEmpty()) {
			int cur = q.poll();
			check(cur);
		}
		
		System.out.println(res);
	}
}