package barkingdog.x1B;

import java.io.*;
import java.util.StringTokenizer;

public class P9372 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int T,N,M;
    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        while(T-->0){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            bw.write(String.valueOf(N-1));
            bw.write("\n");
            while(M-->0)
                br.readLine();
        }
        bw.flush();
        bw.close();
    }
}
