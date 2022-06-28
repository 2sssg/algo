package barkingdog.x1D;

import Constant.Source;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class P11779 {
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
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Pair>[] adjList;
    static PriorityQueue<Pair> q = new PriorityQueue<>();

    static int N,M,s,e;
    static int[] d,nxt;
    public static void main(String[] args) throws IOException {
        br = Source.getBufferedReader();
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        adjList = new ArrayList[N+1];
        d = new int[N+1];
        nxt = new int[N+1];

        for(int i=1; i<=N; ++i){
            adjList[i] = new ArrayList<>();
            d[i] = 0x3f3f3f3f;
        }


        while(M-->0){
            st = new StringTokenizer(br.readLine());
            adjList[Integer.parseInt(st.nextToken())]
                    .add(new Pair(
                                    Integer.parseInt(st.nextToken()),
                                    Integer.parseInt(st.nextToken())
                    ));
        }

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        q.add(new Pair(s,0));
        d[s] = 0;
        while(!q.isEmpty()){
            Pair p = q.poll();
            if(d[p.v] != p.w) continue;
            for(Pair next: adjList[p.v]){
                if(d[next.v]>p.w+next.w){
                    q.add(new Pair(next.v,p.w+next.w));
                    d[next.v] = p.w+next.w;
                    nxt[next.v] = p.v;
                }
            }
        }

        System.out.println(d[e]);
        List<Integer> path = new ArrayList<>();
        int cur = e;
        while(cur != s){
            path.add(cur);
            cur = nxt[cur];
        }
        path.add(cur);
        Collections.reverse(path);
        System.out.println(path.size());
        System.out.println(path.toString().replaceAll("[\\[\\],]",""));



    }
}
