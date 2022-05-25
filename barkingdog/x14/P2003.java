package barkingdog.x14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2003 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N,M,en,ans;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+2];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; ++i) arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
        arr[N+1] = Integer.MAX_VALUE;
        for(int st=0; st<=N; ++st){
            while(arr[en]-arr[st]<M) en++;
            if(arr[en]-arr[st] == M) ans++;
        }
        System.out.println(ans);
    }
}
