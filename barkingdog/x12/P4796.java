package barkingdog.x12;

import java.io.*;
import java.util.StringTokenizer;

public class P4796 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int L,P,V,ans;
    public static void main(String[] args) throws IOException {
        for(int i=1; i<Integer.MAX_VALUE; ++i){
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());
            if(L==0 && P==0 && V==0) break;
            ans = (V/P)*L + Math.min(L,V%P);
            bw.write("Case ");
            bw.write(String.valueOf(i));
            bw.write(": ");
            bw.write(String.valueOf(ans));
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
