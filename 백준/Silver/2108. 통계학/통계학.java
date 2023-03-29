import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int sum = 0;
		int maxCnt = 0;
		int freq = 0;
		int[] arr = new int[n];
		int[] cnt = new int[8001];
		boolean flag = false;
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
			if (++cnt[arr[i]+4000] > maxCnt) {
				maxCnt = cnt[arr[i]+4000];
			}
		}
		
		for (int i = 0; i < cnt.length; i++) {
			if (cnt[i] == maxCnt && flag == false) {
				flag = true;
				freq = i-4000;
			}
			else if (cnt[i] == maxCnt && flag == true) {
				freq = i - 4000;
				break;
			}
		}

		System.out.println(Math.round((double)sum/n));
		Arrays.sort(arr);
		System.out.println(arr[n/2]);
		System.out.println(freq);
		System.out.println(arr[n-1]-arr[0]);
	}
}