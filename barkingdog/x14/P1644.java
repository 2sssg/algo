package barkingdog.x14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P1644 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N,en,ans;
    static List<Integer> li = new ArrayList<>();
    static int[] arr,arr2;
    static int eratotenes(){
        int temp = N+1;
        arr[1] = -1;
        temp--;
        for(int i=2; i*i<=N; ++i){
            for(int j=i*i; j<=N; j+=i){
                if(arr[j] != -1){
                    temp--;
                    arr[j] = -1;
                }
            }
        }
        return temp;
    }
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        for(int i=0; i<=N; ++i) arr[i] = i;
        int NN = eratotenes();
        arr2 = new int[NN];
        int idx = 1;
        arr2[0] = 0;
        for(int i=1; i<=N; ++i) if(arr[i]!=-1) {
            arr2[idx] = arr[i]+arr2[idx-1];
            idx++;
        }
        for(int st = 0; st<NN; ++st){
            while(en<NN && arr2[en]-arr2[st]<N) en++;
            if(en==NN) break;
            if(arr2[en]-arr2[st]==N) ans++;
        }
        System.out.println(ans);

    }
}
