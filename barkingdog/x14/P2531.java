package barkingdog.x14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2531 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N,d,k,c,en,ans,sol;
    static boolean couponin;
    static int[] arr,arr2;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new int[N+k-1];
        arr2 = new int[d+1];
        for(int i=0; i<N; ++i) arr[i] = Integer.parseInt(br.readLine());
        for(int i=N; i<N+k-1; ++i) arr[i] = arr[i-N];
        for(int i=0; i<k; ++i) {
            if(arr[i]==c) couponin = true;
            if(arr2[arr[i]]==0)ans++;
            arr2[arr[i]]++;
        }
        if(!couponin) sol = ans+1;
        else sol = ans;
        for(int st=1; st<N; ++st){
            if(--arr2[arr[st-1]]==0) {
                if(arr[st-1]==c) couponin = false;
                ans--;
            }
            if(arr2[arr[st+k-1]]++==0){
                if(arr[st+k-1]==c) couponin=true;
                ans++;
            }
            if(!couponin) sol = Math.max(sol,ans+1);
            else sol = Math.max(sol,ans);
        }
        System.out.println(sol);


    }
}
