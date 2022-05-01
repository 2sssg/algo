package barkingdog.x0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P15683 {
    static class Pair{
        int x; int y; int direction;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
            this.direction = -1;
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
    static StringTokenizer st;


    static void est() throws IOException {st = new StringTokenizer(br.readLine());}
    static int rstn() throws IOException{return Integer.parseInt(st.nextToken());}
    static void right(Pair p){
        for(int i=p.y; i<col; ++i){
            if(arr[p.x][i]==6)
                break;
            if(arr[p.x][i] == 0) arr[p.x][i] = -1;
        }
    }
    static void under(Pair p){
        for(int i=p.x; i<row; ++i){
            if(arr[i][p.y]==6)
                break;
            if(arr[i][p.y] == 0) arr[i][p.y] = -1;
        }
    }
    static void left(Pair p){
        for(int i=p.y; i>=0; --i){
            if(arr[p.x][i]==6)
                break;
            if(arr[p.x][i] == 0) {
                arr[p.x][i] = -1;
            }
        }
    }
    static void up(Pair p){
        for(int i=p.x; i>=0; --i){
            if(arr[i][p.y]==6)
                break;
            if(arr[i][p.y] == 0){
                arr[i][p.y] = -1;
            }
        }
    }
    static void one(Pair p){
        switch(p.direction){
            case 0:
                right(p);
                break;
            case 1:
                under(p);
                break;
            case 2:
                left(p);
                break;
            case 3:
                up(p);
                break;
        }
    }
    static void two(Pair p){
        switch(p.direction){
            case 0:
                up(p);
                under(p);
                break;
            case 1:
                right(p);
                left(p);
                break;
        }
    }
    static void three(Pair p){
        switch(p.direction){
            case 0:
                up(p);
                right(p);
                break;
            case 1:
                right(p);
                under(p);
                break;
            case 2:
                under(p);
                left(p);
                break;
            case 3:
                left(p);
                up(p);
                break;
        }
    }
    static void four(Pair p){
        switch(p.direction){
            case 0:
                left(p);
                up(p);
                right(p);
                break;
            case 1:
                up(p);
                right(p);
                under(p);
                break;
            case 2:
                right(p);
                under(p);
                left(p);
                break;
            case 3:
                under(p);
                left(p);
                up(p);
                break;
        }
    }
    static void five(Pair p){
        left(p);
        up(p);
        right(p);
        under(p);
    }
    static void func(int depth){
        if(depth == cctvcnt){
            for(int i=0; i<row; ++i){
                for(int j=0; j<col; ++j){
                    if(arr[i][j] == -1)arr[i][j]=0;
                }
            }
            for(int i=0; i<cctvcnt; ++i){
                Pair p = pairs[i];
                switch(arr[p.x][p.y]){
                    case 1:
                        one(p);
                        break;
                    case 2:
                        two(p);
                        break;
                    case 3:
                        three(p);
                        break;
                    case 4:
                        four(p);
                        break;
                    case 5:
                        five(p);
                        break;
                }
            }
            tempcnt =0;
            for(int i=0; i<row; ++i){
                for(int j=0; j<col; ++j){
                    if(arr[i][j] == 0)tempcnt++;
                }
            }
            ans = Math.min(tempcnt,ans);
            return;
        }

        for(int i=0; i<4; ++i){
            if(arr[pairs[depth].x][pairs[depth].y] == 5){
                func(depth+1);
                break;
            }
            if(arr[pairs[depth].x][pairs[depth].y] == 2 && i==1){
                pairs[depth].direction = i;
                func(depth+1);
                pairs[depth].direction = -1;
                break;
            }
            pairs[depth].direction = i;
            func(depth+1);
            pairs[depth].direction = -1;
        }
    }



    static int row,col,cctvcnt,ans,tempcnt;
    static Pair[] pairs = new Pair[8];

    static int[][] arr,iscctv;
    public static void main(String[] args) throws IOException {
        ans = 100;
        est(); row = rstn(); col = rstn();
        arr = new int[row][col];

        for(int i=0; i<row; ++i){
            est();
            for(int j=0; j<col; ++j){
                arr[i][j] = rstn();
                if(arr[i][j]!=0 && arr[i][j] != 6) {
                    pairs[cctvcnt++] = new Pair(i,j);
                }
            }
        }
        func(0);
        System.out.println(ans);

    }
}
