package barkingdog.x14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2230 {
    //이분탐색으로 푼 풀이
    //시간 = 408 ms
    //메모리 = 30412kb
    // 투포인터가 쬐끔 빠름
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int lowerBound(int target){
        be = 0;
        en = N;
        while(be<en){
            mid = (be+en)/2;
            if(arr[mid]>=target) en = mid;
            else be = mid+1;
        }
        return en;
    }


    static int N,M,ans,be,en,mid,tempans,lo;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        ans = Integer.MAX_VALUE;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for(int i=0; i<N; ++i) arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        for(int i=0; i<N; ++i){
            lo = lowerBound(arr[i]+M);
            if(lo<N){
                tempans = Math.min(ans,Math.abs(arr[i]-arr[lo]));
                if(tempans>=M){
                    ans = tempans;
                }
            }
        }
        System.out.println(ans);
    }
}


