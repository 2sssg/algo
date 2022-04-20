package barkingdog.x0E;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class P11931 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;


    public static void main(String[] args) throws IOException {
//        int[] arr = new int[1000005];
//        Integer[] arr2;
//        Arrays.fill(arr,-1000005);
//        N = Integer.parseInt(br.readLine());
//        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(br.readLine());
//        arr2 = Arrays.stream(arr).boxed().toArray(Integer[]::new);
//        Arrays.sort(arr2, Collections.reverseOrder());
//
//        for(int i : arr2){
//            if(i<-1000000)break;
//            bw.write(String.valueOf(i));
//            bw.write("\n");
//        }
//        bw.flush();
//        bw.close();


        //풀이 2
        int[] arr = new int[2000002];
        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++) ++arr[Integer.parseInt(br.readLine())+1000000];
        for(int i=2000001; i>=0; i--){
            if(arr[i]==1) {
                bw.write(String.valueOf(i-1000000));
                bw.write("\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
