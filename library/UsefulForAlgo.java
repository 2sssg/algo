package library;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class UsefulForAlgo {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    //////////////pair//////////////////////
    static class Pair{
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public Pair(String y, String x) {
            this.x = Integer.parseInt(x);
            this.y = Integer.parseInt(y);
        }
    }

    static class Triple{
        int x;
        int y;
        int z;
        public Triple(int x, int y,int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "x=" + x +
                    ", y=" + y +
                    ", z=" + z +
                    '}';
        }
    }

    static int rn() throws IOException {return Integer.parseInt(br.readLine());}
    static void est() throws IOException {st = new StringTokenizer(br.readLine());}
    static int rstn() throws IOException{return Integer.parseInt(st.nextToken());}

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    // 배열 하나 출력
    public static void testPrint(int[] arr){
        System.out.println(Arrays.toString(arr));
        System.out.println();
    }

    public static void testPrint(int[] arr,int end){
        for(int i=0; i<=end; ++i){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void testPrint(int[] arr,int start,int end){
        for(int i=start; i<=end; ++i){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void testPrint(int[][] arr){
        for(int[] t: arr){
            System.out.println(Arrays.toString(t));
        }
        System.out.println();
    }

    public static void testPrint(int[][] arr, int er, int ec){
        for(int i=0; i<=er; ++i){
            for(int j=0; j<=ec; ++j){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }


}
