package barkingdog.x0C;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P16987 {
    static class Pair{
        int x; // 내구도
        int y; // 무게
        boolean crash;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public void crush(Pair p){
            this.x -= p.y;
            if(this.x<=0) crash = true;
        }
        public void recover(Pair p){
            this.x += p.y;
            if(this.x>0) crash = false;
        }
        @Override
        public String toString() {
            return "Pair{" +
                    "x(내구도)=" + x +
                    ", y(무게)=" + y +
                    '}';
        }
    }
    static void est() throws IOException {st = new StringTokenizer(br.readLine());}
    static int rstn() throws IOException{return Integer.parseInt(st.nextToken());}
    static void func(int depth, int cur){
        if(depth == N){
            tempmax = 0;
            for(int i=0; i<N; ++i){
                if(pairs[i].crash) tempmax++;
            }
            max = Math.max(max,tempmax);
            return;
        }
        for(int i=0; i<N; ++i){
            if(i==cur) continue;
            if(pairs[cur].crash || pairs[i].crash) continue;
            pairs[cur].crush(pairs[i]);
            pairs[i].crush(pairs[cur]);
            func(depth+1, cur+1);
            pairs[cur].recover(pairs[i]);
            pairs[i].recover(pairs[cur]);
        }
        if(depth != 0){
            func(depth+1, cur+1);
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N,max,tempmax;
    static Pair[] pairs;
    public static void main(String[] args) throws IOException {
        est(); N = rstn();
        pairs = new Pair[N];
        for(int i=0; i<N; ++i) {
            est();
            pairs[i] = new Pair(rstn(),rstn());
        }
        func(0,0);
        System.out.println(max);

    }
}
