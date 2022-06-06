package barkingdog.x19;

import java.io.*;
import java.util.*;

public class P14267 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static List<Integer>[] adjList;
//    static int[][] adjList;

    static int[] chingchan;
    static Map<Integer,Integer> temp = new HashMap<>();


//    static List<Integer> makeadjList(int cur){
//        int size = adjList[cur].size();
//        for(int i=0; i<size; ++i){
//            adjList[cur].addAll(makeadjList(adjList[cur].get(i)));
//        }
//        return adjList[cur];
//    }

    static void dfs(int cur){
        chingchan[cur] += weight;
        for(int next: adjList[cur]){
            dfs(next);
        }
    }

    static int N,M,cur,weight;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adjList = new ArrayList[N+1];
//        adjList = new int[N+1][N+1];
        chingchan = new int[N+1];
        for(int i=0; i<=N; ++i)
            adjList[i] = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
//        adjList[0].add(1);
        st.nextToken();
        for(int i=2; i<=N; ++i)
            adjList[Integer.parseInt(st.nextToken())].add(i);

//        System.out.println();
//        for(int i=0; i<=N; ++i){
//            System.out.println(Arrays.toString(adjList[i]));
//        }
//        makeadjList(1);
//        System.out.println(Arrays.toString(adjList));
//        System.out.println(Arrays.toString(adjList2));
        for(int i=0; i<M; ++i){
            st = new StringTokenizer(br.readLine());
            cur = Integer.parseInt(st.nextToken());
            weight = Integer.parseInt(st.nextToken());
            temp.put(cur,temp.getOrDefault(cur,0)+weight);
//            chingchan[cur] += weight;
//            for(int child : adjList[cur]){
//                chingchan[child] += weight;
//            }
        }
        for(Map.Entry<Integer,Integer> en : temp.entrySet()){
            weight = en.getValue();
            dfs(en.getKey());
        }
        for(int i=1; i<=N; ++i){
            bw.write(String.valueOf(chingchan[i]));
            bw.write(" ");
        }
        bw.flush();
        bw.close();
    }
}
