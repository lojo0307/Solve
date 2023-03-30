import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(token.nextToken());
		int m = Integer.parseInt(token.nextToken());
		
		Set<String> NoHear = new HashSet<>();
		for (int i = 0; i < n; i++) {
			NoHear.add(br.readLine());
		}
		
		ArrayList<String> arr = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			String tmp = br.readLine();
			if (NoHear.contains(tmp)) arr.add(tmp);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(arr.size());
		Collections.sort(arr);
		for (String str : arr) {
			sb.append("\n").append(str);
		}
		
		System.out.println(sb);
	}
}