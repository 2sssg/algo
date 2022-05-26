package barkingdog.x15;

import java.io.*;
import java.util.*;

public class P7785 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static TreeSet<String> ts = new TreeSet<>(Collections.reverseOrder());
    static String name;
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        while(N-->0) {
            st = new StringTokenizer(br.readLine());
            name = st.nextToken();
            if(st.nextToken().equals("enter")) ts.add(name);
            else ts.remove(name);
        }
        for (String t : ts) {
            bw.write(t);
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
