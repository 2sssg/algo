package barkingdog.x19;

import java.io.*;
import java.util.*;

public class P1240 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static HashMap<Integer,Integer>[] adjList;
    static Queue<Integer> q = new ArrayDeque<>();

    static int N,M,v1,v2,dist;
    static int[] distance;

    static void bfs(int cur,int find){
        q.clear();
        q.add(cur);
        distance[cur] = 0;


        while(!q.isEmpty()){
            cur = q.poll();
            if(cur == find) return;
            for(Map.Entry<Integer,Integer> en : adjList[cur].entrySet()){
                if(distance[en.getKey()]==-1){
                    q.add(en.getKey());
                    distance[en.getKey()] = distance[cur]+en.getValue();
                }
            }
        }


    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adjList = new HashMap[N+1];

        distance = new int[N+1];
        for(int i=1; i<=N; ++i)
            adjList[i] = new HashMap<>();

        for(int i=0; i<N-1; ++i){
            st = new StringTokenizer(br.readLine());
            v1 = Integer.parseInt(st.nextToken());
            v2 = Integer.parseInt(st.nextToken());
            dist = Integer.parseInt(st.nextToken());
            adjList[v1].put(v2,dist);
            adjList[v2].put(v1,dist);
        }

        for(int i=0; i<M; ++i){
            Arrays.fill(distance,-1);
            st = new StringTokenizer(br.readLine());
            v1 = Integer.parseInt(st.nextToken());
            v2 = Integer.parseInt(st.nextToken());
            bfs(v1,v2);
            bw.write(String.valueOf(distance[v2]));
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}

