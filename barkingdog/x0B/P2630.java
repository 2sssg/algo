package barkingdog.x0B;

import java.io.*;
import java.util.Arrays;

public class P2630 {
    static class Pair{
        int x;
        int y;

        public void plus(Pair p){
            this.x += p.x;
            this.y += p.y;
        }
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int rn() throws IOException {return Integer.parseInt(br.readLine());}
    static boolean isRight(int row, int col, int n){
        int tmp = arr[row][col];
        for(int i=row; i<row+n; i++){
            for(int j=col; j<col+n; j++){
                if(tmp != arr[i][j]) return false;
            }
        }
        return true;
    }
    static Pair cur(int row, int col, int n){
        if(isRight(row,col,n)) {
            if(arr[row][col] == 0){
                return new Pair(1,0);
            }
            return new Pair(0,1);
        }
        Pair p  = new Pair(0,0);
        p.plus(cur(row,col,n/2));
        p.plus(cur(row+(n/2),col,n/2));
        p.plus(cur(row,col+(n/2),n/2));
        p.plus(cur(row+(n/2),col+(n/2),n/2));
        return p;
    }

    static int N;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        N = rn();
        arr = new int[N][N];
        for(int i=0; i<N; i++) arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Pair p = cur(0,0,N);
        System.out.println(p.x);
        System.out.println(p.y);
    }
}
