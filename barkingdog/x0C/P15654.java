package barkingdog.x0C;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P15654 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static void est() throws IOException {st = new StringTokenizer(br.readLine());}
    static int rstn() throws IOException{return Integer.parseInt(st.nextToken());}
    static void cum(int idx) throws IOException {
        if(idx == M){
            bw.write(Arrays.toString(parr).replaceAll("[\\[\\],]",""));
            bw.write("\n");
            return;
        }
        for(int i=0; i<N; i++){
            if(isUsed[i]==0){
                parr[idx] = arr[i];
                isUsed[i] = 1;
                cum(idx+1);
                isUsed[i] = 0;
            }
        }
    }

    static int N,M;
    static int[] arr,isUsed,parr;
    public static void main(String[] args) throws IOException {
        est(); N = rstn(); M = rstn();
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);
        isUsed = new int[N];
        parr = new int[M];
        cum(0);
        bw.flush();
        bw.close();
    }
}
