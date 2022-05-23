package barkingdog.x13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P7453Sec {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int lowerBound(int target){
        be = 0;
        en = N*N;
        while(be<en){
            mid = (be+en)/2;
            if(arr5[mid]>=target)en = mid;
            else be = mid+1;
        }
        return en;
    }
    static int upperBound(int target){
        be = 0;
        en = N*N;
        while(be<en){
            mid = (be+en)/2;
            if(arr5[mid]<=target)be = mid+1;
            else en = mid;
        }
        return en;
    }
    static int N,be,en,mid,up,lo;
    static long ans,ans2,ans3,ans4;
    static int[] arr1, arr2, arr3, arr4,arr5;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr1 = new int[N];
        arr2 = new int[N];
        arr3 = new int[N];
        arr4 = new int[N];
        arr5 = new int[N*N];
        for(int i=0; i<N; ++i){
            st = new StringTokenizer(br.readLine());
            arr1[i] = Integer.parseInt(st.nextToken());
            arr2[i] = Integer.parseInt(st.nextToken());
            arr3[i] = Integer.parseInt(st.nextToken());
            arr4[i] = Integer.parseInt(st.nextToken());
        }
        int idx = 0;
        for(int i=0; i<N; ++i){
            for(int j=0; j<N; ++j){
                arr5[idx++] = arr3[i]+arr4[j];
            }
        }
        Arrays.sort(arr5);
//        System.out.println(Arrays.toString(arr5));
        for(int i=0; i<N; ++i){
            for(int j=0; j<N; ++j){
                up = upperBound(-arr1[i]-arr2[j]);
                lo = lowerBound(-arr1[i]-arr2[j]);
//                if(Arrays.binarySearch(arr5,-(arr1[i]+arr2[j]))>=0){
//                    System.out.println(-arr1[i]-arr2[j]);
//                    System.out.println("up : "+up);
//                    System.out.println("lo : "+lo);
//                    System.out.println();
//                }else{
//                    System.out.println("notfound up : "+up);
//                    System.out.println("notfound lo : "+lo);
//                    System.out.println();
//                }
//                if(up-lo >0){
//                    System.out.println("up : "+up);
//                    System.out.println("lo : "+lo);
                ans += up-lo;
//                }
            }
        }
        System.out.println(ans);
    }
}
