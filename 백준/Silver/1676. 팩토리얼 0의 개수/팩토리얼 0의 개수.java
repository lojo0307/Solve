import java.util.Scanner;

public class Main {
	static int five;
	
	static void factorial(int n) {
		if (n == 0) return;
		if (n % 125 == 0) five += 3;
		else if (n%25 == 0) five += 2;
		else if (n%5 == 0) five += 1;
		factorial(n-1);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		factorial(sc.nextInt());
		
		System.out.println(five);
	}
}