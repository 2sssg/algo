package barkingdog.x10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2011 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int[] a = new int[5010];
    static int[] d = new int[5010];
    static int mod = 1000000;
    public static void main(String[] args) throws IOException {
        String s;
        s = br.readLine();
        n = s.length();
        for(int i = 1; i <= n; ++i) a[i] = s.charAt(i-1) - '0';
        d[0] = 1;
        for(int i = 1; i <= n; ++i){
            if(a[i] > 0) d[i] = (d[i] + d[i-1]) % mod;
            int x = a[i-1] * 10 + a[i];
            if(x >= 10 && x <= 26) d[i] = (d[i] + d[i-2]) % mod;
        }
        System.out.println(d[n]);
    }
}
