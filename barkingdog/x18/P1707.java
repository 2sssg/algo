package barkingdog.x18;

import java.io.*;
import java.util.*;

public class P1707 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static Queue<Integer> q = new ArrayDeque<>();
    static List<Integer>[] adjList = new ArrayList[200001];
    static int[] visit;
    static int T,V,E,v1,v2;

    static boolean dfs(int cur){
        for(int next : adjList[cur]){
            if(visit[next]==0){
                visit[next] = -visit[cur];
                if(!dfs(next)) return false;
            }else if(visit[next] == visit[cur]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for(int i=0; i<20001; ++i) adjList[i] = new ArrayList<>();

        l: while(T-->0){
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            for(int i=1; i<=V; ++i)
                adjList[i].clear();
//            adjList.clear();
//            for(int i=0; i<=V; ++i) adjList.add(new ArrayList<>());
            visit = new int[V+1];
            for(int i=0; i<E; ++i){
                st = new StringTokenizer(br.readLine());
                v1 = Integer.parseInt(st.nextToken());
                v2 = Integer.parseInt(st.nextToken());
                adjList[v1].add(v2);
                adjList[v2].add(v1);
            }
            for(int i=1; i<=V; ++i){
                if(visit[i]!=0) continue;
                visit[i] = 1;
                if(!dfs(i)) {
                    bw.write("NO\n");
                    continue l;
                }
//                q.add(i);
//                visit[i] = 1;
//                while(!q.isEmpty()){
//                    int cur = q.poll();
//                    for(int next : adjList[cur]){
//                        if(visit[next]==0){
//                            q.add(next);
//                            visit[next] = -visit[cur];
//                        }else if(visit[next] == visit[cur]){
//                            bw.write("NO\n");
//                            continue l;
//                        }
//                    }
//                }
            }
            bw.write("YES\n");
        }

        bw.flush();
        bw.close();
    }
}
