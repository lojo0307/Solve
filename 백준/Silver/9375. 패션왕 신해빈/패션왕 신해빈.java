import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < tc; t++) {
			int n = Integer.parseInt(br.readLine());
			
			Set<String> type = new HashSet<>();
			Map<String, Integer> getIndex = new HashMap<String, Integer>();
			int[] cnt = new int[30];
			
			int idx = 0;
			for (int i = 0; i < n; i++) {
				StringTokenizer token = new StringTokenizer(br.readLine());
				
				String name = token.nextToken();
				String tp = token.nextToken();
				
				int cur = -1;
				if (!type.contains(tp)) {
					getIndex.put(tp, idx);
					cur = idx++;
					type.add(tp);
				} else cur = getIndex.get(tp);
				
				cnt[cur]++;
			}
			int res = 1;
			for (int i = 0; i < idx; i++) {
				res *= (cnt[i]+1);
			}
			
			sb.append(res-1).append("\n");
		}
		System.out.println(sb);		
	}
}