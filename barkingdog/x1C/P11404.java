package barkingdog.x1C;

import Constant.Source;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11404 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int V,E,v1,v2,w;
    static int[][] adjList;
    public static void main(String[] args) throws IOException {
        br = Source.getBufferedReader();
        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());
        adjList = new int[V][V];

        for(int i=0; i<V; ++i)
            Arrays.fill(adjList[i],0x3f3f3f3f);
        for(int i=0; i<E; ++i){
            st = new StringTokenizer(br.readLine());
            v1 = Integer.parseInt(st.nextToken())-1;
            v2 = Integer.parseInt(st.nextToken())-1;
            w = Integer.parseInt(st.nextToken());
            adjList[v1][v2] = Math.min(adjList[v1][v2],w);
        }
        for(int i=0; i<V; ++i){
            adjList[i][i] = 0;
        }


        for(int i=0; i<V; ++i){
            for(int s=0; s<V; ++s){
                for(int t=0; t<V; ++t){
                    adjList[s][t] = Math.min(adjList[s][i] + adjList[i][t], adjList[s][t]);
                }
            }
        }
        for(int i=0; i<V; ++i){
            for(int j=0; j<V; ++j){
                if(adjList[i][j] == 0x3f3f3f3f)
                    bw.write("0 ");
                else{
                    bw.write(String.valueOf(adjList[i][j]));
                    bw.write(" ");
                }
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();

    }
}
