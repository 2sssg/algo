package barkingdog.x18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2660 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Queue<Integer> q = new ArrayDeque<>();
    static TreeMap<Integer, List<Integer>> tm = new TreeMap<>();
    static int V;
    static int[][] arr;
    static int[] dist;
    static int v1,v2;
    public static void main(String[] args) throws IOException {
        V = Integer.parseInt(br.readLine());
        arr = new int[V][V];
        dist = new int[V];
        while(true){
            st = new StringTokenizer(br.readLine());
            v1 = Integer.parseInt(st.nextToken());
            v2 = Integer.parseInt(st.nextToken());
            if(v1==-1 && v2==-1) break;
            arr[v1-1][v2-1] = 1;
            arr[v2-1][v1-1] = 1;
        }

        for(int i=0; i<V; ++i){
            q.clear();
            Arrays.fill(dist,-1);
            q.add(i);
            dist[i] = 0;
            int score=0;
            while(!q.isEmpty()){
                int cur = q.poll();
                score = Math.max(score,dist[cur]);
                for(int j=0; j<V; ++j){
                    if(arr[cur][j]==1 && dist[j]==-1){
                        q.add(j);
                        dist[j] = dist[cur] +1;
                    }
                }
            }
            if(tm.containsKey(score)){
                tm.get(score).add(i+1);
            }else{
                List<Integer> temp = new ArrayList<>();
                temp.add(i+1);
                tm.put(score,temp);
            }
        }
        Map.Entry<Integer,List<Integer>> ans = tm.firstEntry();
        System.out.println(ans.getKey()+" "+ans.getValue().size());
        System.out.println(ans.getValue().toString().replaceAll("[\\[\\],]",""));
    }
}
