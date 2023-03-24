import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		boolean[] arr = new boolean[m+1];
		arr[1] = true;
		
		for (int i = 2; i <= m; i++) {
			if (arr[i]) continue;
			else {
				int idx = 1;
				int temp = 0;
				while ((temp = ++idx * i) <= m) {
					arr[temp] = true;
				}
			}
		}
		
		for (int i = n; i <= m; i++) {
			if (!arr[i]) System.out.println(i);
		}
	}
}