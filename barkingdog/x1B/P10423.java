package barkingdog.x1B;

import Constant.Source;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P10423 {
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
    static List<Pair>[] adjList ;
    static PriorityQueue<Pair> q = new PriorityQueue<>();
    static StringTokenizer st;


    static int V,E,K,v1,v2,w,cnt,ans;
    static boolean[] chk;

    public static void makeEdge(boolean check){
        Pair p = q.poll();
        if(check){
            if(chk[p.v]) return;
            chk[p.v] = true;
            cnt++;
            ans += p.w;
        }
        for(Pair next: adjList[p.v]){
            if(chk[next.v]) continue;
            q.add(next);
        }
    }

    public static void main(String[] args) throws IOException {
        q.clear();
        br = Source.getBufferedReader();
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        chk = new boolean[V+1];
        adjList = new ArrayList[V+1];
        for(int i=0; i<=V; ++i)
            adjList[i] = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            v1 = Integer.parseInt(st.nextToken());
            q.add(new Pair(v1,0));
            chk[v1] = true;
        }


        for(int i=0; i<E; ++i){
            st = new StringTokenizer(br.readLine());
            v1 = Integer.parseInt(st.nextToken());
            v2 = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            adjList[v1].add(new Pair(v2,w));
            adjList[v2].add(new Pair(v1,w));
        }

        cnt = q.size();

        for(int i=0; i<cnt; ++i){
            makeEdge(false);
        }

        cnt = 0;
        ans = 0;
        while(cnt<V-K){
            makeEdge(true);
        }

        System.out.println(ans);

    }
}
