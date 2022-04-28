package barkingdog.x0C;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P15655 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static void est() throws IOException {st = new StringTokenizer(br.readLine());}
    static int rstn() throws IOException{return Integer.parseInt(st.nextToken());}
    static void func(int depth,int cur) throws IOException {
        if(depth == M){
            bw.write(Arrays.toString(parr).replaceAll("[\\[\\],]",""));
            bw.write("\n");
            return;
        }
        for(int i=cur; i<N; i++){
            if(isUsed[i]==0){
                parr[depth] = arr[i];
                isUsed[i]=1;
                func(depth+1,i+1);
                isUsed[i]=0;
            }
        }
    }


    static int N,M;
    static int[] arr,isUsed,parr;
    public static void main(String[] args) throws IOException {
        est(); N = rstn(); M = rstn();
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        isUsed = new int[N];
        parr = new int[M];
        Arrays.sort(arr);
        func(0,0);
        bw.flush();
        bw.close();
    }
}
