package barkingdog.x1D;

import Constant.Source;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1238 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int v;
    static int e;
    static int x;
    static int[][] d;

    public static void main(String[] args) throws IOException {
        br = Source.getBufferedReader();
        st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        d = new int[v][v];

        for(int i=0; i<v; ++i){
            Arrays.fill(d[i],0x3f3f3f3f);
            d[i][i] = 0;
        }

        while(e-->0){
            st = new StringTokenizer(br.readLine());
            d[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<v; ++i)
            for(int j=0; j<v; ++j)
                for(int k=0; k<v; ++k)
                    d[j][k] = Math.min(d[j][k], d[j][i]+d[i][k]);

        int ans = 0;

        for(int i=0; i<v; ++i)
            ans = Math.max(ans,d[i][x-1]+d[x-1][i]);

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }
}
