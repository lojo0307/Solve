import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int n, l, max;
	static int[][] ingredient;
	
	static void makeBurger(int idx, int taste, int cal) {
		if (idx == n) {
			if (cal > l) return;
			if (taste > max) max = taste;
			return;
		}
		if (cal+ingredient[idx][1] < l) makeBurger(idx+1, taste+ingredient[idx][0], cal+ingredient[idx][1]);
		makeBurger(idx+1, taste, cal);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			n = Integer.parseInt(token.nextToken()); // 재료의 수
			l = Integer.parseInt(token.nextToken()); // 제한 칼로리
			
			ingredient = new int[n][2];
			for (int i = 0; i < ingredient.length; i++) {
				token = new StringTokenizer(br.readLine());
				ingredient[i][0] = Integer.parseInt(token.nextToken()); // 맛
				ingredient[i][1] = Integer.parseInt(token.nextToken()); // 칼로리
			}
			
			max = 0;
			
			makeBurger(0, 0, 0);
			
			System.out.println("#" + t + " " + max);
		}
	}
}