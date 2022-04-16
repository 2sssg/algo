package barkingdog.x03;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11328 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int[] arr = new int[26];

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        l:while(N-- > 0){
            st = new StringTokenizer(br.readLine());
            for(char v : st.nextToken().toCharArray()) ++arr[v-'a'];
            for(char v : st.nextToken().toCharArray()) --arr[v-'a'];
            for(int i : arr){
                if(i!=0){
                    Arrays.fill(arr,0);
                    bw.write("Impossible\n");
                    continue l;
                }
            }
            bw.write("Possible\n");
        }

        bw.flush();
        bw.close();
    }
}
