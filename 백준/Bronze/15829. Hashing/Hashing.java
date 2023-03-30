import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int l = Integer.parseInt(str);
		str = br.readLine();
		long hash = 0;
		for (int i = 0; i < l; i++) {
			int n = (int)(str.charAt(i)-'a') + 1;
			hash += (Math.pow(31,i) * n);
		}
		System.out.println(hash);
	}
}