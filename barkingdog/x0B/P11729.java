package barkingdog.x0B;

import java.io.*;
import java.util.StringTokenizer;

public class P11729 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int rn() throws IOException {return Integer.parseInt(br.readLine());}

    static void func(int start, int end, int n) throws IOException {
        //func(*,3,1);
        if(n==1){
            bw.write(String.valueOf(start));
            bw.write(" ");
            bw.write(String.valueOf(end));
            bw.write("\n");
            return;
        }
        func(start, 6-start-end, n-1);
        bw.write(String.valueOf(start));
        bw.write(" ");
        bw.write(String.valueOf(end));
        bw.write("\n");
        func(6-start-end, end, n-1);
    }

    static int N;

    public static void main(String[] args) throws IOException {
        N = rn();

        bw.write(String.valueOf((1<<N)-1));
        bw.write("\n");
        func(1,3,N);
        bw.flush();
        bw.close();

    }
}
