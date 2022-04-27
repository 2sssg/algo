package barkingdog.x0C;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1182 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static void est() throws IOException {st = new StringTokenizer(br.readLine());}
    static int rstn() throws IOException{return Integer.parseInt(st.nextToken());}
    static void sum(int ss,int depth){
        if(depth == N) {
            if(S==ss) cnt++;
            return;
        }
        sum(ss,depth+1);
        sum(ss+arr[depth],depth+1);
    }


    static int N,S,s,cnt;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        est(); N = rstn(); S = rstn();
        arr = new int[N];
        est();
        for(int i=0; i<N; i++) arr[i] = rstn();
        sum(0,0);
        if(S==0) cnt--;
        System.out.println(cnt);
    }
}
