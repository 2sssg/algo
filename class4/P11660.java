package class4;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11660 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;


    static void est() throws IOException {st = new StringTokenizer(br.readLine());}
    static int rstn() throws IOException{return Integer.parseInt(st.nextToken());}

    static int N,M,tempsum,x1,y1,x2,y2;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        est(); N = rstn(); M = rstn();
        arr = new int[N*N];

        for(int i=0; i<N; ++i){
            est();
            for(int j=0; j<N; ++j){
                arr[(i*N)+j] = tempsum + rstn();
                tempsum = arr[(i*N)+j];
            }
        }
        while(M-->0){
            tempsum = 0;
            est();x1 = rstn();y1 = rstn();x2 = rstn();y2 = rstn();
            for(int i=x1; i<=x2; i++){
                int temp;
                if((i-1)*N+y1-2<0){
                    temp = 0;
                }else{
                    temp = arr[(i-1)*N+y1-2];
                }
                tempsum += arr[(i-1)*N + y2-1] - temp;
            }
            bw.write(String.valueOf(tempsum));
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
