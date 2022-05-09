package barkingdog.x0F;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P11652 {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static long[] arr;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new long[N];
        for(int i=0; i<N; ++i) arr[i] = Long.parseLong(br.readLine());
        Arrays.sort(arr);
        long cur = Long.MIN_VALUE;
        int cnt=0;
        int max=0;
        long ans=0;
        for(int i=0; i<N; ++i){
            if(cur != arr[i]){
                if(max<cnt){
                    max = cnt;
                    ans = arr[i-1];
                }
                cnt = 1;
                cur = arr[i];
            }
            else{
                cnt++;
            }
        }
        if(cnt>max){
            System.out.println(arr[arr.length-1]);
        }else{
            System.out.println(ans);
        }
    }
}
