package barkingdog.x13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2110 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stt;

    static int[] arr;
    static int N,C,st,en,mid,ans,distst, disten, distmid;


    static int upperBound(int target){
        st = 0;
        en = N;
        while(st<en){
            mid = (st+en)/2;
            if(arr[mid]<=target-1) st = mid+1;
            else en = mid;
        }
        return en;
    }
    static int solve(int ans){
        int temp = arr[0];
        int min = Integer.MAX_VALUE;
        for(int i=0; i<C; ++i){
            int next = upperBound(temp);
            if(N<=next){
                return -1;
            }
            if(i!=0){
                min = Math.min(min,arr[next]-(temp-ans));
            }
            temp = arr[next]+ ans;
        }
        if(min>ans){
            return 0;
        }
        if(arr[N-1]-temp>ans){
            return 0;
        }
        return 1;
    }
    public static void main(String[] args) throws IOException {
        stt = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stt.nextToken());
        C = Integer.parseInt(stt.nextToken());
        arr = new int[N];
        for(int i=0; i<N; ++i) arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        distst = 0;
        disten = Integer.MAX_VALUE;
        while(distst<disten){
            distmid = (distst+disten)/2;
            int so =solve(distmid);
            if(so==-1){
                disten = distmid;
            }else if(so == 0){
                distst = distmid+1;
            }else{
                break;
            }
        }

        System.out.println(distmid);
    }
}

//5 5
//213218
//412891
//158912
//214892
//851933

//4 3
//11
//13
//16
//18

//5 3
//1
//7
//8
//9
//10

//4 3
//1
//3
//7
//8