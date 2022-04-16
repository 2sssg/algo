package barkingdog.x02;

import java.io.*;
import java.util.Arrays;

public class P2309 {
    static int fir,sec,sum;
    static int[] arr = new int[9];
    static int[] arr2 = new int[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i=0; i<9; i++){
            arr[i] = Integer.parseInt(br.readLine());
            arr2[arr[i]]++;
            sum += arr[i];
        }
        Arrays.sort(arr);

        for(int height: arr){
            if(!(sum-100-height>100)){
                if(arr2[sum-100-height] >0){
                    fir = height;
                    sec = sum-100-height;
                    if((fir==sec)&&(arr2[height]==1)) continue;
                    break;
                }
            }
        }
        for(int height: arr){
            if(!((height ==fir || height ==sec)&&arr2[height]==1)){
                bw.write(String.valueOf(height));
                bw.write("\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
