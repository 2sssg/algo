package barkingdog.x0D;

import java.io.*;
import java.util.StringTokenizer;

public class P14499 {
    static class Dice{
        private int bottom =0;
        private int right =0;
        private int left=0;
        private int front=0;
        private int back =0;
        private int above=0;
        private int curX;
        private int curY;

        public Dice(int curX, int curY) {
            this.curX = curX;
            this.curY = curY;
        }

        public void east() throws IOException {
            if(chk(curX,curY+1)) return;
            this.curY += 1;
            int temp = right;
            this.right = this.above;
            this.above = this.left;
            this.left = this.bottom;
            this.bottom = temp;
            copy();
        }
        public void west() throws IOException {
            if(chk(curX,curY-1)) return;
            this.curY -= 1;
            int temp = right;
            this.right = this.bottom;
            this.bottom = this.left;
            this.left = this.above;
            this.above = temp;
            copy();
        }
        public void north() throws IOException {
            if(chk(curX-1,curY)) return;
            this.curX -= 1;
            int temp = above;
            this.above = this.back;
            this.back = this.bottom;
            this.bottom = this.front;
            this.front = temp;
            copy();
        }
        public void south() throws IOException {
            if(chk(curX+1,curY)) return;
            this.curX += 1;
            int temp = above;
            this.above = this.front;
            this.front = this.bottom;
            this.bottom = this.back;
            this.back = temp;
            copy();
        }
        private void copy() throws IOException {
            if(arr[this.curX][this.curY] == 0)
                arr[this.curX][this.curY] = this.bottom;
            else{
                this.bottom = arr[this.curX][this.curY];
                arr[this.curX][this.curY] = 0;
            }
            bw.write(String.valueOf(this.above));
            bw.write("\n");
        }
    }
    static boolean chk(int x, int y){
        return x<0|| y<0 || x>=row || y>=col;
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;


    static int rn() throws IOException {return Integer.parseInt(br.readLine());}
    static void est() throws IOException {st = new StringTokenizer(br.readLine());}
    static int rstn() throws IOException{return Integer.parseInt(st.nextToken());}

    static int row, col, x,y,K;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        est(); row = rstn(); col = rstn(); x = rstn(); y = rstn(); K = rstn();
        arr = new int[row][col];
        for(int i=0; i<row; ++i){
            est();
            for(int j=0; j<col; ++j){
                arr[i][j] = rstn();
            }
        }
        Dice dice = new Dice(x,y);
        est();
        while(st.hasMoreTokens()){
            switch(rstn()){
                case 1:
                    //동
                    dice.east();
                    break;
                case 2:
                    //서
                    dice.west();
                    break;
                case 3:
                    //북
                    dice.north();
                    break;
                case 4:
                    //남
                    dice.south();
                    break;
            }
        }
        bw.flush();
        bw.close();
    }
}
