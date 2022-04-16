package barkingdog.x03;

import java.io.*;
import java.util.StringTokenizer;

public class P13300 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int[][] arr = new int[2][6];
    static int N,K,sum;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        while(N-->0){
            st = new StringTokenizer(br.readLine());
            arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())-1]++;
        }

        for(int i=0; i<6; i++){
            sum += (arr[0][i])/K;
            if(arr[0][i]%K >0) ++sum;
            sum += (arr[1][i])/K;
            if(arr[1][i]%K >0) ++sum;
        }
        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
}
