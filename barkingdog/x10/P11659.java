package barkingdog.x10;

import java.io.*;
import java.util.StringTokenizer;

public class P11659 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N,M,i,j;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[N+1];
        for(int i=1; i<N+1; ++i) arr[i] = arr[i-1]+Integer.parseInt(st.nextToken());
        while(M-->0){
            st = new StringTokenizer(br.readLine());
            i = Integer.parseInt(st.nextToken());
            j = Integer.parseInt(st.nextToken());
            bw.write(String.valueOf(arr[j]-arr[i-1]));
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
