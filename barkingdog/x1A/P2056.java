package barkingdog.x1A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2056 {
    static class Schedule{
        int cur;
        int time;

        public Schedule(int cur, int time) {
            this.cur = cur;
            this.time = time;
        }
    }
    static class Work{
        int cur;
        int time;
        int indegree;
        int start;
        List<Integer> adj;

        public void setStart(int start) {
            this.start = Math.max(start,this.start);
        }

        public void setIndegree(int indegree) {
            this.indegree = indegree;
        }

        public void setTime(int time) {
            this.time = time;
        }

        public Work(int cur) {
            this.cur = cur;
            this.start = -1;
            adj = new ArrayList<>();
        }


        @Override
        public String toString() {
            return "Work{" +
                    "cur=" + cur +
                    ", time=" + time +
                    ", indegree=" + indegree +
                    ", adj=" + adj +
                    '}';
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Queue<Schedule> q = new ArrayDeque<>();

    static Work[] adjList;

    static int N,t,size,v;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        adjList = new Work[N+1];
        for(int i=1; i<=N; ++i){
            adjList[i] = new Work(i);
        }
        for(int i=1; i<=N; ++i){
            st = new StringTokenizer(br.readLine());
            t = Integer.parseInt(st.nextToken());
            size = Integer.parseInt(st.nextToken());

            adjList[i].setIndegree(size);
            adjList[i].setTime(t);
            if(size == 0) {
                adjList[i].setStart(0);
                q.add(new Schedule(i, t));
            }

            for(int j=0; j<size; ++j){
                v = Integer.parseInt(st.nextToken());
                adjList[v].adj.add(i);
            }

        }

        int max =0;
        while(!q.isEmpty()){
            Schedule s = q.poll();
            max = Math.max(max,s.time);
            for(int next : adjList[s.cur].adj){
                adjList[next].setStart(s.time);
                if(--adjList[next].indegree == 0){
                    q.add(new Schedule(next,adjList[next].start+adjList[next].time));
                }
            }
        }

        System.out.println(max);




    }
}
