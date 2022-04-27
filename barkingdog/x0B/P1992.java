package barkingdog.x0B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1992 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int rn() throws IOException {return Integer.parseInt(br.readLine());}
    static boolean chk(int n, int x, int y){
        for(int i=x; i<x+n; i++) for(int j=y; j<y+n; j++) if(arr[x][y]!=arr[i][j]) return false; return true;
    }
    static void cur(int n, int x, int y){
        if(chk(n,x,y)) {
            System.out.print(arr[x][y]);
            return;
        }
        System.out.print("(");
        for(int i=0; i<2; i++){
            for(int j=0; j<2; j++){
                cur(n/2,x+((n/2)*i),y+((n/2)*j));
            }
        }
        System.out.print(")");

    }
    static int N;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        N = rn();
        arr = new int[N][N];
        for(int i=0; i<N; i++) arr[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        cur(N,0,0);
    }
}
