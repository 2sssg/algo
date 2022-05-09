package barkingdog.x0D;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class P14500 {
    static class Pair{
        int x; int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Queue<Pair> q = new ArrayDeque<>();

    static int[][] arr;
    static int[][] tetarr = new int[4][4];
    static int[] tetidx = new int[4];
    static int[][] bfsvisit = new int[4][4];
    static int row,col,nx,ny,cx,cy,ans,idx;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] temp = new int[2000][4];

    static int rn() throws IOException {return Integer.parseInt(br.readLine());}
    static void est() throws IOException {st = new StringTokenizer(br.readLine());}
    static int rstn() throws IOException{return Integer.parseInt(st.nextToken());}

    static void makeTetIDX(int depth,int cur){
        if(depth == 4){
//            System.out.println(Arrays.toString(tetidx));
            for(int i=0; i<4; ++i){
                tetarr[tetidx[i]/4][tetidx[i]%4] = 1;
            }
//            for(int i=0; i<4; ++i){
//                System.out.println(Arrays.toString(tetarr[i]));
//            }
//            System.out.println();
            if(bfs(tetidx[0]/4,tetidx[0]&3)) {
//                for(int i=0; i<4; ++i){
//                    System.out.println(Arrays.toString(tetarr[i]));
//                }
//                System.out.println();
                temp[idx++] = tetidx.clone();
            }
//            int tempmax=0;
//            for(int i=0; i<4; ++i){
//                for(int j=0; j<4; ++j){
//                    if(tetarr[i][j] == 1){
//                        tempmax += arr[cx+i][cy+j];
//                    }
//                }
//            }
//            if(tempmax>ans){
//                System.out.println(tempmax);
//                System.out.println("cx = " + cx);
//                System.out.println("cy = " + cy);
//                for(int i=0; i<4; ++i){
//                    System.out.println(Arrays.toString(tetarr[i]));
//                }
//                System.out.println();
//                for(int i=0; i<row; ++i){
//                    System.out.println(Arrays.toString(arr[i]));
//                }
//
//            }
//            ans = Math.max(tempmax,ans);
            for(int i=0; i<4; ++i){
                tetarr[tetidx[i]/4][tetidx[i]%4] = 0;
            }
            return;
        }
        for(int i=cur; i<16; ++i){
            tetidx[depth] = i;
            makeTetIDX(depth+1, i+1);
        }
    }
    static boolean bfs(int x, int y){
        Pair p;
        int cnt=0;
        q.clear();
        for(int i=0; i<4; ++i){
            Arrays.fill(bfsvisit[i],0);
        }
        q.add(new Pair(x,y));
        bfsvisit[x][y] = 1;
        while(!q.isEmpty()){
            p = q.poll();
            cnt++;
            for(int i=0; i<4; ++i){
                nx = p.x + dx[i];
                ny = p.y + dy[i];
                if(nx<0 || ny<0 || ny>=4 || nx >= 4) continue;
                if(tetarr[nx][ny] == 1 && bfsvisit[nx][ny] == 0){
                    q.add(new Pair(nx,ny));
                    bfsvisit[nx][ny] = 1;
                }
            }
        }
//        for(int i=0; i<4; ++i){
//            System.out.println(Arrays.toString(tetarr[i]));
//        }
//        System.out.println(cnt==4);
        return cnt==4;
    }

    public static void main(String[] args) throws IOException {
        est(); row=rstn(); col=rstn();
        arr = new int[row][col];
        for(int i=0; i<row; ++i){
            est();
            for(int j=0; j<col; ++j){
                arr[i][j] = rstn();
            }
        }
        makeTetIDX(0,0);
        int realmax = 0;
        for(int i=0; i<row-3; ++i){
            for(int j=0; j<col-3; ++j){
                for(int k=0; k<idx; k++){
                    int tempmax = 0;
                    for(int num : temp[k]){
                        tempmax += arr[i+(num/4)][j+(num%4)];
                    }
                    realmax = Math.max(tempmax,realmax);
                }
            }
        }
        System.out.println(realmax);
//        for(int i=0; i<row-3; ++i){
//            for(int j=0; j<col-3; ++j){
//                cx = i;
//                cy = j;
//                makeTetIDX(0,0);
//            }
//        }

//        System.out.println(ans);
    }
}
