package barkingdog.x14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P13144 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N,en;
    static long ans;
    static int[] arr;
    static boolean[] arr2 = new boolean[100005];
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for(int st=0; st<N; ++st){
            while(en<N && !arr2[arr[en]]) {
                arr2[arr[en++]] = true;
            }
            ans += en-st;
            arr2[arr[st]] = false;
        }
        System.out.println(ans);
    }
}
