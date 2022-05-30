package barkingdog.x17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class P2075 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N*N];
        for(int i = 0; i<N; ++i){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; ++j){
                arr[i*N + j] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(arr);
        System.out.println(arr[N*N-N]);
    }
}
