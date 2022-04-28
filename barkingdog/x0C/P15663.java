package barkingdog.x0C;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P15663 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static void est() throws IOException {st = new StringTokenizer(br.readLine());}
    static int rstn() throws IOException{return Integer.parseInt(st.nextToken());}
    static void func(int depth) throws IOException {
        if(depth ==M){
            bw.write(Arrays.toString(parr).replaceAll("[\\[\\],]",""));
            bw.write("\n");
            return;
        }
        int tmp=0;
        for(int i=0; i<N; i++){
            if(isUsed[i]==0 && tmp != arr[i]){
                parr[depth] = arr[i];
                isUsed[i] = 1;
                tmp = parr[depth];
                func(depth+1);
                isUsed[i] = 0;
            }
        }
    }

    static int N,M;
    static int[] arr,isUsed,isPrint,parr;

    public static void main(String[] args) throws IOException {
        est(); N = rstn(); M = rstn();
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        parr = new int[M];
        isUsed = new int[N];
        isPrint = new int[N];
        Arrays.sort(arr);
        func(0);
        bw.flush();
        bw.close();
    }
}
