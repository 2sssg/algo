package barkingdog.x09;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2206 {
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
            return "Triple{" +
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

    static int row,col,nx,ny;
    static int[][][] dist;
    static int[][] map;
    static Triple t;

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    static void est() throws IOException {st = new StringTokenizer(br.readLine());}
    static int rstn() throws IOException{return Integer.parseInt(st.nextToken());}

    static void makemap() throws IOException {
        est(); row = rstn(); col = rstn();
        map = new int[row][col];
        dist = new int[row][col][2];
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                Arrays.fill(dist[i][j],-1);
            }
            map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }
        q.add(new Triple(0,0,0));
        dist[0][0][0] = 0;
    }
    static int bfs(){
        while(!q.isEmpty()){
            t = q.poll();
            if(t.x == row-1 && ny == col-1) return dist[t.x][t.y][t.z]+1;
            for(int i=0; i<4; i++){
                nx = t.x + dx[i];
                ny = t.y + dy[i];
                if(nx<0 || ny<0 || nx>=row || ny >=col) continue;
                if(nx == row-1 && ny == col-1) return dist[t.x][t.y][t.z] + 2;
                if(map[nx][ny] == 0){
                    q.add(new Triple(nx,ny,t.z));
                    dist[nx][ny][t.z] = dist[t.x][t.y][t.z] + 1;
                }else if(t.z == 0){
                    q.add(new Triple(nx,ny,1));
                    dist[nx][ny][1] = dist[t.x][t.y][0] + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        makemap();
        System.out.println(bfs());
    }
}
