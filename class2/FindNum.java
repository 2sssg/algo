package class2;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindNum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N,M;
        int[] arr, ansarr, dpAnswer;
        N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        M = Integer.parseInt(br.readLine());
        ansarr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();


        l:for(int find: ansarr){
            for(int i=0; i<N; i++){
                if(arr[i]>find) {
                    break;
                }
                if(arr[i]==find) {
                    bw.write("1\n");
                    continue l;
                }
            }
            bw.write("0\n");
        }


        bw.flush();
        bw.close();
    }
}
