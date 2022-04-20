package barkingdog.x09;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P7576 {
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
    static int row,col,zerocnt,temptomato,ans;
    static int[][] box,dist;
    static Pair curP;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        box = new int[row+2][col+2];
        dist = new int[row+2][col+2];
        for(int[] i : dist) Arrays.fill(i,-1);
        for(int[] i : box) Arrays.fill(i,-1);


        for(int i=1; i< row+1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<col+1; j++){
                temptomato =Integer.parseInt(st.nextToken());
                box[i][j] = temptomato;
                if(temptomato==0) zerocnt++;
                else if(temptomato == 1){
                    q.add(new Pair(i,j));
                    dist[i][j] = 0;
                }
            }
        }
        while(!q.isEmpty()){
            curP = q.poll();
            for(int i=0; i<4; i++){
                if(box[curP.x + dx[i]][curP.y + dy[i]] == 0 && dist[curP.x + dx[i]][curP.y + dy[i]] == -1){
                    q.add(new Pair(curP.x + dx[i] , curP.y + dy[i]));
                    dist[curP.x + dx[i]][curP.y + dy[i]] = dist[curP.x][curP.y] + 1;
                    ans = Math.max(dist[curP.x][curP.y] + 1, ans);
                    zerocnt--;
                }
            }
        }

        if(zerocnt==0) System.out.println(ans);
        else System.out.println("-1");
    }
}
