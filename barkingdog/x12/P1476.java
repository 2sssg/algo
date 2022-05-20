package barkingdog.x12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1476 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int gcd(int a, int b){
        if(a==0)return b;
        return gcd(b%a, a);
    }
    static int lcm(int a, int b){
        return a*b/gcd(a,b);
    }

    static int E,S,M;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        E = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        E--;
        S--;
        M--;

        int i = E;
        while(i % 28 != S) i += 15;

        int l = lcm(15, 28);
        while(i % 19 != M) i += l;
        System.out.println(i+1);
    }
}

//E == 15
//S == 28
//M == 19
