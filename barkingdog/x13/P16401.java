package barkingdog.x13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P16401 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[] arr;
    static int N,M;
    static long mid,sta,en;

    static boolean solve(long n){
        if(n == 0) return true;
        int ans=0;
        for(int i=0; i<N; ++i) ans += arr[i]/n;
        return ans>=M;
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        sta = -1;
        en = Integer.MAX_VALUE;
        while(sta<en){
            mid = (sta+en+1)/2;
            if(solve(mid)) sta = mid;
            else en = mid-1;
        }
        System.out.println(sta);
    }
}
