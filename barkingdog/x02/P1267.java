package barkingdog.x02;

import java.io.*;
import java.util.StringTokenizer;

public class P1267 {
    static int N,Ymoney,Mmoney,time;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            time = Integer.parseInt(st.nextToken());
            Ymoney += ((time/30)+1)*10;
            Mmoney += ((time/60)+1)*15;
        }
        bw.write(Ymoney<Mmoney?"Y "+Ymoney:Ymoney==Mmoney?"Y M "+Ymoney:"M "+Mmoney);
        bw.flush();
        bw.close();

    }
}
