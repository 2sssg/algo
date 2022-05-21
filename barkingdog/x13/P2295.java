package barkingdog.x13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2295 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N,arr2len,sum,ans;
    static int[] arr,arr2;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for(int i=0; i<N; ++i) arr[i] = Integer.parseInt(br.readLine());
        arr2len = (N+1)*N/2;
        arr2 = new int[arr2len];
        int idx = 0;
        for(int i=0; i<N; ++i){
            for(int j=i; j<N;++j){
               arr2[idx++] = arr[i]+arr[j];
            }
        }
        Arrays.sort(arr2);
        for(int i=0; i<N; ++i){
            for(int j=0; j<N; ++j){
                sum = arr[j]-arr[i];
                if(Arrays.binarySearch(arr2,sum)>=0){
                    ans = Math.max(ans,arr[j]);
                }
            }
        }
        System.out.println(ans);
    }
}
