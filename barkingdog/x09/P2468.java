package barkingdog.x09;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2468 {
    static class Pair{
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public Pair(String y, String x) {
            this.x = Integer.parseInt(x);
            this.y = Integer.parseInt(y);
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Queue<Pair> q = new LinkedList<>();
    static StringTokenizer st;
    static int rn() throws IOException {return Integer.parseInt(br.readLine());}

    static int N,ans,nx,ny,cnt;
    static int[][] map,visit;
    static Pair p;

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        N = rn();
        map = new int[N][N];
        visit = new int[N][N];
        for(int i=0; i<N; i++) map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for(int i=0; i<101; i++){
            for(int tmp=0; tmp<N; tmp++) Arrays.fill(visit[tmp],0);

            cnt = 0;
            for(int j=0; j<N; j++){
                for(int k=0; k<N; k++){
                    if(i<map[j][k] && visit[j][k] == 0){
                        cnt++;
                        q.add(new Pair(j,k));
                        visit[j][k] = 1;
                    }

                    while(!q.isEmpty()){
                        p = q.poll();
                        for(int l=0; l<4; l++){
                            nx = p.x+dx[l];
                            ny = p.y+dy[l];
                            if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
                            if(map[nx][ny]>i && visit[nx][ny]==0){
                                q.add(new Pair(nx,ny));
                                visit[nx][ny] = 1;
                            }
                        }
                    }
                }
            }
            ans = Math.max(ans,cnt);
        }
        System.out.println(ans);
    }
}
