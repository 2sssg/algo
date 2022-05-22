package barkingdog.x13;

import java.io.*;
import java.util.Arrays;

public class P10815 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N,M;
    static int[] arr,f;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);
        M = Integer.parseInt(br.readLine());
        f = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for(int n: f){
            if(Arrays.binarySearch(arr,n)>=0){
                bw.write("1 ");
            }else{
                bw.write("0 ");
            }
        }
        bw.flush();
        bw.close();
    }
}
