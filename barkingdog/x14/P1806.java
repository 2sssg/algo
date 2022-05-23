package barkingdog.x14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1806 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N,S,en,ans;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        ans = Integer.MAX_VALUE;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        arr[1] = Integer.parseInt(st.nextToken());
        for(int i=2; i<N+1; ++i) arr[i] = arr[i-1]+Integer.parseInt(st.nextToken());
//        System.out.println(Arrays.toString(arr));
        for(int i=0; i<N; ++i){
            while(en<N+1 && arr[en]-arr[i]<S) en++;
            if(en==N+1) break;
            ans = Math.min(en-i,ans);
        }
        if(ans==Integer.MAX_VALUE){
            System.out.println("0");
        }else{
            System.out.println(ans);
        }
    }
}

