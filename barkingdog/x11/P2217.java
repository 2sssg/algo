package barkingdog.x11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class P2217 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N,ans;
    static Integer[] w = new Integer[100005];
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        Arrays.fill(w,0);
        for(int i=0; i<N; ++i) w[i] = Integer.parseInt(br.readLine());
        Arrays.sort(w, Collections.reverseOrder());
        for(int i=1; i<=N; ++i){
            ans = Math.max(ans,w[i-1]*i);
        }
        System.out.println(ans);

    }

}
