package barkingdog.x09;

import java.io.*;
import java.util.*;

public class P2583 {
    static class Pair{
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public Pair(String y, String x) {
            this.x = row-Integer.parseInt(x);
            this.y = Integer.parseInt(y);
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Queue<Pair> q = new LinkedList<>();
    static StringTokenizer st;

    static int row,col,K,ans,nx,ny,cnt;
    static int[][] map,visit;
    static List<Integer> l = new ArrayList<>();
    static Pair ldP, ruP;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[row][col];
        visit = new int[row][col];
        while(K-->0){
            st = new StringTokenizer(br.readLine());
            ldP = new Pair(st.nextToken(),st.nextToken());
            ruP = new Pair(st.nextToken(),st.nextToken());
            for(int i=ruP.x; i<ldP.x; i++){
                for(int j=ldP.y; j<ruP.y; j++){
                    map[i][j] = 1;
                }
            }
        }

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(map[i][j] == 0 && visit[i][j] == 0){
                    ans++;
                    q.add(new Pair(i,j));
                    visit[i][j] = 1;
                }
                cnt = 0;
                while(!q.isEmpty()){
                    ldP = q.poll();
                    cnt++;
                    for(int k=0; k<4; k++){
                        nx = ldP.x + dx[k];
                        ny = ldP.y + dy[k];
                        if(nx<0 || ny<0 || nx>=row || ny>=col) continue;
                        if(map[nx][ny] ==0 && visit[nx][ny] ==0){
                            q.add(new Pair(nx,ny));
                            visit[nx][ny] = 1;
                        }
                    }
                }
                if(cnt!=0){
                    l.add(cnt);
                }
            }
        }

        bw.write(String.valueOf(ans));
        bw.write("\n");
        Collections.sort(l);
        for(int i=0; i<ans; i++) {
            bw.write(String.valueOf(l.get(i).intValue()));
            bw.write(" ");
        }

        bw.flush();
        bw.close();

    }
}
