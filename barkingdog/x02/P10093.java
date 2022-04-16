package barkingdog.x02;

import java.io.*;
import java.util.StringTokenizer;

public class P10093 {
    static Long A,B;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        bw.write(Math.abs(A-B)-1==-1?"0":String.valueOf(Math.abs(A-B)-1));
        bw.write("\n");
        for(long i=Math.min(A,B)+1; i<Math.max(A,B); i++) bw.write(i+" ");
        bw.flush();
        bw.close();
    }
}
