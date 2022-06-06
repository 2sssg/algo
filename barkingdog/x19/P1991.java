package barkingdog.x19;

import java.io.*;
import java.util.StringTokenizer;

public class P1991 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;


    static char v1,v2,v3;
    static char[] p,l,r;
    static int V;

    static void predfs(char cur) throws IOException {
        if(cur==0) return;
        bw.write(String.valueOf(cur));
        predfs(l[cur-'A']);
        predfs(r[cur-'A']);
    }
    static void indfs(char cur) throws IOException{
        if(cur==0) return;
        indfs(l[cur-'A']);
        bw.write(String.valueOf(cur));
        indfs(r[cur-'A']);

    }
    static void postdfs(char cur) throws IOException{
        if(cur==0) return;
        postdfs(l[cur-'A']);
        postdfs(r[cur-'A']);
        bw.write(String.valueOf(cur));

    }
    public static void main(String[] args) throws IOException {
        V = Integer.parseInt(br.readLine());
        p = new char[V];
        l = new char[V];
        r = new char[V];
        for(int i=0; i<V; ++i){
            st = new StringTokenizer(br.readLine());
            v1 = st.nextToken().charAt(0);
            v2 = st.nextToken().charAt(0);
            v3 = st.nextToken().charAt(0);
            if(v2 != '.'){
                l[v1-'A'] = v2;
                p[v2-'A'] = v1;
            }
            if(v3 != '.'){
                r[v1-'A'] = v3;
                p[v3-'A'] = v1;
            }
        }
        predfs('A');
        bw.write("\n");
        indfs('A');
        bw.write("\n");
        postdfs('A');
        bw.flush();
        bw.close();


    }
}
