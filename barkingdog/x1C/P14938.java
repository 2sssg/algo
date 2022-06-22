package barkingdog.x1C;

import Constant.Source;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P14938 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int V,E,R,v1,v2,r;
    static int[] item;
    static int[][] d;
    static void est() throws IOException {st = new StringTokenizer(br.readLine());}
    static int rstn() throws IOException{return Integer.parseInt(st.nextToken());}
    public static void main(String[] args) throws IOException {
        br = Source.getBufferedReader();
        est(); V=rstn(); R=rstn(); E=rstn();
        item = new int[V+1]; d = new int[V+1][V+1];
        est(); for(int i=1; i<=V; ++i) item[i] = rstn();
        for(int i=0; i<=V; ++i){
            Arrays.fill(d[i],100);
        }
        while(E-->0){
            est(); v1 = rstn(); v2 = rstn(); r = rstn();
            d[v1][v2] = r;
            d[v2][v1] = r;
        }



        for(int i=1; i<=V; ++i){
            for(int j=1; j<=V; ++j){
                for(int k=1; k<=V; ++k){
                    d[j][k] = Math.min(d[j][k] , d[j][i]+d[i][k]);
                }
            }
        }
        for(int i=1; i<=V; ++i){
            d[i][i] = 0;
        }
//        for(int i=0; i<V+1; ++i){
//            System.out.println(Arrays.toString(d[i]));
//        }
        int ans = 0;
//        System.out.println(Arrays.toString(item));
        for(int i=1; i<=V; ++i){
            int cur = 0;
            for(int j=1; j<=V; ++j){
                if(d[i][j]<=R){
//                    System.out.println("( "+i+" , "+j+" )");
                    cur += item[j];
                }
            }
//            System.out.println(cur);
            ans = Math.max(ans,cur);
        }

        System.out.println(ans);

    }
}
