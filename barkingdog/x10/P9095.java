package barkingdog.x10;

import java.io.*;

public class P9095 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr = new int[13];
    static int n;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;
        for(int i=4; i<11; ++i){
            arr[i] += arr[i-1];
            arr[i] += arr[i-2];
            arr[i] += arr[i-3];
        }
        int temp;
        while(n-->0){
            temp = Integer.parseInt(br.readLine());
            bw.write(String.valueOf(arr[temp]));
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
