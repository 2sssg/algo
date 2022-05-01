package barkingdog.x0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P18808 {
    static class Pair{
        int x; int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Queue<Pair> q = new LinkedList<>();


    static void est() throws IOException {st = new StringTokenizer(br.readLine());}
    static int rstn() throws IOException{return Integer.parseInt(st.nextToken());}
    static void func(){
        for(int dir=0; dir<4; ++dir){
            l: for(int i=0; i<srow; ++i){
                for(int j=0; j<scol; ++j){
                    if(sticker[i][j] == 1){
                        p = new Pair(i,j);
                        break l;
                    }
                }
            }

            for(int i=0; i<row; ++i){
                for(int j=0; j<col; ++j){
                    if(bfs(i,j)){
                        copy(i,j);
                        return;
                    }
                }
            }
            rotate();
        }

    }

    static boolean bfs(int x, int y){
        for(int i=0; i<srow; ++i) Arrays.fill(stickerVisit[i],0);
        q.clear();
        q.add(p);
        stickerVisit[p.x][p.y] = 1;

        while(!q.isEmpty()){
            bfsP = q.poll();
            if(x+bfsP.x<0 || x+bfsP.x>= row || y+bfsP.y<0 || y+bfsP.y>=col) return false;
            if(arr[x+bfsP.x][y+bfsP.y] == 1) return false;
            for(int i=0; i<4; ++i){
                nx = bfsP.x+dx[i];
                ny = bfsP.y+dy[i];
                if(chk(nx,ny)) continue;
                if(sticker[nx][ny] == 1 && stickerVisit[nx][ny] == 0){
                    q.add(new Pair(nx,ny));
                    stickerVisit[nx][ny] = 1;
                }
            }
        }
        return true;
    }
    static boolean chk(int nx,int ny){
        return nx<0 ||ny<0 || nx>=srow || ny>= scol;
    }
    static void copy(int x, int y){
        q.clear();
        for(int i=0; i<srow; ++i) Arrays.fill(stickerVisit[i],0);
        q.add(p);
        stickerVisit[p.x][p.y] = 1;

        while(!q.isEmpty()){
            bfsP = q.poll();
            arr[x+bfsP.x][y+bfsP.y] = 1;
            for(int i=0; i<4; ++i){
                nx = bfsP.x+dx[i];
                ny = bfsP.y+dy[i];
                if(chk(nx,ny)) continue;
                if(sticker[nx][ny] == 1 && stickerVisit[nx][ny] == 0){
                    q.add(new Pair(nx,ny));
                    stickerVisit[nx][ny] = 1;
                }
            }
        }
    }
    static void rotate(){
        int temp = srow;
        srow = scol;
        scol = temp;
        int[][] temparr = new int[sticker[0].length][sticker.length];
        stickerVisit =new int[sticker[0].length][sticker.length];
        for(int i=sticker.length-1; i>=0; --i){
            for(int j=0; j<sticker[0].length; ++j){
                temparr[j][sticker.length-1-i] = sticker[i][j];
            }
        }
        sticker = temparr;
    }

    static int row,col,K,srow,scol,nx,ny;
    static int[][] arr,sticker,stickerVisit;
    static Pair p,bfsP;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        est(); row = rstn(); col = rstn(); K = rstn();
        arr = new int[row][col];
        while(K-->0){
            est(); srow = rstn(); scol = rstn();
            sticker = new int[srow][scol];
            stickerVisit = new int[srow][scol];
            //스티커 완성
            for(int i=0; i<srow; ++i) sticker[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            func();
        }
        int cnt=0;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; ++j){
                if(arr[i][j]==1) cnt++;
            }
        }
        System.out.println(cnt);
    }
}
