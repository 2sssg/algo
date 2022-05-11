package barkingdog.x10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11727 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



    static int n;
    static int[] d;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        d = new int[1001];
        d[1] = 1;
        d[2] = 3;
        d[3] = 5;
        for(int i=4; i<n+1; ++i){
            d[i] = (d[i-1] + d[i-2]*2)%10007;
        }
        System.out.println(d[n]);
    }
}
