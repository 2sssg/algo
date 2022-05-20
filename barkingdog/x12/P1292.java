package barkingdog.x12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1292 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int A,B,idx;
    static int[] arr = new int[600000];
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        arr[0] = 1;
        idx = 1;
        for(int i=2; i<1002; ++i){
            for(int j=0; j<i;++j){
                arr[idx] = arr[idx-1]+i;
                idx++;
            }
        }
        if(A==1){
            System.out.println(arr[B-1]);
        }else{
            System.out.println(arr[B-1]-arr[A-2]);
        }
    }
}
