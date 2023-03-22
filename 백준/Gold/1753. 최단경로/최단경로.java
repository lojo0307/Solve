import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer token = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(token.nextToken()); // 정점의 개수
		int e = Integer.parseInt(token.nextToken()); // 간선의 개수
		int k = Integer.parseInt(br.readLine()); // 시작 정점의 번호

		int[] dist = new int[v+1];
		ArrayList<ArrayList<Nodes>> arr = new ArrayList<>();
		for (int i = 0; i < v+1; i++) {
			arr.add(new ArrayList<>());
			dist[i] = Integer.MAX_VALUE;
		}
		
		for (int i = 0; i < e; i++) {
			token = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(token.nextToken());
			int to = Integer.parseInt(token.nextToken());
			int distt = Integer.parseInt(token.nextToken());
			arr.get(from).add(new Nodes(to, distt));
		}
		
		PriorityQueue<Nodes> pq = new PriorityQueue<>((e1, e2) -> e1.dist-e2.dist);
		boolean[] visited = new boolean[v+1];
		pq.offer(new Nodes(k, 0));
		visited[k] = true;
		dist[k] = 0;
		while (!pq.isEmpty()) {
			Nodes node = pq.poll();
			int cur = node.to;
			int dis = node.dist;
			if (cur != k && visited[cur]) continue;
			visited[cur] = true;
			for (int i = 0; i < arr.get(cur).size(); i++) {
				Nodes hi = arr.get(cur).get(i);
				int next = hi.to;
				int nextdis = hi.dist;
				if (visited[next] || dis + nextdis > dist[next]) continue;
				dist[next] = dis + nextdis;
				pq.offer(new Nodes(next, dist[next]));
			}
		}
		
		for (int i = 1; i < dist.length; i++) {
			if (dist[i] != Integer.MAX_VALUE) System.out.println(dist[i]);
			else System.out.println("INF");
		}
	}
}

class Nodes{
	int to;
	int dist;
	public Nodes(int to, int dist) {
		this.to = to;
		this.dist = dist;
	}
}