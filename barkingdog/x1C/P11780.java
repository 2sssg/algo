package barkingdog.x1C;

import Constant.Source;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P11780 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static List<Integer> l = new ArrayList<>();

    static int V,E,v1,v2,w;
    static int[][] d,nxt;

    static void printPath(int i, int j) throws IOException {
        int n = nxt[i][j];
        if(n==-1) {
            l.clear();
            return ;
        }
        if(n == j){
            l.add(j+1);
            return;
        }
        l.add(n+1);
        printPath(n,j);
    }
    public static void main(String[] args) throws IOException {
        br = Source.getBufferedReader();
        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());
        d = new int[V][V];
        nxt = new int[V][V];

        for(int i=0; i<V; ++i)
            Arrays.fill(d[i],0x3f3f3f3f);

        for(int i=0; i<V; ++i)
            Arrays.fill(nxt[i],-1);
        for(int i=0; i<E; ++i){
            st = new StringTokenizer(br.readLine());
            v1 = Integer.parseInt(st.nextToken())-1;
            v2 = Integer.parseInt(st.nextToken())-1;
            w = Integer.parseInt(st.nextToken());
            d[v1][v2] = Math.min(d[v1][v2],w);
            nxt[v1][v2] = v2;
        }
        for(int i=0; i<V; ++i){
            d[i][i] = 0;
        }


        for(int i=0; i<V; ++i){
            for(int s=0; s<V; ++s){
                for(int t=0; t<V; ++t){
                    if(d[s][t]>d[s][i]+d[i][t]){
                        d[s][t] = d[s][i] + d[i][t];
                        nxt[s][t] = nxt[s][i];
                    }
                }
            }
        }
        for(int i=0; i<V; ++i){
            for(int j=0; j<V; ++j){
                if(d[i][j] == 0x3f3f3f3f)
                    bw.write("0 ");
                else{
                    bw.write(String.valueOf(d[i][j]));
                    bw.write(" ");
                }
            }
            bw.write("\n");
        }
//        bw.write("\n");
//        for(int i=0; i<V; ++i){
//            bw.write(Arrays.toString(nxt[i]));
//            bw.write("\n");
//        }
//        bw.write("\n");
        for(int i=0; i<V; ++i){
            for(int j=0; j<V; ++j){
                l = new ArrayList<>();
                l.add(i+1);
                printPath(i,j);
                bw.write(String.valueOf(l.size()));
                bw.write(" ");
                bw.write(l.toString().replaceAll("[\\[\\],]",""));
                bw.write("\n");
            }
        }

        bw.flush();
        bw.close();


    }
}
