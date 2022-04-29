package barkingdog.x0C;

import java.io.*;
import java.util.StringTokenizer;

public class P6603 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static void est() throws IOException {st = new StringTokenizer(br.readLine());}
    static int rstn() throws IOException{return Integer.parseInt(st.nextToken());}
    static void func(int depth,int cur) throws IOException {
        if(depth == 6) {
            for(int i=0; i<N; ++i){
                if(isUsed[i]==1){
                    bw.write(String.valueOf(arr[i]));
                    bw.write(" ");
                }
            }
            bw.write("\n");
            return;
        }
        for(int i=cur; i<N; ++i){
            if(isUsed[i] == 0){
                isUsed[i] = 1;
                func(depth+1,i);
                isUsed[i] = 0;
            }
        }
    }


    static int N;
    static int[] arr,isUsed;

    public static void main(String[] args) throws IOException {
        while(true){
            est(); N = rstn();
            if(N==0) break;
            arr = new int[N]; isUsed = new int[N];
            for(int i=0; i<N; ++i) arr[i] = rstn();
            func(0,0);
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
