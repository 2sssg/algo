package barkingdog.x1A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2252 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Integer>[] adjList;
    static Queue<Integer> q = new ArrayDeque<>();
    static List<Integer> result= new ArrayList<>();

    static int N,M,v1,v2;
    static int[] indegree;


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N+1];
        indegree = new int[N+1];

        for(int i=1; i<=N; ++i)
            adjList[i] = new ArrayList<>();

        for(int i=0; i<M; ++i){
            st = new StringTokenizer(br.readLine());
            v1 = Integer.parseInt(st.nextToken());
            v2 = Integer.parseInt(st.nextToken());

            indegree[v2]++;
            adjList[v1].add(v2);
        }

        for(int i=1; i<=N; ++i)
            if(indegree[i]==0)
                q.add(i);

        while(!q.isEmpty()){
            int cur = q.poll();
            result.add(cur);
            for(int next: adjList[cur]){
                if(indegree[next]--==1){
                    q.add(next);
                }
            }
        }
        if(result.size()!= N){
            System.out.println("CYCLE EXIST");
        }else{
            System.out.println(result.toString().replaceAll("[\\[\\],]",""));
        }


    }
}
