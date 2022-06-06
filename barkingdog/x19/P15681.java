package barkingdog.x19;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P15681 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static List<Integer>[] adjList;
    static int[] subtreecount;
    static int[] parent;

    static int N,R,Q,v1,v2;

    static int dfs(int cur){
        int childcnt = 0;
        for(int child: adjList[cur]){
            if(child==parent[cur]) continue;
            childcnt++;
            parent[child] = cur;
            childcnt += dfs(child);
        }
        subtreecount[cur] = childcnt;
        return childcnt;

    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N+1];
        subtreecount = new int[N+1];
        parent = new int[N+1];

        for(int i=1; i<=N; ++i)
            adjList[i] = new ArrayList<>();

        for(int i=1; i<N; ++i){
            st = new StringTokenizer(br.readLine());
            v1 = Integer.parseInt(st.nextToken());
            v2 = Integer.parseInt(st.nextToken());
            adjList[v1].add(v2);
            adjList[v2].add(v1);
        }
        dfs(R);
        for(int i=0; i<Q; ++i){
            bw.write(String.valueOf(subtreecount[Integer.parseInt(br.readLine())]+1));
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
