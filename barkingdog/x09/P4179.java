package barkingdog.x09;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P4179 {
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
    static void display(){
        for(char[] c: map){
            System.out.println(c);
        }
        System.out.println("\n\n\n");
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Queue<Pair> jq = new LinkedList<>();
    static Queue<Pair> fq = new LinkedList<>();
    static StringTokenizer st;
    static int row, col,ans,d,fqsize,jqsize;
    static char[][] map;
    static int[][] dist;
    static char[] temp;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static Pair jp, fp;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        map = new char[row][col];
        dist = new int[row][col];


        for(int i=0; i<row; i++) {
            temp = br.readLine().toCharArray();
            for(int j=0; j<col; j++){
                map[i][j] = temp[j];
                if(map[i][j] == 'F') {
                    fq.add(new Pair(i,j));
                    dist[i][j] = -1;
                }
                else if(map[i][j] == 'J'){
                    if(i==0 || i==row-1 || j==0 || j==col){
                        System.out.println(1);
                        System.exit(0);
                    }
                    jq.add(new Pair(i,j));
                }
            }
        }
        l: while((!jq.isEmpty())){
            fqsize = fq.size();
            jqsize = jq.size();
            d = dist[jq.peek().x][jq.peek().y];
            for(int j=0; j<fqsize; j++){
                fp = fq.poll();
                for(int i=0; i<4; i++){
                    if(fp.x+dx[i]<0 || fp.x+dx[i]>=row || fp.y+dy[i]<0 || fp.y+dy[i] >= col) continue;
                    if(map[fp.x+dx[i]][fp.y+dy[i]] != '#' && dist[fp.x+dx[i]][fp.y+dy[i]] != -1){
                        fq.add(new Pair(fp.x+dx[i], fp.y+dy[i]));
                        map[fp.x+dx[i]][fp.y+dy[i]] = 'F';
                        dist[fp.x+dx[i]][fp.y+dy[i]] = -1;
                    }
                }
            }

            for(int j=0; j<jqsize; j++){
                jp = jq.poll();
                for(int i=0; i<4; i++){
                    if(jp.x+dx[i]<0 || jp.x+dx[i]>=row || jp.y+dy[i]<0 || jp.y+dy[i] >= col) {
                        ans = d +1;
                        break l;
                    }
                    if(map[jp.x+dx[i]][jp.y+dy[i]] == '.') {
                        jq.add(new Pair(jp.x+dx[i],jp.y+dy[i]));
                        dist[jp.x+dx[i]][jp.y+dy[i]] = d+1;
                    }
                }
            }
        }

        if(ans == 0) System.out.println("IMPOSSIBLE");
        else System.out.println(ans);

    }
}
