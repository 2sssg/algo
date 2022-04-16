package class3;

import java.io.*;
import java.util.StringTokenizer;

public class OrganicCabbage {
    static int[][] arr;
    static boolean[][] flagArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T,M,N,K ,x,y, wormCount;
        // T : 테스트케이스 개수
        // M : 가로
        // N : 세로
        // K : 배추 개수


        T = Integer.parseInt(br.readLine());
        for(int l=0; l<T; l++){
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            arr = new int[M][N];
            flagArr = new boolean[M][N];
            //배추밭 만들기
            for(int i=0; i<K; i++){
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                arr[x][y] = 1;
            }


            wormCount = 0;
            for(int i=0; i<M; i++){
                for(int j=0; j<N; j++){
                    if(arr[i][j]==1 && !flagArr[i][j]){
                        wormCount++;
                        dfs(i,j,M,N);
                    }
                }
            }

            bw.write(String.valueOf(wormCount));
            bw.write("\n");
        }


        bw.flush();
        bw.close();

    }


    public static void dfs(int x, int y, int M, int N){
        flagArr[x][y] = true;
        //상
        if(y-1>=0){
            if(!flagArr[x][y-1] && arr[x][y-1] == 1){
                dfs(x,y-1,M,N);
            }
        }
        //하
        if(y+1<N){
            if(!flagArr[x][y+1] && arr[x][y+1] == 1){
                dfs(x,y+1,M,N);
            }
        }
        //좌
        if(x-1>=0){
            if(!flagArr[x-1][y] && arr[x-1][y] == 1){
                dfs(x-1,y,M,N);
            }
        }
        //우
        if(x+1<M){
            if(!flagArr[x+1][y] && arr[x+1][y] == 1){
                dfs(x+1,y,M,N);
            }
        }
    }
}
