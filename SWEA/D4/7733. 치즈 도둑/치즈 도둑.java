import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= tc; t++) {
			int n = Integer.parseInt(br.readLine());
			
			int[][] cheese = new int[n][n];
			int max = 0, min = Integer.MAX_VALUE;
			for (int r = 0; r < cheese.length; r++) {
				StringTokenizer token = new StringTokenizer(br.readLine());
				for (int c = 0; c < cheese.length; c++) {
					cheese[r][c] = Integer.parseInt(token.nextToken());
					max = Math.max(max, cheese[r][c]);
					min = Math.min(min, cheese[r][c]);
				}
			}
			
			int res = 0;
			int[] dr = {-1, 1, 0, 0};
			int[] dc = {0, 0, -1, 1};
			for (int day = min; day < max; day++) {
				int cnt = 0;
				boolean[][] visited = new boolean[n][n];
				for (int r = 0; r < visited.length; r++) {
					for (int c = 0; c < visited.length; c++) {
						if (cheese[r][c] <= day) visited[r][c] = true;
						if (visited[r][c]) continue;
						Queue<int[]> q = new LinkedList<>();
						q.offer(new int[] {r, c});
						visited[r][c] = true;
						while (!q.isEmpty()) {
							int[] cur = q.poll();
							int curr = cur[0], curc = cur[1];
							for (int i = 0; i < 4; i++) {
								int nr = curr + dr[i], nc = curc + dc[i];
								if (nr < 0 || nc < 0 || nr >= n || nc >= n) continue;
								if (cheese[nr][nc] <= day) visited[nr][nc] = true;
								if (visited[nr][nc]) continue;
								visited[nr][nc] = true;
								q.offer(new int[] {nr, nc});
							}
						}
						cnt++;
					}
				}
				res = Math.max(res, cnt);
			}
            res = res == 0 ? 1 : res;
			sb.append("#").append(t).append(" ").append(res).append("\n");
		}
		System.out.println(sb);
	}
}