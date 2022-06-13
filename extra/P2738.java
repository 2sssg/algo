package extra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2738 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N,M;
    static int[][] arr1, arr2;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr1 = new int[N][M];
        arr2 = new int[N][M];
        for(int i=0; i<N; ++i) arr1[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for(int i=0; i<N; ++i) arr2[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for(int i=0; i<N; ++i) for(int j=0; j<M; ++j) arr1[i][j] += arr2[i][j];
        for(int i=0; i<N; ++i) System.out.println(Arrays.toString(arr1[i]).replaceAll("[\\[\\],]",""));
    }
}
