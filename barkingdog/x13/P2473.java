package barkingdog.x13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2473 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    static int N,var1,var2,var3,sumtemp;
    static long min;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        min = Long.MAX_VALUE;
        N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);
        for(int i=0; i<N-1; ++i){
            for(int j=i+1; j<N; ++j){
                sumtemp = arr[i]+arr[j];
                int t = Arrays.binarySearch(arr,j+1,N,sumtemp*-1);
                if(t>= 0){
                    System.out.println(arr[i]+" "+arr[j] + " " + arr[t]);
                    System.exit(0);
                }else{
                    t = (t+1)*-1;
                    t--;
                    if(t>=0&& t<N && min>Math.abs((long)sumtemp+(long)arr[t]) && t!=i && t!= j){
                        var1 = arr[i];
                        var2 = arr[j];
                        var3 = arr[t];
                        min = Math.abs((long)sumtemp+(long)arr[t]);
                    }
                    t++;
                    if(t>=0&& t<N && min>Math.abs((long)sumtemp+(long)arr[t]) && i!=t && j!=t){
                        var1 = arr[i];
                        var2 = arr[j];
                        var3 = arr[t];
                        min = Math.abs((long)sumtemp+(long)arr[t]);
                    }
                    t++;
                    if(t>=0&& t<N && min>Math.abs((long)sumtemp+(long)arr[t])&&i!=t && j!=t){
                        var1 = arr[i];
                        var2 = arr[j];
                        var3 = arr[t];
                        min = Math.abs((long)sumtemp+(long)arr[t]);
                    }

                }
            }
        }
        System.out.println(var1 + " " + var2 +" " + var3);
    }
}

//5
//1000000000 999999999 999999998 999999997 999999996