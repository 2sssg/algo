package barkingdog.x13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2467 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N,min,var1,var2;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        min = Integer.MAX_VALUE;
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for(int i=0; i<N-1; ++i){
            int bin = Arrays.binarySearch(arr,-arr[i]);
            if(bin>=0){
                System.out.println(arr[i]+" "+(-arr[i]));
                System.exit(0);
            }else{
                if((bin+1)*-1 <N &&min>Math.abs(arr[(bin+1)*-1]+arr[i]) && i != (bin+1)*-1){
                    var1 = arr[i];
                    var2 = arr[(bin+1)*-1];
                    min = Math.abs(arr[(bin+1)*-1]+arr[i]);
                }
                if((bin+1)*-1-1 <N &&(bin+1)*-1-1 >=0 && min>Math.abs(arr[(bin+1)*-1 - 1]+arr[i]) && i != (bin+1)*-1-1){
                    var1 = arr[i];
                    var2 = arr[(bin+1)*-1-1];
                    min = Math.abs(arr[(bin+1)*-1-1]+arr[i]);
                }
                if((bin+1)*-1+1 <N &&(bin+1)*-1+1 >=0 && min>Math.abs(arr[(bin+1)*-1 + 1]+arr[i]) && i != (bin+1)*-1+1){
                    var1 = arr[i];
                    var2 = arr[(bin+1)*-1+1];
                    min = Math.abs(arr[(bin+1)*-1+1]+arr[i]);
                }
            }
        }
        System.out.println(var1+" " + var2);
    }
}
// 0 0 0 0 i0
// 0 1 2 3

// 4 4 4 i1
// 0 1 2

// 7 7 i2
// 0 1

// 9 i3
// 0