package barkingdog.x15;

import java.io.*;
import java.util.*;

public class P9375 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static HashMap<String,Integer> m = new HashMap<>();

    static int T,N,pick,sSize,ans;
    static String cloth;



    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        while(T-->0){
            ans = 1;
            m.clear();
            N = Integer.parseInt(br.readLine());
            for(int i=0; i<N; ++i){
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                cloth = st.nextToken();
                if(m.containsKey(cloth)) m.put(cloth,m.get(cloth)+1);
                else m.put(cloth,1);
            }
            for(int i : m.values()){
                ans *= i+1;
            }
            bw.write(String.valueOf(ans-1));
            bw.write("\n");
        }
        bw.flush();
        bw.close();

    }
}
