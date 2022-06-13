package barkingdog.x1B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1368 {
    static class Pair implements Comparable<Pair>{
        int w;
        int v;

        public Pair(int w, int v) {
            this.w = w;
            this.v = v;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "w=" + w +
                    ", v=" + v +
                    '}';
        }

        @Override
        public int compareTo(Pair o) {
            return this.w-o.w;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PriorityQueue<Pair> q = new PriorityQueue<>();

    static int[][] adjList;
    static int V;
    static int[] directW;
    static boolean[] chk;
    public static void main(String[] args) throws IOException {
        V = Integer.parseInt(br.readLine());
        adjList = new int[V][V];
        directW = new int[V];
        chk = new boolean[V];

        int minidx=0;
        int minValue = Integer.MAX_VALUE;
        for(int i=0; i<V; ++i){
            directW[i] = Integer.parseInt(br.readLine());
            if(minValue>directW[i]){
                minValue = directW[i];
                minidx = i;
            }
        }


        for(int i=0; i<V; ++i)
            adjList[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        q.add(new Pair(minValue,minidx));

        long ans = 0;
        int cnt=0;
        while(cnt<V){
            Pair p = q.poll();
            if(chk[p.v]) continue;
            cnt++;
            ans += p.w;
            chk[p.v] = true;
            for(int i=0; i<V; ++i){
                if(chk[i]) continue;
                q.add(new Pair(Math.min(directW[i],adjList[p.v][i]),i));
            }
        }
        System.out.println(ans);

    }
}
//4
//1
//1
//1
//1
//0 10 10 10
//10 0 10 10
//10 10 0 10
//10 10 10 0