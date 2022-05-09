package barkingdog.x09;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class P3197 {
    static class Pair{
        int X; int Y;
        public Pair(int x, int y) {
            this.X = x;
            this.Y = y;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int MX = 1520;
    static int r, c, lx, ly, cnt;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] vis = new int[MX][MX];
    static int[][] visited = new int[MX][MX];
    static char[][] board = new char[MX][MX];
    static boolean isPossible = false;
    static Queue<Pair> Q = new ArrayDeque<>();
    static Queue<Pair> Q2 = new ArrayDeque<>();
    static Queue<Pair> LQ = new ArrayDeque<>();
    static Queue<Pair> LQ2 = new ArrayDeque<>();
    static boolean OOB(int a, int b){
        return a < 0 || a >= r || b < 0 || b >= c;
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        for(int i = 0; i < r; i++) board[i] = br.readLine().toCharArray();
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(board[i][j] == 'L'){
                    lx = i;
                    ly = j;
                }
                if(board[i][j] != 'X') Q.add(new Pair(i,j));
            }
        }

        LQ.add(new Pair(lx, ly));
        board[lx][ly] = '.';
        vis[lx][ly] = 1;
        while(!isPossible){
            //얼음 녹이기
            while(!Q.isEmpty()){
                Pair cur = Q.peek(); Q.poll();
                visited[cur.X][cur.Y] = 1;
                for(int dir = 0; dir < 4; dir++){
                    int nx = cur.X + dx[dir];
                    int ny = cur.Y + dy[dir];
                    if(OOB(nx, ny) || visited[nx][ny]==1) continue;

                    if(board[nx][ny] == 'X') Q2.add(new Pair(nx, ny));
                    visited[nx][ny] = 1;
                }
            }

            while(!Q2.isEmpty()){
                Pair cur = Q2.peek(); Q2.poll();
                board[cur.X][cur.Y] = '.';
                Q.add(new Pair(cur.X, cur.Y));
            }
            cnt++;

            //백조 찾기
            while(!LQ.isEmpty()){
                Pair cur = LQ.peek(); LQ.poll();
                for(int dir = 0; dir < 4; dir++){
                    int nx = cur.X + dx[dir];
                    int ny = cur.Y + dy[dir];
                    if(OOB(nx, ny) || vis[nx][ny]==1) continue;
                    if(board[nx][ny] == 'X'){
                        vis[nx][ny] = 1;
                        LQ2.add(new Pair(nx, ny));
                        continue;
                    }
                    else if(board[nx][ny] == 'L'){
                        isPossible = true;
                        break;
                    }
                    vis[nx][ny] = 1;
                    LQ.add(new Pair(nx, ny));
                }
            }
            while (!LQ2.isEmpty()){
                Pair cur = LQ2.peek(); LQ2.poll();
                LQ.add(new Pair(cur.X, cur.Y));
            }
        }
        System.out.println(cnt);
    }
}
