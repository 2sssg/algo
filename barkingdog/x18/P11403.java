package barkingdog.x18;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class P11403 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Queue<Integer> q = new ArrayDeque<>();

    static int N;
    static int[][] arr;
    static int[] visit;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visit = new int[N];
        for(int i=0; i<N; ++i)
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for(int i=0; i<N; ++i){
            Arrays.fill(visit,0);
            q.clear();
            for(int j=0; j<N; ++j){
                if(arr[i][j]!=1)continue;
                q.add(j);
                visit[j] = 1;
                while(!q.isEmpty()){
                    int cur = q.poll();
                    for(int k=0; k<N; ++k){
                        if(arr[cur][k]==1 && visit[k]==0){
                            visit[k] = 1;
                            q.add(k);
                        }
                    }
                }
            }
            for(int index = 0; index<N; ++index){
                bw.write(String.valueOf(visit[index]));
                bw.write(" ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();

    }
}
