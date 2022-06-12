package barkingdog.x1A;

import java.io.*;
import java.util.*;

public class P2637 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static Queue<Integer> q = new ArrayDeque<>();

    static int N,M,X,Y,K;
    static int[] indegree;
    static int[] ans=new int[101];
    static HashMap<Integer,Integer>[] adjList;
    static List<Integer>[] adjList2;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        adjList = new HashMap[N+1];
        adjList2 = new ArrayList[N+1];
        indegree = new int[N+1];
        for(int i=1; i<=N; ++i){
            adjList[i] = new HashMap<>();
            adjList2[i] = new ArrayList<>();
        }

        for(int i=0; i<M; ++i){
            st = new StringTokenizer(br.readLine());
            X = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            adjList[X].put(Y,K);
            adjList2[Y].add(X);
            indegree[X]++;
        }
        for(int i=1; i<=N; ++i){
            if(adjList[i].size()==0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int cur = q.poll();
            if(cur == N){
                break;
            }
            for(int next: adjList2[cur]){
                for(Map.Entry<Integer,Integer> en : adjList[cur].entrySet()){
                    adjList[next].put(en.getKey(),adjList[next].getOrDefault(en.getKey(),0)+adjList[next].get(cur)*en.getValue());
                }
                if(adjList[cur].size()!=0){
                    adjList[next].remove(cur);
                }
                if(--indegree[next]==0){
                    q.add(next);
                }
            }
        }
        for(Map.Entry<Integer,Integer> en : adjList[N].entrySet()){
            ans[en.getKey()] = en.getValue();
        }
        for(int i=1; i<101; ++i){
            if(ans[i]!=0){
                bw.write(String.valueOf(i));
                bw.write(" ");
                bw.write(String.valueOf(ans[i]));
                bw.write("\n");
            }
        }


        bw.flush();
        bw.close();
    }
}
