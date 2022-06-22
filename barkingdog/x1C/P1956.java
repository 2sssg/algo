package barkingdog.x1C;

import Constant.Source;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1956 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[][] d;
    static int V,E,v1,v2,w;
    public static void main(String[] args) throws IOException {
        br = Source.getBufferedReader();
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        d = new int[V][V];
        for(int i=0; i<V; ++i){
            Arrays.fill(d[i],5000000);
        }
        while(E-->0){
            st = new StringTokenizer(br.readLine());
            v1 = Integer.parseInt(st.nextToken());
            v2 = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            d[v1-1][v2-1] = w;
        }
        for(int i=0; i<V; ++i)
            for(int j=0; j<V; ++j)
                for(int k=0; k<V; ++k)
                    d[j][k] = Math.min(d[j][k], d[j][i] + d[i][k]);

        int ans = 5000000;
        for(int i=0; i<V; ++i){
            ans = Math.min(ans,d[i][i]);
        }
        System.out.println(ans==5000000?"-1":ans);


    }
}
