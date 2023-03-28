import java.util.Scanner;

public class Main {
	static Integer[] res;
	
	static int cal(int a) {
		if (a == 1) return 0;
		if (res[a] == null) {
	//		res[a] = cal(a-1);
			if (a%6 == 0) res[a] = Math.min(cal(a-1), Math.min(cal(a/2), cal(a/3)))+1;
			else if (a%3 == 0) res[a] = Math.min(cal(a/3), cal(a-1))+1;
			//a/3
			else if (a%2 == 0) res[a] = Math.min(cal(a/2), cal(a-1))+1;
			else res[a] = cal(a-1)+1;
		}
		return res[a];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		res = new Integer[n+1];
		System.out.println(cal(n));
	}
}