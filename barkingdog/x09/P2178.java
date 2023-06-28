package barkingdog.x09;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2178 {
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
    static StringTokenizer st;
    static int row, col,ans;
    static int[][] arr,dist;
    static int[] temp;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    static Pair curP;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        arr = new int[row+2][col+2];
        dist = new int[row+2][col+2];

        for(int[] ar: dist) Arrays.fill(ar,-1);
        for(int i=1; i<row+1; i++){
            temp = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            for(int j=1; j<col+1; j++){
                arr[i][j] = temp[j-1];
            }
        }

        q.add(new Pair(1,1));
        dist[1][1] = 1;

        while(!q.isEmpty()){
            curP = q.poll();
            if(curP.x == row && curP.y == col){
                ans = dist[curP.x][curP.y];
                break;
            }

            for(int i=0; i<4; i++){
                int nx = curP.x + dx[i];
                int ny = curP.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= row || ny >= col) continue;
//                if (dist[nx][ny] != 0) continue;
//                if (dist[nx][ny] <= dist[curP.x][curP.y] + curP.w) continue;
                q.add(new Pair(nx, ny));
                dist[nx][ny] = dist[curP.x][curP.y] + 1;
            }

        }
        System.out.println(ans);
    }
}
