package barkingdog.x09;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P6593 {
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

    static int height,row,col,nx,ny,nz,ans;
    static int[][][] dist;
    static char[][][] map;
    static String onerow;
    static Triple t;

    static int[] dx = {1,-1,0,0,0,0};
    static int[] dy = {0,0,1,0,-1,0};
    static int[] dz = {0,0,0,1,0,-1};

    static void est() throws IOException {st = new StringTokenizer(br.readLine());}
    static int rstn() throws IOException{return Integer.parseInt(st.nextToken());}
    static void makeMap() throws IOException {
        q.clear();
        for(int i=0; i<height; i++){
            for(int j=0; j<row; j++){
                Arrays.fill(dist[i][j],-1);
                onerow = br.readLine();
                for(int k=0; k<col; k++){
                    map[i][j][k] = onerow.charAt(k);
                    if(map[i][j][k] == 'S'){
                        q.add(new Triple(i,j,k));
                        dist[i][j][k] = 0;
                    }
                }
            }
            br.readLine();
        }
    }
    static int bfs(){
        while(!q.isEmpty()){
            t = q.poll();
            for(int i=0; i<6; i++){
                nx = t.x+dx[i];
                ny = t.y+dy[i];
                nz = t.z+dz[i];
                if(nx<0 || ny<0 || nz<0 || nx>=height || ny >=row || nz>=col) continue;
                if(map[nx][ny][nz] == 'E') return dist[t.x][t.y][t.z] + 1;
                if(map[nx][ny][nz] == '.' && dist[nx][ny][nz] < 0){
                    q.add(new Triple(nx,ny,nz));
                    dist[nx][ny][nz] = dist[t.x][t.y][t.z] + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        height = 1;
        while(!(height == 0 && row == 0 && col ==0)){
            est();
            height = rstn();row = rstn();col = rstn();
            if(height == 0 && row == 0 && col ==0) break;
            map = new char[height][row][col];
            dist = new int[height][row][col];
            makeMap();
            ans = bfs();
            if(ans==-1) bw.write("Trapped!\n");
            else {
                bw.write("Escaped in ");
                bw.write(String.valueOf(ans));
                bw.write(" minute(s).\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
