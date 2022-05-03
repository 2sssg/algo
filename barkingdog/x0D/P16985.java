package barkingdog.x0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class P16985 {
    static class Triple{
        int z; int x; int y;

        public Triple(int z, int x, int y) {
            this.z = z;
            this.x = x;
            this.y = y;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Queue<Triple> q = new ArrayDeque<>();
    static void func(int depth,int val){
        if(depth == 5) {
            copy();
            for(int i=0; i<5; ++i){
                rotate(i,val%4);
                val /= 4;
            }

            Arrays.fill(useper,false);
            Arrays.fill(perArr,0);
            permutation(0,0);

            return;
        }
        for(int i=0; i<4; ++i){
            func(depth + 1, val + i * (1<<(depth*2)));
        }
    }
    // cube -> usecube 싹다 복사하는 함수
    static void copy(){
        for(int i=0; i<5; ++i){
            for(int j=0; j<5; ++j){
                for(int k=0; k<5; ++k){
                    usecube[i][j][k] = cube[i][j][k];
                }
            }
        }
    }
    //한 층을 회전시킴
    static void rotate(int z, int cnt){
        if(cnt == 0) return;
        int[][] temparr = new int[5][5];
        for(int row=0; row<5; ++row){
            for(int col=0; col<5; ++col){
                temparr[col][4-row] = usecube[z][row][col];
            }
        }
        for(int i=0; i<5; ++i){
            usecube[z][i] = temparr[i].clone();
        }
        rotate(z, cnt-1);
    }
    // 층 배치 함수
    static void permutation(int depth,int idx){
        if(depth == 5) {
            sortcube();
            int temp = bfs();
            if(temp != -1) ans = Math.min(ans,temp);
            return;
        }
        for(int i=0; i<5; ++i){
            if(!useper[i]){
                perArr[idx] = i;
                useper[i] = true;
                permutation(depth+1,idx+1);
                useper[i] = false;
            }

        }
    }
    //배치에 맞게 층 바꿔주기
    static void sortcube(){
        int[][][] temparr = new int[5][5][5];
        int cur = 0;
        for(int idx: perArr){ // 3
            for(int i=0; i<5; ++i){
                temparr[cur][i] = usecube[idx][i].clone();
            }
            cur++;
        }
        for(int i=0; i<5; ++i){
            for(int j=0; j<5; ++j){
                realusecube[i][j] = temparr[i][j].clone();
            }
        }
    }

    static int bfs(){
        q.clear();
        for(int i=0; i<5; ++i){
            for(int j=0; j<5; ++j){
                Arrays.fill(visitcube[i][j],-1);
            }
        }
        if(realusecube[0][0][0] == 0 || realusecube[4][4][4] == 0)
                return -1;
        q.add(new Triple(0,0,0));
        visitcube[0][0][0] = 0;
        while(!q.isEmpty()){
            t = q.poll();
            if(t.z == 4 && t.x == 4 && t.y == 4) {
                return visitcube[t.z][t.x][t.y];
            }
            for(int i=0; i<6; ++i){
                nx = t.x+dx[i];
                ny = t.y+dy[i];
                nz = t.z+dz[i];
                if(nx<0 || ny<0 || nz<0 || nx>=5 || ny >=5 || nz >= 5) continue;
                if((realusecube[nz][nx][ny] != 0 && visitcube[nz][nx][ny]==-1)){
                    q.add(new Triple(nz,nx,ny));
                    visitcube[nz][nx][ny] = visitcube[t.z][t.x][t.y] + 1;
                }
            }
        }
        return -1;
    }


    static int[] perArr = new int[5];
    static boolean[] useper = new boolean[5];
    static int[][][] cube = new int[5][5][5];
    static int[][][] usecube = new int[5][5][5];
    static int[][][] realusecube = new int[5][5][5];
    static int[][][] visitcube = new int[5][5][5];
    static Triple t;
    static int nx,ny,nz,ans,tt;
    static int[] dz = {-1,1,0,0,0,0};
    static int[] dx = {0,0,-1,1,0,0};
    static int[] dy = {0,0,0,0,-1,1};
    public static void main(String[] args) throws IOException {
        ans = 2100000000;
        for(int i=0; i<5; ++i){
            for(int j=0; j<5; ++j){
                Arrays.fill(visitcube[i][j],-1);
            }
        }
        for(int i=0; i<5; ++i){
            for(int j=0; j<5; ++j){
                cube[i][j] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
        }
        func(0,0);
        System.out.println(ans==2100000000 ? "-1":ans);
    }
}
