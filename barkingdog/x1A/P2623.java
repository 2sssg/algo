package barkingdog.x1A;

import java.io.*;
import java.util.*;

public class P2623 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static Queue<Integer> q = new ArrayDeque<>();

    static List<Integer>[] adjList;
    static List<Integer> result = new ArrayList<>();
    static int[] indegree;

    static int N,M,fir,sec;

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
            st.nextToken();
            fir = Integer.parseInt(st.nextToken());
            while(st.hasMoreTokens()){
                sec = Integer.parseInt(st.nextToken());
                indegree[sec]++;
                adjList[fir].add(sec);
                fir = sec;
            }
        }

        for(int i=1; i<=N; ++i){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int cur = q.poll();
            result.add(cur);
            for(int next : adjList[cur]){
                if(indegree[next]--==1){
                    q.add(next);
                }
            }
        }
        if(result.size()==N){
            for(int cur: result){
                bw.write(String.valueOf(cur));
                bw.write("\n");
            }
        }else{
            bw.write("0");
        }



        bw.flush();
        bw.close();
    }
}
