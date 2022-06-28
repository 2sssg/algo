package barkingdog.x1C;

import Constant.Source;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1719 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int[][] d,root;
    static int V,E,v1,v2,w;
    public static void main(String[] args) throws IOException {
        br = Source.getBufferedReader();
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        d = new int[V][V];
        root = new int[V][V];
        for(int i=0; i<V; ++i){
            Arrays.fill(d[i],0x3f3f3f3f);
            d[i][i] = 0;
        }
        while(E-->0){
            st = new StringTokenizer(br.readLine());
            v1 = Integer.parseInt(st.nextToken())-1;
            v2 = Integer.parseInt(st.nextToken())-1;
            w = Integer.parseInt(st.nextToken());
            d[v1][v2] = w;
            d[v2][v1] = w;
            root[v1][v2] = v2;
            root[v2][v1] = v1;

        }
        for(int i=0; i<V; ++i){
            for(int j=0; j<V; ++j){
                for(int k=0; k<V; ++k){
                    if(d[j][k]>d[j][i]+d[i][k]){
                        d[j][k] = d[j][i]+d[i][k];
                        root[j][k] = root[j][i];
                    }
                }
            }
        }

        for(int i=0; i<V; ++i){
            for(int j=0; j<V; ++j){
                if(i==j){
                    bw.write("- ");
                    continue;
                }
                bw.write(String.valueOf(root[i][j]+1));
                bw.write(" ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
