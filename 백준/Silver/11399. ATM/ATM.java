import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] time = new int[n];
		StringTokenizer token = new StringTokenizer(br.readLine());
		for (int i = 0; i < time.length; i++) {
			time[i] = Integer.parseInt(token.nextToken());
		}
		Arrays.sort(time);
		int idx = n;
		int sum = 0;
		for (int i = 0; i < time.length; i++) {
			sum += time[i] * idx--;
		}
		
		System.out.println(sum);
	}
}