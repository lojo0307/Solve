import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int idx = 1;
		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0) break;
			int[][] map = new int[n][n];
			int[][] dist = new int[n][n];
			
			for (int r = 0; r < map.length; r++) {
				StringTokenizer token = new StringTokenizer(br.readLine());
				for (int c = 0; c < map.length; c++) {
					map[r][c] = Integer.parseInt(token.nextToken());
					dist[r][c] = Integer.MAX_VALUE;
				}
			}
		
			PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> e1[2]-e2[2]);
			pq.offer(new int[] {0, 0, map[0][0]});
			
			boolean[][] visited = new boolean[n][n];
			visited[0][0] = true;
			dist[0][0] = map[0][0];
			
			int[] dr = {-1, 1, 0, 0};
			int[] dc = {0, 0, -1, 1};
			
			while (!pq.isEmpty()) {
				int[] cur = pq.poll();
				int r = cur[0], c = cur[1], dis = cur[2];
				if (r == n-1 && c == n-1) break;
				visited[r][c] = true;
				for (int i = 0; i < 4; i++) {
					int nr = r + dr[i], nc = c + dc[i];
					if (nr < 0 || nc < 0 || nr >= n || nc >= n || visited[nr][nc]) continue;
					if (dist[nr][nc] < dis + map[nr][nc]) continue;
					dist[nr][nc] = dis + map[nr][nc];
					pq.offer(new int[] {nr, nc, dist[nr][nc]});
				}
			}
			
			System.out.println("Problem " + idx + ": " + dist[n-1][n-1]);
			idx++;
		}
	}
}