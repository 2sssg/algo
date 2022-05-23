package barkingdog.x14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2230Twopointer {
    // 투포인터로 푼 풀이입니당~
    // 시간 384 ms
    // 메모리 29180kb
    // 얘가 쬐매 더 빠른풀이 ㅇㅇ

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N,M,be,en,ans;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        ans = Integer.MAX_VALUE;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for(int i=0; i<N; ++i) arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        while(be!=N){
            if(arr[en]-arr[be]>=M){
                ans = Math.min(ans,arr[en]-arr[be]);
                be++;
            }else{
                if(en==N-1) break;
                en++;
            }
        }
        System.out.println(ans);
    }
}
