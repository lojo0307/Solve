import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for (int t = 1; t <= tc; t++) {
            String str = sc.next();
            int ans = str.length();
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) - 'a' != i) {
                    ans = i;
                    break;
                }
            }
            System.out.println("#" + t + " " + ans);
        }
	}
}