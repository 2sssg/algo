package barkingdog.x09;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P4179NEW {
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
    static Queue<Pair> fq = new LinkedList<>();
    static StringTokenizer st;

    static int[][] map,fdist, jdist;
    static int row,col;
    static char[] onerow;
    static Pair p;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    static void display(int[][] arr){
        for(int[] ar : arr){
            for(int a : ar){
                System.out.print(a + " ");
            }
            System.out.println();
        }
        System.out.println("\n\n");
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        map = new int[row][col];
        fdist = new int[row][col];
        jdist = new int[row][col];

        for(int[] i: fdist) Arrays.fill(i,1000000000);
        for(int i=0; i<row; i++){
            onerow = br.readLine().toCharArray();
            for(int j=0; j<col; j++){
                map[i][j] = onerow[j];
                if(onerow[j] == '.'){
                    jdist[i][j] = 0;
                    fdist[i][j] = 1000000000;
                }else if(onerow[j] == 'J'){
                    q.add(new Pair(i,j));
                    jdist[i][j] = 1;
                }else if(onerow[j] == 'F'){
                    fq.add(new Pair(i,j));
                    fdist[i][j] = 1;
                }else{
                    jdist[i][j] = -1;
                    fdist[i][j] = -1;
                }
            }
        }

        while(!fq.isEmpty()){
            p = fq.poll();
            for(int i=0; i<4; i++){
                if(p.x+dx[i]<0 || p.x+dx[i]>=row || p.y+dy[i]<0 || p.y+dy[i]>=col) continue;
                if(fdist[p.x+dx[i]][p.y+dy[i]] == 1000000000){
                    fq.add(new Pair(p.x+dx[i],p.y+dy[i]));
                    fdist[p.x+dx[i]][p.y+dy[i]] = fdist[p.x][p.y] + 1;
                }
            }
        }

//        display(fdist);
        while(!q.isEmpty()){
//            display(jdist);
            p = q.poll();
            for(int i=0; i<4; i++){
                if(p.x+dx[i]<0 || p.x+dx[i]>=row || p.y+dy[i]<0 || p.y+dy[i]>=col) {
                    System.out.println(jdist[p.x][p.y]);
                    System.exit(0);
                }
                if(jdist[p.x+dx[i]][p.y+dy[i]] == 0 && fdist[p.x+dx[i]][p.y+dy[i]] > jdist[p.x][p.y] + 1){
                    q.add(new Pair(p.x+dx[i],p.y+dy[i]));
                    jdist[p.x+dx[i]][p.y+dy[i]] = jdist[p.x][p.y] + 1;
                }
            }
        }
        System.out.println("IMPOSSIBLE");

    }
}
