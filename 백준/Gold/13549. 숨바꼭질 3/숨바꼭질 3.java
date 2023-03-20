import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer token = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(token.nextToken());
		int k = Integer.parseInt(token.nextToken());
		
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visited = new boolean[100001];
		int[] dist = new int[100001];
		q.offer(n);
		while (!q.isEmpty()) {
			int cur = q.poll();
			if (cur == k) break;
			if (cur-1 >= 0) {
				if (visited[cur-1] && dist[cur]+1 < dist[cur-1] || !visited[cur-1]) {
					dist[cur-1] = dist[cur]+1;
					visited[cur-1] = true;
					q.offer(cur-1);
				}
			}
			if (cur+1 <= 100000) {
				if (visited[cur+1] && dist[cur]+1 < dist[cur+1] || !visited[cur+1]) {
					dist[cur+1] = dist[cur]+1;
					visited[cur+1] = true;
					q.offer(cur+1);
				}
			}
			if (cur*2 <= 100000) {
				if (visited[cur*2] && dist[cur] < dist[cur*2] || !visited[cur*2]) {
					dist[cur*2] = dist[cur];
					visited[cur*2] = true;
					q.offer(cur*2);
				}
				
			}
		}
		System.out.println(dist[k]);
	}
}