package barkingdog.x18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class P5567 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Queue<Integer> q = new ArrayDeque<>();

    static int V,E,ans;
    static int[][] arr;
    static int[] visit;
    public static void main(String[] args) throws IOException {
        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());
        arr = new int[V+1][V+1];
        visit = new int[V+1];
        for(int i=0; i<E; ++i){
            st = new StringTokenizer(br.readLine());
            int temp1,temp2;
            temp1 = Integer.parseInt(st.nextToken());
            temp2 = Integer.parseInt(st.nextToken());
            arr[temp1][temp2] = 1;
            arr[temp2][temp1] = 1;
        }
        Arrays.fill(visit,-1);
//        for(int i=0; i<V+1; ++i){
//            System.out.println(Arrays.toString(arr[i]));
//        }
        q.add(1); visit[1] = 0;
        while(!q.isEmpty()){
            int cur = q.poll();
            ans++;
            if(visit[cur]>1) continue;
            for(int i=1; i<V+1; ++i){
                if(arr[cur][i]==1&& visit[i]<0){
                    visit[i] = visit[cur]+1;
                    q.add(i);
                }
            }
        }
        System.out.println(ans-1);

    }
}
