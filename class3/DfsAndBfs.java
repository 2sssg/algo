package class3;

import java.io.*;
import java.util.*;

public class DfsAndBfs {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st ;
        int[][] graph;
        int[] flag;
        int N,M,V, node1, node2,tmp;
        Stack<Integer> s = new Stack<>();
        Queue<Integer> q = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new int[N+1][N+1];
        flag = new int[N+1];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            node1 = Integer.parseInt(st.nextToken());
            node2 = Integer.parseInt(st.nextToken());

            graph[node1][node2] = 1;
            graph[node2][node1] = 1;
        }
        s.add(V);
        l: while(true){
            if(s.isEmpty()) break;
            while(flag[s.peek()] == 1){
                s.pop();
                if(s.isEmpty()) break l;
            }
            tmp = s.pop();
            flag[tmp] = 1;
            bw.write(String.valueOf(tmp));
            bw.write(" ");
            for(int i=N; i>=0; i--){
                if(graph[tmp][i]==1 && flag[i] != 1){
                    s.push(i);
                }
            }
        }
        bw.write("\n");

        q.add(V);
        Arrays.fill(flag, 0);
        p: while(true){
            if(q.isEmpty()) break;
            while(flag[q.peek()] == 1){
                q.poll();
                if(q.isEmpty()) break p;
            }
            tmp = q.poll();
            flag[tmp] = 1;
            bw.write(String.valueOf(tmp));
            bw.write(" ");
            for(int i=0; i<N+1; i++){
                if(graph[tmp][i]==1 && flag[i] != 1){
                    q.add(i);
                }
            }
        }


        bw.flush();
        bw.close();
        
    }


}
