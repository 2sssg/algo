package extra;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1895 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int rn() throws IOException {return Integer.parseInt(br.readLine());}
    static void est() throws IOException {st = new StringTokenizer(br.readLine());}
    static int rstn() throws IOException{return Integer.parseInt(st.nextToken());}
    static int func(int x, int y){
        Arrays.fill(temparr,0);
        int cur = 0;
        for(int i=x; i<x+3; ++i){
            for(int j=y; j<y+3; ++j){
                temparr[cur++] = arr[i][j];
            }
        }
        Arrays.sort(temparr);
        return temparr[4];
    }

    static int row,col,T,ans;
    static int[][] arr;
    static int[] temparr = new int[9];
    public static void main(String[] args) throws IOException {
        est(); row = rstn(); col = rstn();
        arr = new int[row][col];
        for(int i=0; i<row; ++i) arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        T = rn();
        for(int i=0; i<row-2; ++i){
            for(int j=0; j<col-2; ++j){
                if(func(i,j)>=T) ans++;
            }
        }
        System.out.println(ans);
    }
}
