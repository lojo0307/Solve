import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer token = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(token.nextToken());
		int m = Integer.parseInt(token.nextToken());
		
		int[] idx = new int[n+1];
		ArrayList<Integer>[] arr = new ArrayList[n+1];
		for (int i = 1; i < arr.length; i++) {
			arr[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			token = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(token.nextToken());
			int next = Integer.parseInt(token.nextToken());
			idx[next]++;
			arr[first].add(next);
		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		int[] semister = new int[n+1];
		int time = 1;
		
		while(true) {
			for (int i = 1; i < arr.length; i++) {
				if (idx[i] == 0) {
					q.offer(i);
					idx[i]--;
				}
			}
			
			
			if (q.isEmpty()) break;
			
			while(!q.isEmpty()) {
				int cur = q.poll();
				semister[cur] = time;
				for (int i = 0; i < arr[cur].size(); i++) {
					idx[arr[cur].get(i)]--;
				}
			}
			
			time++;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < semister.length; i++) {
			sb.append(semister[i]).append(" ");
		}
		
		System.out.println(sb);
	}
}