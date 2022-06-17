package barkingdog.x1B;

import Constant.Source;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1647 {
    static class Pair implements Comparable<Pair>{
        int w;
        int v;

        public Pair(int w, int v) {
            this.w = w;
            this.v = v;
        }

        @Override
        public int compareTo(Pair o) {
            return this.w-o.w;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "w=" + w +
                    ", v=" + v +
                    '}';
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PriorityQueue<Pair> q = new PriorityQueue<>();
    static List<Pair>[] adjList;

    static int V,E,v1,v2,w;
    static boolean[] chk;
    static Pair p;
    public static void main(String[] args) throws IOException {
        br = Source.getBufferedReader();
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        adjList = new ArrayList[V+1];
        chk = new boolean[V+1];
        for(int i=1; i<=V; ++i)
            adjList[i] = new ArrayList<>();

        for(int i=0; i<E; ++i){
            st = new StringTokenizer(br.readLine());
            v1 = Integer.parseInt(st.nextToken());
            v2 = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            adjList[v1].add(new Pair(w,v2));
            adjList[v2].add(new Pair(w,v1));
        }

        q.add(new Pair(0,1));
        int minusValue = 0;
        int ans = 0;
        int cnt = 0;
        while(cnt<V){
            p = q.poll();
            minusValue = Math.max(minusValue,p.w);
            if(chk[p.v]) continue;
            chk[p.v] = true;
            ans += p.w;
            cnt++;
            for(Pair next: adjList[p.v]){
                if(chk[next.v]) continue;
                q.add(next);
            }
        }

        System.out.println(ans-minusValue);

    }
}
