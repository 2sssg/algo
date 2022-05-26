package barkingdog.x14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P20922 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    static int N,K,en,ans;
    static int[] arr,arr2;
    public static void main(String[] args) throws IOException {
        arr2 = new int[100002];
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for(int st=0; st<N; ++st){
            while(en<N && arr2[arr[en]]<K) {
                arr2[arr[en]]++;
                en++;
            }
            ans = Math.max(en-st,ans);
            arr2[arr[st]]--;
        }
        System.out.println(ans);

    }
}
