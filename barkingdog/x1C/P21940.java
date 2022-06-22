package barkingdog.x1C;

import Constant.Source;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P21940 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int V,E,v1,v2,T,K,ans ;
    static int[][] d;
    static int[] friend;
    static List<Integer> l = new ArrayList<>();

    static void est() throws IOException {st = new StringTokenizer(br.readLine());}
    static int rstn() throws IOException{return Integer.parseInt(st.nextToken());}
    public static void main(String[] args) throws IOException {
        br = Source.getBufferedReader();
        l.clear();
        est(); V=rstn(); E=rstn();
        d = new int[V+1][V+1];

        for(int i=1; i<=V; ++i)
            Arrays.fill(d[i],2000);

        while(E-->0){
            est(); v1=rstn(); v2=rstn(); T=rstn();
            d[v1][v2] = T;
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

        K = Integer.parseInt(br.readLine());
        friend = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

//        for(int i=1; i<=V; ++i){
//            for(int j=1; j<=V; ++j){
//                System.out.print(d[i][j]+ " ");
//            }
//            System.out.println();
//        }
        int tempans;
        ans = Integer.MAX_VALUE;
        for(int i=1; i<=V; ++i){
            tempans =0;
            for(int f: friend){
                tempans = Math.max(tempans, d[f][i]+d[i][f]);
            }
//            System.out.println("tempans : "+ tempans);
//            System.out.println("ans : "+ ans);
            if(ans==tempans){
                l.add(i);
            }else if(ans>tempans){
                l.clear();
                l.add(i);
                ans = tempans;
            }
        }
        Collections.sort(l);
        System.out.println(l.toString().replaceAll("[\\[\\],]",""));

    }
}
