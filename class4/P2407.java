package class4;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class P2407 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static void est() throws IOException {st = new StringTokenizer(br.readLine());}
    static int rstn() throws IOException{return Integer.parseInt(st.nextToken());}

    static BigInteger func(int temp,int depth){
        if(depth ==M-1) return new BigInteger(String.valueOf(temp));
        BigInteger t = new BigInteger(String.valueOf(temp)).multiply(func(temp-1,depth+1));
        return t;
    }
    static int N,M;
    public static void main(String[] args) throws IOException {
        est(); N = rstn(); M = rstn();
        BigInteger t1,t2;
        t1 = func(N,0);
        t2 = func(M,0);
        System.out.println(t1.divide(t2));
    }
}
