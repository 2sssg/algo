package barkingdog.x0E;

import java.io.*;

public class P15688 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int rn() throws IOException {return Integer.parseInt(br.readLine());}
    static int N;
    static int[] arr = new int[2000001];
    public static void main(String[] args) throws IOException {
        N = rn();
        while(N-->0) arr[rn()+1000000]++;
        for(int i=0; i<2000001; i++){
            if(arr[i]>0){
                for(int j=0; j<arr[i]; j++){
                    bw.write(String.valueOf(i-1000000));
                    bw.write("\n");
                }
            }
        }
        bw.flush();
        bw.close();
    }
}
