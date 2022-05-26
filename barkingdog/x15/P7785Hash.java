package barkingdog.x15;

import java.io.*;
import java.util.*;

public class P7785Hash {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static HashSet<String> hs = new HashSet<>();

    static String name;
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        while(N-->0) {
            st = new StringTokenizer(br.readLine());
            name = st.nextToken();
            if(st.nextToken().equals("enter")) hs.add(name);
            else hs.remove(name);
        }
        ArrayList<String> l = new ArrayList<>(hs);
        l.sort(Collections.reverseOrder());
        for(String s: l){
            bw.write(s);
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
