package barkingdog.x0D;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P14890 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N,L;
    static int[][] arr;

    static void est() throws IOException {st = new StringTokenizer(br.readLine());}
    static int rstn() throws IOException{return Integer.parseInt(st.nextToken());}


    static boolean right(int row){
        int[] visit = new int[N];
        Arrays.fill(visit,0);
        for(int i=0; i<N-1; ++i){
            if(arr[row][i] == arr[row][i+1]-1){
                int temp=0;
                for(int j=0; j<L; ++j){
                    if(i-j >= 0 ){
                        if(arr[row][i] == arr[row][i-j] && visit[i-j]==0){
                            visit[i-j] = 1;
                            temp++;
                        }else{
                            for(int k=j; k>0; --k){
                                visit[i-k+1] = 0;
                            }
                            break;
                        }
                    }
                }
                if(temp != L) return false;
            }
            else if(arr[row][i] == arr[row][i+1]+1){
                int temp=0;
                for(int j=1; j<L+1; ++j){
                    if(i+j < N){
                        if(arr[row][i+1] == arr[row][i+j]&& visit[i+j]==0){
                            visit[i+j] = 1;
                            temp++;
                        }else{
                            for(int k=j; k>1; --k){
                                visit[i+k-1] = 0;
                            }
                            break;
                        }
                    }
                }
                if(temp != L) return false;
            }
            else if(arr[row][i] == arr[row][i+1]){
            }
            else return false;
        }
        return true;
    }


    static boolean down(int col){
        int[] visit = new int[N];
        Arrays.fill(visit,0);
        for(int i=0; i<N-1; ++i){
            if(arr[i][col] == arr[i+1][col]-1){
                int temp=0;
                for(int j=0; j<L; ++j){
                    if(i-j >= 0 ){
                        if(arr[i][col] == arr[i-j][col] && visit[i-j]==0){
                            visit[i-j] = 1;
                            temp++;
                        }else{
                            for(int k=j; k>0; --k){
                                visit[i-k+1] = 0;
                            }
                            break;
                        }
                    }
                }
                if(temp != L) return false;
            }
            else if(arr[i][col] == arr[i+1][col]+1){
                int temp=0;
                for(int j=1; j<L+1; ++j){
                    if(i+j < N){
                        if(arr[i+1][col] == arr[i+j][col]&& visit[i+j]==0){
                            visit[i+j] = 1;
                            temp++;
                        }else{
                            for(int k=j; k>1; --k){
                                visit[i+k-1] = 0;
                            }
                            break;
                        }
                    }
                }
                if(temp != L) return false;
            }
            else if(arr[i][col] == arr[i+1][col]){
            }
            else return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        est(); N = rstn(); L = rstn();
        arr = new int[N][N];
        for(int i=0; i<N; ++i){
            est();
            for(int j=0; j<N; ++j){
                arr[i][j] = rstn();
            }
        }
        int cnt = 0;
        for(int i=0; i<N; ++i){
            if(right(i)) cnt++;
            if(down(i)) cnt++;
        }


        System.out.println(cnt);
    }
}
