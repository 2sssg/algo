package barkingdog.x09;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class P10026 {
    static class Pair{
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Queue<Pair> q = new LinkedList<>();
    static Queue<Pair> q2 = new LinkedList<>();

    static int N,row,col,nx,ny, cnt, cnt2;
    static int[][] arr,visited,visited2;
    static char[] temp;
    static char tmp;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static Pair p;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        row = N;
        col = N;

        arr = new int[N][N];
        visited = new int[N][N];
        visited2 = new int[N][N];

        for(int i=0; i<row; i++){
            temp = br.readLine().toCharArray();
            for(int j=0; j<col; j++){
                tmp = temp[j];
                if(tmp == 'R') arr[i][j] = 0;
                else if(tmp =='G') arr[i][j] = 1;
                else arr[i][j] = 2;
            }
        }

        q.add(new Pair(0,0));
        visited[0][0] = 1;
        q2.add(new Pair(0,0));
        visited2[0][0] = 1;


        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(visited[i][j] == 0){
                    q.add(new Pair(i,j));
                    visited[i][j] = 1;
                }
                if(visited2[i][j] == 0){
                    q2.add(new Pair(i,j));
                    visited2[i][j] = 1;
                }

                if(q.size() == 1) cnt++;

                while(!q.isEmpty()){
                    p = q.poll();
                    for(int k=0; k<4; k++){
                        nx = p.x+dx[k];
                        ny = p.y+dy[k];
                        if(nx<0 || nx>=row || ny<0 || ny>=col) continue;
                        if(arr[nx][ny] == arr[p.x][p.y] && visited[nx][ny] == 0){
                            q.add(new Pair(nx,ny));
                            visited[nx][ny] = 1;
                        }
                    }
                }
                if(q2.size() == 1) cnt2++;
                while(!q2.isEmpty()) {
                    p = q2.poll();
                    N = arr[p.x][p.y];
                    for (int k = 0; k < 4; k++) {
                        nx = p.x + dx[k];
                        ny = p.y + dy[k];
                        if (nx < 0 || nx >= row || ny < 0 || ny >= col) continue;
                        if(N == 0 || N ==1){
                            if((arr[nx][ny] == 0 || arr[nx][ny] == 1) && visited2[nx][ny] == 0){
                                q2.add(new Pair(nx, ny));
                                visited2[nx][ny] = 1;
                            }
                        }else{
                            if (arr[nx][ny] == 2 && visited2[nx][ny] == 0) {
                                q2.add(new Pair(nx, ny));
                                visited2[nx][ny] = 1;
                            }
                        }
                    }
                }

            }
        }
        System.out.println(cnt + " " + cnt2);
    }
}
