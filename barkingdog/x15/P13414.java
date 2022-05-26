package barkingdog.x15;

import java.io.*;
import java.util.*;

public class P13414 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static HashMap<String,Integer> m = new HashMap<>();
    static TreeMap<Integer,String> m2 = new TreeMap<>();

    static int K,L;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        for(int i=0; i<L; ++i) m.put(br.readLine(),i);
        for(String t : m.keySet()) m2.put(m.get(t),t);
        int cnt=0;
        for(String t: m2.values()){
            if(cnt++ == K) break;
            bw.write(String.valueOf(t));
            bw.write("\n");
        }

        bw.flush();
        bw.close();

    }
}
