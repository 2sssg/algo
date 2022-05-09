package barkingdog.x0F;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P5648 {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb;
    static int N;
    static long[] arr;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new long[N];
        int cur=0;
        while(true){
            while(st.hasMoreTokens()){
                sb = new StringBuilder(st.nextToken());
                sb.reverse();
                arr[cur++] = Long.parseLong(sb.toString());
            }
            if(cur == N) break;
            st = new StringTokenizer(br.readLine());
        }
        Arrays.sort(arr);
        for(long l : arr){
            bw.write(String.valueOf(l));
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
