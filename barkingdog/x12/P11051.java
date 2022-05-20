package barkingdog.x12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11051 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int func(int n, int k){
//        System.out.println("n : "+n);
//        System.out.println("k : "+k);
//        System.out.println();
        if(n==k||k==0){
            return 1;
        }
        if(k==1){
            return n;
        }
        if(d[n][k] != 0){
            return d[n][k];
        }
        d[n][k] =  (func(n-1,k-1)+func(n-1,k))%10007;
        return d[n][k];
    }
    static int[][] d;
    static int N,K;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        d = new int[1001][1001];
        d[1][1] = 1;
        d[2][1] = 2;
        d[2][2] = 1;
        d[3][1] = 3;
        d[3][2] = 3;
        d[3][3] = 1;
//        for(int i=1 )
        System.out.println(func(N,K));
    }
}


// nCk == (n-1)C(k-1) + (n-1)Ck
// d[n][k] == d[n-1][k-1] + d[n-1][k]
