package barkingdog.x10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11055 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[] arr;
    static int[] d;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        d = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; ++i){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        d[0] = arr[0];
        for(int i=1; i<N; ++i){
            for(int j=i-1; j>=0; --j){
                if(arr[j]<arr[i]){
                    d[i] = Math.max(d[j]+arr[i],d[i]);
                }
            }
            if(d[i] == 0) d[i] = arr[i];
        }
        System.out.println(Arrays.stream(d).max().getAsInt());
    }
}
