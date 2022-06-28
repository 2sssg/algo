package barkingdog.x1D;

import Constant.Source;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1261 {
    static class Pair implements Comparable<Pair>{
        int x;
        int y;
        int crush;

        public Pair(int x, int y, int crush) {
            this.x = x;
            this.y = y;
            this.crush = crush;
        }

        @Override
        public int compareTo(Pair o) {
            return this.crush-o.crush;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int n;
    static int m;
    static int nx;
    static int ny;
    static int[][] arr;
    static int[][] d;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    static boolean chk(int x, int y){
        if(x<0 || y<0 || x>=n || y>= m) return true;
        return false;
    }

    static void distInit(){
        for(int i=0; i<n; ++i)
            Arrays.fill(d[i],Integer.MAX_VALUE);
    }

    static int bfs(){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0,0,0));
        d[0][0] = 0;

        int answer = Integer.MAX_VALUE;
        while(!pq.isEmpty()){
            Pair cur = pq.poll();

            if(cur.x == n-1 && cur.y==m-1)
                answer = Math.min(answer,cur.crush);

            if(d[cur.x][cur.y] != cur.crush) continue;
            for(int i=0; i<4; ++i){
                nx = cur.x+dx[i];
                ny = cur.y+dy[i];
                if(chk(nx,ny)) continue;
                if(arr[nx][ny] == 0){
                    if(d[nx][ny] > cur.crush){
                        pq.add(new Pair(nx,ny,cur.crush));
                        d[nx][ny] = cur.crush;
                    }
                }else{
                    if(d[nx][ny] > cur.crush+1){
                        pq.add(new Pair(nx,ny,cur.crush+1));
                        d[nx][ny] = cur.crush+1;
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        br = Source.getBufferedReader();
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken()); n = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        d = new int[n][m];

        distInit();

        for(int i=0; i<n; ++i)
            arr[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();

        bw.write(String.valueOf(bfs()));
        bw.flush();
//        bw.close();
    }
}
