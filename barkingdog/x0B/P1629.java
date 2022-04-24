package barkingdog.x0B;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1629 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static void est() throws IOException {st = new StringTokenizer(br.readLine());}
    static int rstn() throws IOException{return Integer.parseInt(st.nextToken());}
    static long func(int b){
        if(b==1) return A%C;
        long var = func(b/2);
        var = (var * var) % C;
        if((b&1) == 1) return var*A%C;
        return var;
    }

    static int A,B,C;
    public static void main(String[] args) throws IOException {
        est(); A = rstn(); B = rstn(); C=rstn();
        System.out.println(func(B));
    }
}
