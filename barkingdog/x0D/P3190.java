package barkingdog.x0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class P3190 {
    static class Pair{
        int x; int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static class Snake extends Pair{
        Pair dir; int sec; int direc; boolean isDie;
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};

        public Snake(int x, int y) {
            super(x, y);
            this.sec = 0;
            this.isDie = false;
            this.direc = 0;
            this.dir = new Pair(dx[this.direc],dy[this.direc]);
        }
        public boolean go(){
            for(int i=0; i<N; ++i){
                System.out.println(Arrays.toString(isSnake[i]));
            }
            System.out.println();
            System.out.println();
            this.sec++;
            if(chk(super.x + dir.x , super.y + dir.y)) {
                this.isDie = true;
                return false;
            }
            super.x += dir.x;
            super.y += dir.y;
            q.add(new Pair(super.x, super.y));
            isSnake[x][y] = 1;
            if(arr[super.x][super.y]!=1){
                isSnake[q.peek().x][q.peek().y] = 0;
                q.poll();
            }else{
                arr[super.x][super.y] = 0;
            }
            return true;
        }
        public boolean chk(int curX, int curY){
            return curX<0 || curY<0 || curX>=N || curY>=N || (isSnake[curX][curY]==1);
        }
        public void changeDirection(String d){
            if(d.equals("D")) {
                this.direc = (this.direc+1)%4;
                dir = new Pair(dx[this.direc], dy[this.direc]);
            }
            else if(d.equals("L")) {
                if(this.direc == 0) this.direc = 3;
                else this.direc--;
                dir = new Pair(dx[this.direc], dy[this.direc]);
            }
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Queue<Pair> q = new ArrayDeque<>();

    static int[][] arr,isSnake;
    static int N,applecnt,dircnt;
    static Snake s = new Snake(0,0);

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        isSnake = new int[N][N];
        applecnt = Integer.parseInt(br.readLine());
        while(applecnt-->0){
            st = new StringTokenizer(br.readLine());
            arr[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 1;
        }
        q.add(new Pair(0,0));
        isSnake[0][0] = 1;
        dircnt = Integer.parseInt(br.readLine());
        l: while(dircnt-->0){
            st = new StringTokenizer(br.readLine());
            int directionChangeTime = Integer.parseInt(st.nextToken());
            String direction = st.nextToken();
            while(directionChangeTime != s.sec){
                if(!s.go()) break l;
            }
            s.changeDirection(direction);
        }
        while(!s.isDie){
            s.go();
        }
        System.out.println(s.sec);
    }
}
