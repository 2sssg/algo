package barkingdog.x13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P3151 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int lowerbound(int target,int startindex){
        st = startindex;
        en = N;
        while(st<en){
            mid = (st+en)/2;
            if(arr[mid]>=target) en = mid;
            else st = mid+1;
        }
        return en;
    }
    static int upperbound(int target,int startindex){
        st = startindex;
        en = N;
        while(st<en){
            mid = (st+en+1)/2;
            if(arr[mid]<=target) st = mid+1;
            else en = mid;
        }
        return en;
    }
    static int cnt(int target,int startindex){
        return upperbound(target,startindex)-lowerbound(target,startindex);
    }
    static int N,st,en,mid,targetcnt;
    static long ans;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);
        int idx = 0;
        for(int i=0; i<N-1; ++i){
            for(int j=i+1; j<N; ++j){
                idx = (arr[i]+arr[j])*-1;
                targetcnt = cnt(idx,j+1);
                if(Arrays.binarySearch(arr,j+1,N,idx)>=j+1){
                    ans += targetcnt;
                }
            }
        }
        System.out.println(ans);

    }
}


// 0 1 1 1 2 3 4
// 0 1 2 3 4 5 6

//10
//-1 -1 2 -1 -1 2 -1 -1 2 -1