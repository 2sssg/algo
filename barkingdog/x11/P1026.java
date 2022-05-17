package barkingdog.x11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1026 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] arr1, arr2;
    static int N,ans;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        arr2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for(int i=0; i<N; ++i){
            ans += arr1[i]*arr2[N-i-1];
        }
        System.out.println(ans);
    }
}
