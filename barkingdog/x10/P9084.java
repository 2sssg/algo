package barkingdog.x10;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P9084 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int T,N,M;
    static int[] a = new int[50];
    static int[] d = new int[100005];
    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        while(T-->0){
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            Arrays.fill(d,0);
            d[0] = 1;
            for(int i=0; i<N; ++i){
                a[i] = Integer.parseInt(st.nextToken());
            }
            M = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++)
                for (int j = a[i]; j <= M; j++)
                    d[j] += d[j - a[i]];

            bw.write(String.valueOf(d[M]));
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
