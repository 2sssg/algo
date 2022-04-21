package barkingdog.x09;

import java.io.*;
import java.util.*;

public class P2667 {
    static class Pair{
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public Pair(String x, String y) {
            this.x = Integer.parseInt(x);
            this.y = Integer.parseInt(y);
        }

    }
    static int rn() throws IOException {
        return Integer.parseInt(br.readLine());
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Queue<Pair> q = new LinkedList<>();
    static List<Integer> l = new ArrayList<>();
    static StringTokenizer st;

    static int N,nx,ny,cnt;
    static int[][] map,visit;
    static Pair p;

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        N = rn();

        map = new int[N][N];
        visit = new int[N][N];

        for(int i=0; i<N; i++) map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j] == 1 && visit[i][j] ==0) {
                    q.add(new Pair(i,j));
                    visit[i][j] = 1;
                }
                cnt = 0;
                while(!q.isEmpty()){
                    p = q.poll();
                    cnt++;
                    for(int k=0; k<4; k++){
                       nx = p.x+dx[k];
                       ny = p.y+dy[k];
                       if(nx<0||ny<0||nx>=N||ny>=N) continue;
                       if(map[nx][ny]==1 && visit[nx][ny] == 0){
                           q.add(new Pair(nx,ny));
                           visit[nx][ny] = 1;
                       }
                    }
                }
                if(cnt!=0) l.add(cnt);
            }
        }
        Collections.sort(l);
        bw.write(String.valueOf(l.size()));
        bw.write("\n");
        for(int i:l){
            bw.write(String.valueOf(i));
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
