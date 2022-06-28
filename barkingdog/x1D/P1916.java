package barkingdog.x1D;

import Constant.Source;

import java.io.*;
import java.util.*;

public class P1916 {
    static class Pair implements Comparable<Pair>{
        /*
            v : 정점 ,w : 비용
            정렬을 위해 Comparable implement
         */
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
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return w == pair.w;
        }

        @Override
        public int hashCode() {
            return Objects.hash(v, w);
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static List<Pair>[] d;

    static void adjListInit(int size){
        //    adjList 초기화

        for(int i=0; i<size; ++i)
            d[i] = new ArrayList<>();
    }

    static void makeAdjList(int eSize) throws IOException {
        /*
            adjList 초기 간선 설정해주는 함수
         */
        while(eSize-->0){
            st = new StringTokenizer(br.readLine());
            d[Integer.parseInt(st.nextToken())]
                    .add(new Pair(
                            Integer.parseInt(st.nextToken()),
                            Integer.parseInt(st.nextToken())
                    ));
        }
    }

    static int dijk(int vertexSize,int start, int dest){
        /*
            다익스트라 함수
            argument: 정점 개수, 시작 정점 번호, 목적지 정점 번호
         */

        int[] dist = new int[vertexSize+1];
        Arrays.fill(dist,Integer.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(start,0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Pair cur = pq.poll();
            if(cur.w != dist[cur.v]) continue;
            for(Pair next: d[cur.v]){
                if(dist[next.v] > cur.w+next.w){
                    pq.add(new Pair(next.v, cur.w+next.w));
                    dist[next.v] = cur.w+next.w;
                }
            }
        }
        return dist[dest];
    }
    public static void main(String[] args) throws IOException {
        br = Source.getBufferedReader();
        int v = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());
        d = new ArrayList[v+1];

        adjListInit(v+1);

        makeAdjList(e);

        st = new StringTokenizer(br.readLine());
        int startVertex = Integer.parseInt(st.nextToken());
        int destVertex = Integer.parseInt(st.nextToken());
        int answer = dijk(v,startVertex,destVertex);

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
