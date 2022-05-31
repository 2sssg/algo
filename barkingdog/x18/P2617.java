package barkingdog.x18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P2617 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static List<Integer>[] adjList,adjList2;
    static boolean[] visit;
    static int V,E,v1,v2,ans;


    static int dfs(int cur){
        int ret = 0;
        for(int next : adjList[cur]){
            if(visit[next]) continue;
            ret++;
            visit[next] = true;
            ret += dfs(next);
        }
        return ret;
    }

    static int dfs2(int cur){
        int ret = 0;
        for(int next : adjList2[cur]){
            if(visit[next]) continue;
            ret++;
            visit[next] = true;
            ret += dfs2(next);
        }
        return ret;
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        adjList = new ArrayList[V+1];
        adjList2 = new ArrayList[V+1];
        visit = new boolean[V+1];
        for(int i=0; i<=V; ++i){
            adjList[i] = new ArrayList<>();
            adjList2[i] = new ArrayList<>();
        }


        for(int i=0; i<E; ++i){
            st = new StringTokenizer(br.readLine());
            v1 = Integer.parseInt(st.nextToken());
            v2 = Integer.parseInt(st.nextToken());
            adjList[v1].add(v2);
            adjList2[v2].add(v1);
        }

        for(int i=1; i<=V; ++i){
            Arrays.fill(visit, false);
//            System.out.println("dfs("+i+") : " + dfs(i));
            if(dfs(i)>=(V+1)/2) {
                ans++;
            }
            Arrays.fill(visit, false);
            if(dfs2(i)>=(V+1)/2) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
