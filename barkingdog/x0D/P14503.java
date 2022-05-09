package barkingdog.x0D;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P14503 {
    static enum DIR{
        북,동,남,서;
    }
    static class Pair{
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static class Robot extends Pair{
        int dir,nx,ny,cnt;
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        int[] seedx = {-1,0,1,0};
        int[] seedy = {0,1,0,-1};

        public Robot(int x, int y, int dir) {
            super(x, y);
            this.cnt = 0;
            this.dir = dir;
            visit[x][y] = 1;
        }
        public boolean makeDirection(){
//            for(int i=0; i<row; ++i){
//                System.out.println(Arrays.toString(visit[i]));
//            }
//            System.out.println();
//            System.out.println(DIR.values()[dir]+"쪽을 보고");
//            System.out.println("( "+x+" , "+y+" ) 청소중");
            for(int i=0; i<4; ++i){
                nx = x + dx[(dir+(3*(i+1)))%4];
                ny = y + dy[(dir+(3*(i+1)))%4];
                if(arr[nx][ny] == 0 && visit[nx][ny]==0){
                    this.cnt++;
                    dir = (dir+(3*(i+1)))&3;
                    x = nx;
                    y = ny;
                    visit[x][y] = 1;
//                    System.out.println(DIR.values()[dir]+"쪽으로 이동합니다.");
                    return true;
                }
            }
            nx = x + dx[(dir+2)&3];
            ny = y + dy[(dir+2)&3];
            if(arr[nx][ny] == 1) return false;
            else{
//                System.out.println("목적지가 보이지 않습니다. 후진합니다.");
                super.x = nx;
                super.y = ny;
                visit[x][y] = 1;
                return true;
            }

        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int row,col;
    static int[][] arr;
    static int[][] visit;

    static void est() throws IOException {st = new StringTokenizer(br.readLine());}
    static int rstn() throws IOException{return Integer.parseInt(st.nextToken());}

    static void cleening(Robot robot){
        for(int i=0; i<4; ++i){

        }
    }

    public static void main(String[] args) throws IOException {
        est();
        arr = new int [row = rstn()][col = rstn()];
        visit = new int[row][col];
        est();
        Robot robot = new Robot(rstn(), rstn(), rstn());
        for(int i=0; i<row; ++i) arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        while(robot.makeDirection()){}
        System.out.println(robot.cnt+1);
    }
}
