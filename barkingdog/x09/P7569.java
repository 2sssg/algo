package barkingdog.x09;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P7569 {
    static class Triple{
        int x;
        int y;
        int z;
        public Triple(int x, int y,int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "x=" + x +
                    ", y=" + y +
                    ", z=" + z +
                    '}';
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Queue<Triple> q = new LinkedList<>();
    static StringTokenizer st;

    static int row,col,height,state,nx,ny,nz,ans,zerocnt;
    static int[][][] box,dist;
    static int[] dx = {1,0,0,-1,0,0};
    static int[] dy = {0,1,0,0,-1,0};
    static int[] dz = {0,0,1,0,0,-1};
    static Triple t;
//
//    static void display(int[][][] arr){
//        for(int[][] ar : arr){
//            for(int[] a : ar){
//                for(int t: a){
//                    System.out.println(t+" ");
//                }
//                System.out.println();
//            }
//            System.out.println();
//            System.out.println();
//        }
//    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());

        box = new int[height][row][col];
        dist = new int[height][row][col];
        for(int[][] visi : dist) for(int[] vis : visi) Arrays.fill(vis,-1);

        for(int i=0; i<height; i++){
            for(int j=0; j<row; j++){
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<col; k++){
                    state =  Integer.parseInt(st.nextToken());
                    box[i][j][k] = state;
                    if(state == 1) {
                        q.add(new Triple(i,j,k));
                        dist[i][j][k] = 0;
                    }else if(state ==0) zerocnt++;
                }
            }
        }
        while(!q.isEmpty()){
            t = q.poll();

            for(int i=0; i<6; i++){
                nx = t.x+dx[i];
                ny = t.y+dy[i];
                nz = t.z+dz[i];
                if(nx<0 || ny<0 || nz<0 || nx>=height || ny>=row || nz>=col)continue;
                if(box[nx][ny][nz] == 0 && dist[nx][ny][nz] == -1){
                    zerocnt--;
                    q.add(new Triple(nx,ny,nz));
                    dist[nx][ny][nz] = dist[t.x][t.y][t.z] + 1;
                    ans = Math.max(ans,dist[nx][ny][nz]);
                }
            }
        }
        System.out.println(zerocnt!=0?"-1":ans);


    }
}
