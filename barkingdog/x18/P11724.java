package barkingdog.x18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P11724 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Queue<Integer> q = new ArrayDeque<>();

    static List<Integer>[] arr;
    static boolean[] visit;

    static int V,E,v1,v2,curv,ans;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        arr = new ArrayList[V+1];
        visit = new boolean[V+1];
        for(int i=0; i<V+1; ++i) arr[i] = new ArrayList<>();


        for(int i=0; i<E; ++i){
            st = new StringTokenizer(br.readLine());
            v1 = Integer.parseInt(st.nextToken());
            v2 = Integer.parseInt(st.nextToken());
            arr[v1].add(v2);
            arr[v2].add(v1);
        }
        for(int i=1; i<V+1; ++i){
            if(visit[i]) continue;
            q.add(i);
            visit[i] = true;
            ans++;
            while(!q.isEmpty()){
                curv = q.poll();
                for(int v : arr[curv]){
                    if(visit[v]) continue;
                    q.add(v);
                    visit[v] = true;
                }
            }
        }
        System.out.println(ans);

    }
}
