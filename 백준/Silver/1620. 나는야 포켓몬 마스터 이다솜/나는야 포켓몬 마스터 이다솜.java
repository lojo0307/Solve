import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer token = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(token.nextToken());
		int m = Integer.parseInt(token.nextToken());
		
		Map<String, Integer> getNumber = new HashMap<>();
		Map<Integer, String> getName = new HashMap<>();
		
		for (int i = 1; i <= n; i++) {
			String tmp = br.readLine();
			getName.put(i, tmp);
			getNumber.put(tmp, i);
		}
		
		for (int i = 0; i < m; i++) {
			String tmp = br.readLine();
			if (tmp.charAt(0) < 58 && tmp.charAt(0) > 48) sb.append(getName.get(Integer.parseInt(tmp))).append("\n");
			else sb.append(getNumber.get(tmp)).append("\n");
		}
		System.out.println(sb);
	}
}