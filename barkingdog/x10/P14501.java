package barkingdog.x10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P14501 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[][] arr;
    static int[] d;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        d = new int[N];
        for(int i=0; i<N; ++i){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i=N; i>=1; --i){
            if(i+arr[i-1][0] > N+1){
                if(i==N){
                    d[i-1] = 0;
                }else{
                    d[i-1] = d[i];
                }
            }else if(i+arr[i-1][0] == N+1){
                if(i==N){
                    d[i-1] = arr[i-1][1];
                }else{
                    d[i-1] = Math.max(arr[i-1][1],d[i]);
                }
            }else{
                d[i-1] = Math.max(d[i],d[i+arr[i-1][0]-1] + arr[i-1][1]);
            }
        }

        System.out.println(Arrays.stream(d).max().getAsInt());
        System.out.println(Arrays.toString(d));
    }
}
