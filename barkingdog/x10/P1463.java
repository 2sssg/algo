package barkingdog.x10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1463 {
    static int N;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dparr = new int[1000005];
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        dparr[1] = 0;
        for(int i=2; i<=N; ++i){
            dparr[i] = dparr[i-1]+1;
            if(i%2 == 0) dparr[i] = Math.min(dparr[i],dparr[i/2]+1);
            if(i%3 == 0) dparr[i] = Math.min(dparr[i],dparr[i/3]+1);
        }
        System.out.println(dparr[N]);

    }
}
