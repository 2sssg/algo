package barkingdog.x19;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P11725 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static List<Integer>[] adjList;



    static int V,v1,v2;
    static int[] parentArray;
    static boolean[] visit;
    static void dfs(int cur,int parent){
        if(visit[cur]) return;
        visit[cur] = true;
        parentArray[cur] = parent;
        for(int child: adjList[cur]){
            if(child==parent)continue;
            dfs(child,cur);
        }
    }
    public static void main(String[] args) throws IOException {
        V = Integer.parseInt(br.readLine());
        adjList = new ArrayList[V+1];
        parentArray = new int[V+1];
        visit = new boolean[V+1];
        for(int i=1; i<=V; ++i)
            adjList[i] = new ArrayList<>();

        for(int i=1; i<V; ++i){
            st = new StringTokenizer(br.readLine());
            v1 = Integer.parseInt(st.nextToken());
            v2 = Integer.parseInt(st.nextToken());
            adjList[v1].add(v2);
            adjList[v2].add(v1);
        }
        dfs(1,0);
        for(int i=2; i<=V; ++i){
            bw.write(String.valueOf(parentArray[i]));
            bw.write("\n");
        }
        bw.flush();
        bw.close();


    }
}
