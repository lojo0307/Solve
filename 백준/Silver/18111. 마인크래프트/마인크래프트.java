import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(token.nextToken()); // 세로
		int m = Integer.parseInt(token.nextToken()); // 가로
		int b = Integer.parseInt(token.nextToken()); // 인벤토리
		
		int[][] map = new int[n][m];
		int min = 256;
		int max = 0;
		for (int i = 0; i < map.length; i++) {
			token = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(token.nextToken());
				max = Math.max(max, map[i][j]);
				min = Math.min(min, map[i][j]);
			}
		}
		
		// 높이별로 몇개를 깎고 몇개를 채워야하는지 구한다
		int minTime = Integer.MAX_VALUE;
		int res = 0;
		// 가장 높은 높이를 출력하므로 위에서부터 내림차순으로 계산
		for (int height = max; height >= min; height--) {
			// 현재 높이를 만들 수 있는가?
			int fill = 0;
			int cut = 0;
			for (int r = 0; r < map.length; r++) {
				for (int c = 0; c < m; c++) {
					if (map[r][c] > height) cut += (map[r][c] - height);
					else if (map[r][c] < height) fill += (height - map[r][c]);
				}
			}
			if (fill > cut + b) continue; // 만들 수 없는 높이이면 넘긴다
			int temp = fill + cut * 2;
			if (temp < minTime) {
				minTime = temp;
				res = height;
			}
		}
		
		System.out.println(minTime + " " + res);
	}
}