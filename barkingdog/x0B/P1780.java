package barkingdog.x0B;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1780 {
    public static class Pair{
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N;
    static int[][] arr;
    static int[] ans = new int[3];
    static int rn() throws IOException {return Integer.parseInt(br.readLine());}
    static void cur(Pair p1, Pair p2){
//        System.out.println("p1 : ( "+p1.x+" , "+p1.y+" )");
//        System.out.println("p2 : ( "+p2.x+" , "+p2.y+" )");
//        System.out.println();
        int val = arr[p1.x-1][p1.y-1];
        for(int i=p1.x-1; i<=p2.x-1; i++){
            for(int j=p1.y-1; j<=p2.y-1;j++){
                if(arr[i][j] != val){
                    int move = (p2.x - p1.x+1)/3;
                    for(int k=0; k<3; k++){
                        for(int l=0; l<3; l++){
                            cur(new Pair(p1.x+(k*move),p1.y+(l*move)),new Pair(p1.x+((k+1)*move)-1,p1.y+((l+1)*move)-1));
                        }
                    }
                    return;
                }
            }
        }
        ans[val+1]++;
    }

    public static void main(String[] args) throws IOException {
        N = rn();
        arr = new int[N][N];
        for(int i=0; i<N; i++) arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        cur(new Pair(1,1),new Pair(N,N));
        for(int i: ans) System.out.println(i);
    }
}
