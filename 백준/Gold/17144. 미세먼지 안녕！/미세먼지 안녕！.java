import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer token = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(token.nextToken());
		int C = Integer.parseInt(token.nextToken());
		int T = Integer.parseInt(token.nextToken());
		
		int pos = 0;
		int sum = 0;
		
		int[][] map = new int[R][C];
		for (int r = 0; r < map.length; r++) {
			token = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(token.nextToken());
				if (map[r][c] == -1) {
					pos = r;
					continue;
				}
				sum += map[r][c];
			}
		}
		
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		while (T-- != 0) {
			// 미세먼지 확산
			int[][] temp = new int[R][C];
			for (int i = 0; i < temp.length; i++) {
				temp[i] = map[i].clone();
			}
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if (map[r][c] < 5) continue;
					int diff = map[r][c] / 5;
					for (int i = 0; i < 4; i++) {
						int nr = r + dr[i], nc = c + dc[i];
						if (nr < 0 || nc < 0 || nr >= R || nc >= C || map[nr][nc] < 0) continue;
						temp[nr][nc] += diff;
						temp[r][c] -= diff;
					}
				}
			}
			for (int i = 0; i < temp.length; i++) {
				map[i] = temp[i].clone();
			}
			
			// 공기청정기 작동
			// 위쪽
			sum -= map[pos-2][0];
			for (int i = pos-3; i >= 0; i--) {
				map[i+1][0] = map[i][0];
			}
			for (int i = 0; i < C-1; i++) {
				map[0][i] = map[0][i+1];
			}
			int upperLimit = pos-1;
			for (int i = 0; i < upperLimit; i++) {
				map[i][C-1] = map[i+1][C-1];
			}
			for (int i = C-1; i > 1; i--) {
				map[upperLimit][i] = map[upperLimit][i-1];
			}
			map[upperLimit][1] = 0;
			// 아래쪽
			sum -= map[pos+1][0];
			for (int i = pos+1; i < R-1; i++) {
				map[i][0] = map[i+1][0];
			}
			for (int i = 0; i < C-1; i++) {
				map[R-1][i] = map[R-1][i+1];
			}
			for (int i = R-1; i > pos; i--) {
				map[i][C-1] = map[i-1][C-1];
			}
			for (int i = C-1; i > 1; i--) {
				map[pos][i] = map[pos][i-1];
			}
			map[pos][1] = 0;
		}
		System.out.println(sum);
	}
}