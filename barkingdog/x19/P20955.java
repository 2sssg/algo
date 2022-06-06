package barkingdog.x19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P20955 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Integer>[] adjList;
    static boolean[] visit;

    static int V,E,v1,v2;

    static int dfs(int cur,int parent){
//        if(parent[cur]>0) return 1;
//        parent[cur] = p;
//        int ans=0;
//        for(int next: adjList[cur]){
//            if(next == p) continue;
//            ans += dfs(next,cur);
//        }
//        return ans;


        if(visit[cur]) return 1;
        int ans = 0;
        visit[cur] = true;
        for(int next: adjList[cur]){
            if(next==parent) continue;
            ans += dfs(next,cur);
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        adjList = new ArrayList[V+1];
        visit = new boolean[V+1];
        for(int i=1; i<=V; ++i)
            adjList[i] = new ArrayList<>();

        for(int i=0; i<E; ++i){
            st = new StringTokenizer(br.readLine());
            v1 = Integer.parseInt(st.nextToken());
            v2 = Integer.parseInt(st.nextToken());
            adjList[v1].add(v2);
            adjList[v2].add(v1);
        }
        int ans=-1;
//        Arrays.fill(parent,-1);
        for(int i=1; i<=V; ++i){
            if(visit[i]) continue;
//            System.out.println(i);
            ans++;
            int temp = dfs(i,0);
            ans += temp/2;
//            System.out.println(temp);
//            System.out.println();
        }
        System.out.println(ans);



    }
}


//10 5
//1 2
//2 3
//3 1
//4 5
//6 7


//10 7
//1 2
//2 3
//3 1
//3 8
//8 9
//4 5
//6 7

//10 8
//1 2
//2 3
//3 1
//3 8
//8 9
//9 1
//4 5
//6 7