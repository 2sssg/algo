package barkingdog.x03;

import java.io.*;
import java.util.Arrays;

public class P3273 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n,x,result;
    static int[] arr = new int[1000005];
    static int[] arr2;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        x = Integer.parseInt(br.readLine());

        for(int v: arr2) arr[v]++;
        for(int v: arr2) {
            if(x-v<=0 || x-v>1000000) continue;
            if(arr[x-v]>0) result++;
        }
        bw.write(String.valueOf(result/2));
        bw.flush();
        bw.close();
    }
}
