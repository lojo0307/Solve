import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int[] A, tmp;
    public static long result;
    public static void main(String[] args) throws Exception, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            A[i]=Integer.parseInt(st.nextToken());
        }
        tmp = new int[N];
        result = 0;
        
        merged_sort(0, N-1);
        System.out.println(result);
    }
    private static void merged_sort(int s, int e) {
        if (e-s<1) {
            return;
        }
        int m = s+(e-s)/2;
        merged_sort(s, m);
        merged_sort(m+1, e);
        merge(s, m ,e);
        
    }
    private static void merge(int s, int m, int e) {
        for (int i=s; i<=e; i++) {
            tmp[i]=A[i];
        }
        int i=s;
        int k=s;
        int j=m+1;
        
        while (i<=m && j<=e) {
            if (tmp[i]>tmp[j]) {
                A[k]=tmp[j];
                result+= j-k;
                k++; j++;
            } else {
                A[k]=tmp[i];
                k++; i++;
            }
        }
        while (i<=m) {
            A[k++]=tmp[i++];
        }
        while (j<=e) {
            A[k++]=tmp[j++];
        }
    }
}