package barkingdog.x03;

import java.io.*;
import java.util.StringTokenizer;

public class P10807 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N,v,result;
    static StringTokenizer st;
    static int[] arr = new int[205];

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(br.readLine());
        while(st.hasMoreTokens())arr[Integer.parseInt(st.nextToken())+100]++;
        bw.write(String.valueOf(arr[v+100]));
        bw.flush();
        bw.close();
    }
}
