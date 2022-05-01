package barkingdog.x0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P12100 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Deque<Integer> q = new ArrayDeque<>();

    static int rn() throws IOException {return Integer.parseInt(br.readLine());}
    static void est() throws IOException {st = new StringTokenizer(br.readLine());}
    static int rstn() throws IOException{return Integer.parseInt(st.nextToken());}

    static void func(int depth,int dir){
        if(depth == 5){
            int temp = dir;
            for(int i=0; i<N; i++){
                arr[i] = usearr[i].clone();
            }
//            System.out.println("초기값?");
//            for(int j=0; j<N; ++j){
//                System.out.println(Arrays.toString(arr[j]));
//            }
//            System.out.println();
            for(int i=0; i<5; ++i){
                push(temp%4);
//                for(int j=0; j<N; ++j){
//                    System.out.println(Arrays.toString(arr[j]));
//                }
                temp /= 4;
            }
//            for(int i=0; i<N; ++i){
//                System.out.println(Arrays.toString(arr[i]));
//            }
//            System.out.println();
            for(int i=0; i<N; ++i){
                for(int j=0; j<N; ++j){
                    max = Math.max(max,arr[i][j]);
                }
            }
//            System.out.println(max);
            return;
        }
        for(int i=0; i<4; ++i){
            func(depth+1, dir+((1<<(depth*2))*i));
        }
    }
    static void push(int dir){
//        System.out.print(dir);
        switch(dir){
            case 0:
                up();
                break;
            case 1:
                right();
                break;
            case 2:
                down();
                break;
            case 3:
                left();
                break;
        }
    }

    static void left(){
        int cur;
        for(int i=0; i<N; ++i){
            cur = 0;
            Arrays.fill(temparr,0);
            for(int j=0; j<N; ++j){
                if(arr[i][j]==0) continue;
                if(temparr[cur] == 0) temparr[cur] = arr[i][j];
                else if(temparr[cur] == arr[i][j]) temparr[cur++] *= 2;
                else temparr[++cur] = arr[i][j];
            }
            arr[i] = temparr.clone();
        }
    }
    static void right(){
        int cur;
        for(int i=0; i<N; ++i){
            cur = N-1;
            Arrays.fill(temparr,0);
            for(int j=N-1; j>=0; --j){
                if(arr[i][j]==0) continue;
                if(temparr[cur] == 0) temparr[cur] = arr[i][j];
                else if(temparr[cur] == arr[i][j]) temparr[cur--] *= 2;
                else temparr[--cur] = arr[i][j];
            }
            arr[i] = temparr.clone();
        }
    }
    static void up(){
        int cur;
//        System.out.println("up");
        for(int i=0; i<N; ++i){
            cur = 0;
            Arrays.fill(temparr,0);
            for(int j=0; j<N; ++j){
                if(arr[j][i]==0) continue;
                if(temparr[cur] == 0) temparr[cur] = arr[j][i];
                else if(temparr[cur] == arr[j][i]) {
                    temparr[cur] = temparr[cur] * 2;
                    cur++;
                }
                else temparr[++cur] = arr[j][i];
            }
            for(int j=0; j<N; ++j){
                arr[j][i] = temparr[j];
            }
        }
    }
    static void down(){
        int cur;
        for(int i=0; i<N; ++i){
            cur = N-1;
            Arrays.fill(temparr,0);
            for(int j=N-1; j>=0; --j){
                if(arr[j][i]==0) continue;
                if(temparr[cur] == 0) temparr[cur] = arr[j][i];
                else if(temparr[cur] == arr[j][i]) temparr[cur--] *= 2;
                else temparr[--cur] = arr[j][i];
            }
            for(int j=N-1; j>=0; --j){
                arr[j][i] = temparr[j];
            }
        }
    }
    static int N,cnt,max;
    static int[][] arr,usearr;
    static int[] temparr;

    public static void main(String[] args) throws IOException {
        N = rn();
        arr = new int[N][N];
        usearr = new int[N][N];
        temparr = new int[N];
        for(int i=0; i<N; ++i) usearr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//        for(int j=0; j<N; ++j){
//            System.out.println(Arrays.toString(usearr[j]));
//        }
        func(0,0);
        System.out.println(max);
    }
}

//10
//16 16 8 32 32 0 0 8 8 8
//16 0 0 0 0 8 0 0 0 16
//0 0 0 0 0 0 0 0 0 2
//0 0 0 0 0 0 0 0 0 0
//0 0 0 0 0 0 0 0 0 0
//0 0 0 0 0 0 0 0 0 0
//0 0 0 0 0 0 0 0 0 0
//0 0 0 0 0 0 0 0 0 0
//0 0 0 0 0 0 0 0 0 0
//0 0 0 0 0 0 0 0 0 0

//5
//2 2 4 8 16
//0 0 0 0 0
//0 0 0 0 0
//0 0 0 0 0
//2 2 4 8 16

//7
//2 2 2 2 2 2 2
//2 0 2 2 2 2 2
//2 0 2 2 2 2 2
//2 0 2 2 2 2 2
//2 2 2 0 2 2 2
//2 2 2 2 2 2 0
//2 2 2 2 2 2 0