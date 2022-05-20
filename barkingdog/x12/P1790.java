package barkingdog.x12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1790 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N,K;
    static int jari(int n){
        int ret=0;
        while(n!=0){
            n/=10;
            ret++;
        }
        return ret;
    }
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        for(int i=1; i<N+1; ++i){
            K -= jari(i);
            if(K<=0){
                System.out.println(String.valueOf(i).charAt(String.valueOf(i).length()+K-1));
                System.exit(0);
                break;
            }
        }
        System.out.println("-1");
    }
}
