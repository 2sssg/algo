package barkingdog.x09;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P7562 {
    static class Pair{
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Queue<Pair> q = new LinkedList<>();
    static int[][] dist;
    static StringTokenizer st;
    static int t, I,nx,ny, findX, findY;
    static Pair p;
    static int[] dx = {2,2,-2,-2,1,1,-1,-1};
    static int[] dy = {1,-1,1,-1,2,-2,2,-2};

    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(br.readLine());

        while(t-->0){
            I = Integer.parseInt(br.readLine());
            dist = new int[I][I];
            for(int[] i : dist) Arrays.fill(i,-1);
            st = new StringTokenizer(br.readLine());
            q.add(new Pair(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
            dist[q.peek().x][q.peek().y] = 0;
            st = new StringTokenizer(br.readLine());
            findX = Integer.parseInt(st.nextToken());
            findY = Integer.parseInt(st.nextToken());
            while(!q.isEmpty()){
                p = q.poll();
                if(p.x == findX && p.y == findY){
                    bw.write(String.valueOf(dist[p.x][p.y]));
                    bw.write("\n");
                    q.clear();
                    break;
                }
                for(int i=0; i<8; i++){
                    nx = p.x+dx[i];
                    ny = p.y+dy[i];
                    if(nx<0 || nx >=I || ny<0 ||ny>=I) continue;

                    if(dist[nx][ny] < 0){
                        q.add(new Pair(nx,ny));
                        dist[nx][ny] = dist[p.x][p.y] + 1;
                    }
                }

            }
        }
        bw.flush();
        bw.close();
    }
}
