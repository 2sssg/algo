package library;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class UsefulForAlgo {


    ////////////////////////////////bfs/////////////////////////////////////////////
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    private static int swap(int localA, int localB) {return localA;}
    static int rn() throws IOException {return Integer.parseInt(br.readLine());}
    static void est() throws IOException {st = new StringTokenizer(br.readLine());}
    static int rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Integer.parseInt(st.nextToken());}
    static int[] ra() throws IOException {return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();}
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static boolean chk(int x, int y, int n, int m){return x<0 || y<0 || x>=n || y>=m;}
    static class Pair{int x,y;public Pair(int x, int y) {this.x = x;this.y = y;}}
    static class Triple{ int x,y,z;public Triple(int x, int y,int z) {this.x = x;this.y = y;this.z = z;}}
    static class Quad{ int w,x,y,z;public Quad(int w, int x, int y,int z) {this.w = w; this.x = x;this.y = y;this.z = z;}}
    ////////////////////////////////bfs/////////////////////////////////////////////

//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//    StringBuilder sb = new StringBuilder();
//    StringTokenizer st;
//    int rn() throws IOException {return Integer.parseInt(br.readLine());}
//    void est() throws IOException {st = new StringTokenizer(br.readLine());}
//    int rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Integer.parseInt(st.nextToken());}
//    int[] ra() throws IOException {return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();}
//    int[] dx = {-1,0,1,0};
//    int[] dy = {0,-1,0,1};
//    boolean chk(int x, int y, int n, int m){return x<0 || y<0 || x>=n || y>=m;}
//    class Pair{int x,y;public Pair(int x, int y) {this.x = x;this.y = y;}}
//    class Triple{ int x,y,z;public Triple(int x, int y,int z) {this.x = x;this.y = y;this.z = z;}}
//    class Quad{ int w,x,y,z;public Quad(int w, int x, int y,int z) {this.w = w; this.x = x;this.y = y;this.z = z;}}
//

    // 배열 하나 출력
    public static void testPrint(int[] arr){
        System.out.println(Arrays.toString(arr));
        System.out.println();
    }
    public static void testPrint(long[] arr){
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

    public static void testPrint(long[][] arr){
        for(long[] t: arr){
            System.out.println(Arrays.toString(t));
        }
        System.out.println();
    }

    public static void testPrint(char[][] arr){
        for(char[] t: arr){
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
