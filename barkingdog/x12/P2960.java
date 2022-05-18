package barkingdog.x12;

import java.io.*;
import java.util.StringTokenizer;

public class P2960 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N,K,ans;
    static boolean[] arr = new boolean[1001];
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        for(int i=2; i<1001; ++i){
            for(int j=1; j<1001; ++j){
                if(i*j <= N){
                    if(!arr[i*j]){
                        ans++;
                        arr[i*j] = true;
                        if(ans == K){
                            System.out.println(i*j);
                            System.exit(0);
                        }
                    }
                    continue;
                }
                break;
            }
        }
    }
}
