package extra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class P2108 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int[] arr;
    static int[] arr2 = new int[8001];
    static Set<Integer> choi = new TreeSet<>();
    static int N,cur,sum;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for(int i=0; i<N; ++i){
            cur = Integer.parseInt(br.readLine());
            sum+=cur;
            arr2[4000+cur]++;
            arr[i] = cur;
        }
        Arrays.sort(arr);
        int max=0;
        int idx=-1;
        for(int i=0; i<8001; ++i){
            if(arr2[i]>max){
                max = arr2[i];
                idx = i-4000;
            }
        }
        for(int i=0; i<8001; ++i){
            if(arr2[i] == max){
                choi.add(i-4000);
            }
        }

        System.out.println(Math.round((double)sum / (double)N));
        System.out.println(arr[N/2]);
        int count=0;
        if(choi.size()>1){
            for(int temp: choi){
                count++;
                if(count==2){
                    System.out.println(temp);
                }
            }
        }else{
            for(int temp: choi){
                count++;
                if(count==1){
                    System.out.println(temp);
                }
            }
        }

        System.out.println(arr[N-1]-arr[0]);
    }
}
