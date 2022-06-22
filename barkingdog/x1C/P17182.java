package barkingdog.x1C;

import Constant.Source;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P17182 {
    static class Pair implements Comparable<Pair>{
        int v;
        int w;

        public Pair(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Pair o) {
            return this.w-o.w;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "v=" + v +
                    ", w=" + w +
                    '}';
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PriorityQueue<Pair> q = new PriorityQueue<>();

    static int N,K,ans;
    static int[][] d;
    static boolean[] visit;
    static int[] arr;

    static void f(int cnt,int cur){
        if(cnt == N-1){
//            System.out.println(Arrays.toString(arr));
            ans = Math.min(makeans(),ans);
            return;
        }

        for(int i=0; i<N; ++i){
            if(i==K) continue;
            if(visit[i]) continue;
            arr[cnt] = i;
            visit[i] = true;
            f(cnt+1, cur+1);
            visit[i] = false;
        }

    }

    static int makeans(){
        int ret = d[K][arr[0]];
        for(int i=0; i<N-2; ++i){
            ret += d[arr[i]][arr[i+1]];
        }
        return ret;
    }

    public static void main(String[] args) throws IOException {
        q.clear();
        ans = Integer.MAX_VALUE;
        br = Source.getBufferedReader();
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        d = new int[N][N];
        visit = new boolean[N];
        arr = new int[N-1];
        for(int i=0; i<N; ++i){
            d[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for(int i=0; i<N; ++i){
            for(int j=0; j<N; ++j){
                for(int k=0; k<N; ++k){
                    d[j][k] = Math.min(d[j][k],d[j][i]+d[i][k]);
                }
            }
        }

//        for(int i=0; i<N; ++i){
//            System.out.println(Arrays.toString(d[i]));
//        }
        f(0,0);
        System.out.println(ans);


    }
}
