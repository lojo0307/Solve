import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] idx;
    
    static void union(int a, int b) {
        a = find(a);
		b = find(b);
		if (a != b) idx[b] = a;
    }
    
    static int find(int i) {
        if (idx[i] == i) return i;
        return idx[i] = find(idx[i]);
    }
    
    static boolean match(int a, int b) {
        return find(a) == find(b);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer token = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());
        
        idx = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            idx[i] = i;
        }
        
        for (int i = 0; i < m; i++) {
            token = new StringTokenizer(br.readLine());
            int cal = Integer.parseInt(token.nextToken());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            
            if (cal == 0) union(a, b);
            else if (match(a, b)) sb.append("YES\n");
            else sb.append("NO\n");
        }
        System.out.println(sb);
    }
}