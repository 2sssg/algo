package barkingdog.x12;

import java.io.*;
import java.util.StringTokenizer;

public class P9613 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static void func(int depth,int cur){
        if(depth == 2){
            ans += gcd(pair[0],pair[1]);
            return;
        }
        for(int i=cur; i<N; ++i){
            pair[depth] = arr[i];
            func(depth+1, i+1);
        }
    }
    static int gcd(int a, int b){
        if(b == 0){
            return a;
        }else{
            return gcd(b, a%b);
        }
    }
    static int T,N;
    static long ans;
    static int[] arr,pair;
    public static void main(String[] args) throws IOException {
        pair = new int[2];
        T = Integer.parseInt(br.readLine());
        while(T-->0){
            ans = 0;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            arr = new int[N];
            for(int i=0; i<N; ++i){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            func(0,0);
            System.out.println(ans);
        }
    }
}
