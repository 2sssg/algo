package barkingdog.x1C;

import Constant.Source;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11562 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N,M,v1,v2,k,b;
    static int[][] d;

    static int rn() throws IOException {return Integer.parseInt(br.readLine());}
    static void est() throws IOException {st = new StringTokenizer(br.readLine());}
    static int rstn() throws IOException{return Integer.parseInt(st.nextToken());}

    public static void main(String[] args) throws IOException {
        br = Source.getBufferedReader();
        est(); N = rstn(); M = rstn();

        d = new int[N][N];

        for(int i=0; i<N; ++i){
            Arrays.fill(d[i],0x3f3f3f3f);
            d[i][i] = 0;
        }

        for(int i=0; i<M; ++i){
            est(); v1 = rstn()-1; v2 = rstn()-1; b = rstn();
            d[v1][v2] = 0;
            d[v2][v1] = (b+1)&1;
        }


        for(int i=0; i<N; ++i)
            for(int j=0; j<N; ++j)
                for(int k=0; k<N; ++k)
                    d[j][k] = Math.min(d[j][k],d[j][i] + d[i][k]);

        k = rn();
        while(k-->0){
            est();
            bw.write(String.valueOf(d[rstn()-1][rstn()-1]));
            bw.write("\n");
        }
        bw.flush();
//        bw.close();
    }
}
