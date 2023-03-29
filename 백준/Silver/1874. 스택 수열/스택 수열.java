import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int n = sc.nextInt();
		
		int idx = 1;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			int temp = sc.nextInt();
			while (idx <= n && temp >= idx) {
				stack.push(idx++);
				sb.append("+\n");
			}
			if (stack.pop() != temp) {
				sb.delete(0, sb.length());
				sb.append("NO");
				break;
			}
			sb.append("-\n");
		}
		System.out.println(sb);
	}
}