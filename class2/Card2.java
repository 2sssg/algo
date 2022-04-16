package class2;

import java.io.*;
import java.util.Arrays;

public class Card2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N,M;
        int[] arr, findarr , answerarr;
        answerarr = new int[20000002];
        N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        M = Integer.parseInt(br.readLine());
        findarr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for(int arrElem : arr){
            answerarr[arrElem+10000000] = answerarr[arrElem+10000000]+1;
        }

        for(int findElem : findarr){
            bw.write(String.valueOf(answerarr[findElem+10000000]));
            bw.write(" ");
        }

        bw.flush();
        bw.close();
    }
}
