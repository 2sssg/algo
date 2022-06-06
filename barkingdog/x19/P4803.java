package barkingdog.x19;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P4803 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static List<Integer>[] adjList;
    static int[] parentArray;
    static boolean[] visit;

    static int V,E,v1,v2,ans;
    static boolean dfs(int cur){
        if(visit[cur]) return false;
        visit[cur] = true;
        for(int child: adjList[cur]){
            if(child==parentArray[cur]) continue;
            parentArray[child] = cur;
            if(!dfs(child)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        int casecount = 0;
        while(true){
            casecount++;
            ans = 0;
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            if(V==0 && E==0) break;
            adjList = new ArrayList[V+1];
            visit = new boolean[V+1];
            parentArray = new int[V+1];
            for(int i=1; i<=V; ++i)
                adjList[i] = new ArrayList<>();

            for(int i=0; i<E; ++i){
                st = new StringTokenizer(br.readLine());
                v1 = Integer.parseInt(st.nextToken());
                v2 = Integer.parseInt(st.nextToken());
                adjList[v1].add(v2);
                adjList[v2].add(v1);
            }
            for(int i=1; i<=V; ++i){
                if(visit[i]) continue;
                if(dfs(i)) ans++;
            }
            bw.write("Case ");
            bw.write(String.valueOf(casecount));
            bw.write(": ");

            if(ans>1){
                bw.write("A forest of ");
                bw.write(String.valueOf(ans));
                bw.write(" trees.\n");
            }else if(ans == 1){
                bw.write("There is one tree.\n");
            }else{
                bw.write("No trees.\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
