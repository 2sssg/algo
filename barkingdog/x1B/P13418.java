package barkingdog.x1B;

import Constant.Source;

import java.io.*;
import java.util.*;

public class P13418 {
    static class Pair implements Comparable<Pair>{
        int w;
        int v;

        public Pair(int w, int v) {
            this.w = w;
            this.v = v;
        }


        @Override
        public int compareTo(Pair o) {
            return o.w-this.w;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "w=" + w +
                    ", v=" + v +
                    '}';
        }
    }
//    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedReader br;
    static {
        try {
            br = new BufferedReader(Source.getInputFileReader());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static StringTokenizer st;
    static PriorityQueue<Pair> q = new PriorityQueue<>();
    static PriorityQueue<Pair> q1 = new PriorityQueue<>(Collections.reverseOrder());

    static boolean[] chk;
    static List<Pair>[] adjList;

    static int V,E,v1,v2,w;
    static Pair p ;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        chk = new boolean[V+1];
        adjList = new ArrayList[V+1];
        for(int i=0; i<=V; ++i){
            adjList[i] = new ArrayList<>();
        }

        for(int i=0; i<E+1; ++i){
            st = new StringTokenizer(br.readLine());
            v1 = Integer.parseInt(st.nextToken());
            v2 = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            adjList[v1].add(new Pair(w,v2));
            adjList[v2].add(new Pair(w,v1));
        }
        q.add(new Pair(0,0));
        int cnt = 0;
        int ans = 0;
        while(cnt<V+1){
            p = q.poll();
            if(chk[p.v]) continue;
            if(p.w==0)
                ans++;
            cnt++;
            chk[p.v] = true;
            for(Pair next: adjList[p.v]){
                if(chk[next.v]) continue;
                q.add(next);
            }
        }
        Arrays.fill(chk,false);
        q1.add(new Pair(0,0));
        int cnt1 = 0;
        int ans1 = 0;
        while(cnt1<V+1){
            p = q1.poll();
            if(chk[p.v]) continue;
            if(p.w==0)
                ans1++;
            cnt1++;
            chk[p.v] = true;
            for(Pair next: adjList[p.v]){
                if(chk[next.v]) continue;
                q1.add(next);
            }
        }
        System.out.println((ans1-1)*(ans1-1)-(ans-1)*(ans-1));


    }
}
