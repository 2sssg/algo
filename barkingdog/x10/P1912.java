package barkingdog.x10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1912 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        int idx=0;
        int temp;
        arr[idx++] = Integer.parseInt(st.nextToken());
        while(st.hasMoreTokens()){
            temp = Integer.parseInt(st.nextToken());
            if(temp+arr[idx-1]<temp) arr[idx] = temp;
            else arr[idx] = arr[idx-1]+temp;
            idx++;
        }
        System.out.println(Arrays.stream(arr).max().getAsInt());
    }
}
