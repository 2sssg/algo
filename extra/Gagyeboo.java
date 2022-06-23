package extra;

import Constant.Source;

import java.awt.desktop.OpenURIEvent;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Gagyeboo {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N,M,type,p,q;
    static long x;
    static long[] arr;
    public static void main(String[] args) throws IOException {
        br = Source.getBufferedReader();
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new long[N+1];
        while(M-->0){
            st = new StringTokenizer(br.readLine());
            type = Integer.parseInt(st.nextToken());
            switch(type){
                case 1:
                    p = Integer.parseInt(st.nextToken());
                    x = Long.parseLong(st.nextToken());
                    arr[p] += x;
                    break;
                case 2:
                    p = Integer.parseInt(st.nextToken());
                    q = Integer.parseInt(st.nextToken())-1;
                    long change=0;
                    for(; p<=q; ++p){
                        change += arr[p];
                    }
                    bw.write(String.valueOf(change));
                    bw.write("\n");
                    break;
            }
        }
        bw.flush();
        bw.close();
    }
}
