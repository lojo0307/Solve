import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        Scanner sc = new Scanner(System.in);
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			System.out.print("#" + sc.next() + " ");
            int a = sc.nextInt();
            int b = sc.nextInt();
            int n = 1;
            for (int i = 0; i < b; i++) n *= a;
            System.out.println(n);
		}
	}
}