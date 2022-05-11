package barkingdog.x10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1699 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] d = new int[100005];

    static int func(int val){
        if(d[val] != 0){
            return d[val];
        }
        int temp=999999;
        for(int i=1; i<=val/2; ++i){
            temp = Math.min(func(i)+func(val-i), temp);
        }
        d[val] = temp;
        return d[val];
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        for(int i=1; i<316; ++i) d[i*i] = 1;
        for(int i=1; i<N+1; ++i){
            func(i);
        }

        System.out.println(d[N]);
//        System.out.println(Arrays.toString(d));
    }
}
