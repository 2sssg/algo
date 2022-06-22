package extra;

import Constant.Source;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class P14923 {
    static class Pair{
        int x;
        int y;
        boolean crush;

        @Override
        public String toString() {
            return "Pair{" +
                    "x=" + x +
                    ", y=" + y +
                    ", crush=" + crush +
                    '}';
        }

        public Pair(int x, int y, boolean crush) {
            this.x = x;
            this.y = y;
            this.crush = crush;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Queue<Pair> q;


    static int[][] arr;
    static int[][][] dist;
    static int N,M,Hx,Hy,Ex,Ey,nx,ny,cx,cy;
    static boolean cc;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    static int bfs(){
//        for(int i=0; i<N; ++i){
//            for(int j=0; j<M; ++j){
//                System.out.print(dist[i][j][0] + " ");
//            }
//            System.out.println();
//        }
        q = new ArrayDeque<>();
        q.add(new Pair(Hx,Hy,false));
        dist[Hx][Hy][0] = 0;

        while(!q.isEmpty()){
            Pair p = q.poll();
            cx = p.x;
            cy = p.y;
            cc = p.crush;
//            System.out.println(p);
            if(cx == Ex && cy ==Ey) {
                if(cc){
                    return dist[cx][cy][1];
                }
                return dist[cx][cy][0];
            }
            for(int i=0; i<4; ++i){
                nx = cx+dx[i];
                ny = cy+dy[i];
//                System.out.println("nx : " + nx + ", ny : "+ ny);
                if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
                if(cc){
                    if(arr[nx][ny] == 1) continue;
                    if(dist[nx][ny][1] < 0){
                        dist[nx][ny][1] = dist[cx][cy][1] + 1;
                        q.add(new Pair(nx,ny,true));
                    }
                }else{
                    if(arr[nx][ny] == 1 && dist[nx][ny][1] < 0){
                        q.add(new Pair(nx,ny,true));
                        dist[nx][ny][1] = dist[cx][cy][0] +1;
                        continue;
                    }
                    if(arr[nx][ny] == 0 && dist[nx][ny][0] < 0){
                        q.add(new Pair(nx,ny,false));
                        dist[nx][ny][0] = dist[cx][cy][0] + 1;
                    }

                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        br = Source.getBufferedReader();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Hx = Integer.parseInt(st.nextToken())-1;
        Hy = Integer.parseInt(st.nextToken())-1;
        st = new StringTokenizer(br.readLine());
        Ex = Integer.parseInt(st.nextToken())-1;
        Ey = Integer.parseInt(st.nextToken())-1;

        arr = new int[N][M];
        dist = new int[N][M][2];
        for(int i=0; i<N; ++i){
            for(int j=0; j<M; ++j){
                dist[i][j][0] = -1;
                dist[i][j][1] = -1;
            }
        }

        for(int i=0; i<N; ++i){
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        System.out.println(bfs());

//        for(int i=0; i<N; ++i){
//            for(int j=0; j<M; ++j){
//                System.out.print(dist[i][j][0] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();
//        for(int i=0; i<N; ++i){
//            for(int j=0; j<M; ++j){
//                System.out.print(dist[i][j][1] + " ");
//            }
//            System.out.println();
//        }
    }
}
