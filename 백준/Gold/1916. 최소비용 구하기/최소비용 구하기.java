import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine()); // 도시의 개수
		int m = Integer.parseInt(br.readLine()); // 버스의 개수
		
//		Node[] start = new Node[n+1];
		ArrayList<ArrayList<Node>> start = new ArrayList<>();
		for (int i = 0; i < n+1; i++) {
			start.add(new ArrayList<Node>());
		}
		for (int i = 0; i < m; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			start.get(Integer.parseInt(token.nextToken())).add(new Node(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()))); // 출발, 도착, 거리
		}
		
		StringTokenizer token = new StringTokenizer(br.readLine());
		int from = Integer.parseInt(token.nextToken());
		int to = Integer.parseInt(token.nextToken());
		
		
		PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.dist - n2.dist);
		pq.offer(new Node(from, 0));
		int[] dist = new int[n+1];
		boolean[] visited = new boolean[n+1];
		for (int i = 1; i < dist.length; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[from] = 0;
		while (!pq.isEmpty()) {
			Node current = pq.poll();
			int cur = current.end;
			int distance = current.dist;
			visited[cur] = true;
			if (cur == to) break;
			for (int i = 0; i < start.get(cur).size(); i++) {
				int next = start.get(cur).get(i).end;
				if (visited[next]) continue;
				int ndis = distance + start.get(cur).get(i).dist;
				if (ndis < dist[next]) {
					dist[next] = ndis;
					pq.offer(new Node(next, ndis));
				}
			}
		}
		
		System.out.println(dist[to]);
	}
}

class Node {
	int end;
	int dist;
	public Node(int end, int dist) {
		this.end = end;
		this.dist = dist;
	}
}