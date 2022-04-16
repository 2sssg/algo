package class3;

import java.io.*;
import java.util.Arrays;

public class Tong {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr,flagarr;
        int N,tempNum,maxnum,maxweight;

        flagarr = new int[8001];
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        maxnum = -9999;
        maxweight = 0;
        for(int i=0; i<N; i++){
            tempNum = Integer.parseInt(br.readLine());
            arr[i] = tempNum;
            flagarr[tempNum+4000]++;
            if(maxweight< flagarr[tempNum+4000]){
                maxweight = flagarr[tempNum+4000];
                maxnum = tempNum;
            }
        }

        Arrays.sort(arr);






    }
}
