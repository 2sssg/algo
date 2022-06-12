package barkingdog.x1A;

import java.io.*;
import java.util.*;

public class P1005 {
    static class Build{
        int cur;
        int time;
        int starttime;
        int indegree;
        List<Integer> adj;

        public void setStarttime(int starttime) {
            this.starttime = Math.max(this.starttime,starttime);
        }

        public Build(int cur , int time) {
            this.adj = new ArrayList<>();
            this.starttime = -1;
            this.cur = cur;
            this.time = time;
        }
    }
    static class Pair<T,R>{
        T x;
        R y;

        public Pair(T x, R y) {
            this.x = x;
            this.y = y;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static Build[] adjList;
    static Queue<Pair<Integer,Integer>> q = new ArrayDeque<>();

    static int T,N,K,v1,v2,target;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        while(T-->0){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            adjList = new Build[N+1];

            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=N; ++i){
                adjList[i] = new Build(i,Integer.parseInt(st.nextToken()));
            }

            for(int i=0; i<K; ++i){
                st = new StringTokenizer(br.readLine());
                v1 = Integer.parseInt(st.nextToken());
                v2 = Integer.parseInt(st.nextToken());
                adjList[v1].adj.add(v2);
                adjList[v2].indegree++;
            }

            target = Integer.parseInt(br.readLine());

            for(int i=1; i<=N; ++i){
                if(adjList[i].indegree==0){
                    adjList[i].setStarttime(0);
                    q.add(new Pair<>(i,adjList[i].time));
                }
            }

            long ans = 0;
            while(!q.isEmpty()){
                Pair<Integer,Integer> p = q.poll();
                if(p.x==target) {
                    ans = p.y;
                    q.clear();
                    break;
                }
                for(int next : adjList[p.x].adj){
                    adjList[next].setStarttime(p.y);
                    if(--adjList[next].indegree == 0){
                        q.add(new Pair<>(next,adjList[next].starttime+adjList[next].time));
                    }
                }
            }

            bw.write(String.valueOf(ans));
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}
