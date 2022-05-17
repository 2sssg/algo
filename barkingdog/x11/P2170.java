package barkingdog.x11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class P2170 {
    static class Pair implements Comparable<Pair>{
        int x; int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair o) {
            if(this.x == o.x){
                return this.y-o.y;
            }
            return this.x - o.x;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int rn() throws IOException {return Integer.parseInt(br.readLine());}
    static void est() throws IOException {st = new StringTokenizer(br.readLine());}
    static int rstn(){return Integer.parseInt(st.nextToken());}

    static List<Pair> l = new ArrayList<>();
    static int N,start,end;
    static long ans;
    static boolean isin;
    public static void main(String[] args) throws IOException {
        N = rn();
        while(N-->0){
            est();
            l.add(new Pair(rstn(),rstn()));
        }
        start = 0;
        end = 0;
        Collections.sort(l);
        for(Pair p : l){
            if(start<=p.x && p.x<=end){
                end = Math.max(end,p.y);
            }else{
                ans += end-start;
                start = p.x;
                end = p.y;
            }
        }
        ans += end - start;
        System.out.println(ans);

    }
}
