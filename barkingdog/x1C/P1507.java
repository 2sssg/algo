package barkingdog.x1C;

import Constant.Source;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1507 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    static int N;
    static int[][] d;
    static boolean[][] unused;

    public static void main(String[] args) throws IOException {
        br = Source.getBufferedReader();
        N = Integer.parseInt(br.readLine());
        d = new int[N][N];
        unused = new boolean[N][N];
        for(int i=0; i<N; ++i) {
            d[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

//        for(int[] a: d){
//            System.out.println(Arrays.toString(a));
//        }
        for(int i=0; i<N; ++i){
            for(int j=0; j<N; ++j){
                if(i==j) continue;
                for(int k=0; k<N; ++k){
                    if(i==k) continue;
                    if(j==k) continue;
                    if(d[j][k] == d[j][i]+d[i][k]){
                        unused[j][k] = true;
                    }
                    if(d[j][k]>d[j][i]+d[i][k]){
                        System.out.println("-1");
                        System.exit(0);
                    }
                }
            }
        }
//        System.out.println();
//        for(int[] a: d){
//            System.out.println(Arrays.toString(a));
//        }
        int ans =0;
        for(int i=0; i<N; ++i){
            for(int j=0; j<N; ++j){
                if(!unused[i][j]){
                    ans += d[i][j];
                }
            }
        }
        System.out.println(ans/2);

    }
}
