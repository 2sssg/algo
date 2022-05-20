package barkingdog.x12;

import java.io.*;
import java.util.StringTokenizer;

public class P6064 {

    static int gcd(int a, int b){
        if(a==0) return b;
        return gcd(b%a, a);
    }
    static int lcm(int a, int b){
        return a/gcd(a,b)*b;
    }
    static int T,M,N,x,y,l;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        l: while(T-->0){
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            l = lcm(M,N);
            if(x==M) x=0;
            if(y==N) y=0;
            for(int i=x; i<=l; i+=M){
                if(i==0) continue;
                if(i%N == y ){
                    bw.write(String.valueOf(i));
                    bw.write("\n");
                    continue l;
                }
            }
            bw.write("-1\n");
        }
        bw.flush();
        bw.close();
    }
}
