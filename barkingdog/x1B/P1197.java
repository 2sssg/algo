package barkingdog.x1B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1197 {
    static class Pair implements Comparable<Pair> {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        @Override
        public int compareTo(Pair o) {
            return this.x-o.x;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Pair>[] adjList;
    static PriorityQueue<Pair> q = new PriorityQueue<>();

    static boolean[] chk;
    static int V,E,v1,v2,w;
    public static void main(String[] args) throws IOException {
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

        chk[1] = true;
        q.addAll(adjList[1]);
        long ans = 0;
        int cnt = 0;
        while(!q.isEmpty()){
            Pair p = q.poll();
            if(chk[p.y]) continue;
            ans += p.x;
            if(++cnt == V-1) break;
            chk[p.y] = true;
            for(Pair tempP : adjList[p.y]){
                if(chk[tempP.y]) continue;
                q.add(tempP);
            }
        }
        System.out.println(ans);

    }
}
//5 7
//1 2 4
//2 5 8
//1 4 3
//4 5 6
//1 3 3
//3 5 5
//3 4 3