package barkingdog.x0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class P11559 {
    static class Pair{
        int x; int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Queue<Pair> q = new ArrayDeque<>();
    static void clearVisitArray(){
        for(int i=0; i<6; ++i){
            for(int j=0; j<12; ++j){
                isVisit[i][j] = 0;
            }
        }
    }
    static boolean chk(int nx, int ny){
        return nx<0 || ny<0 || nx>=6 || ny>=12;
    }
    static boolean bfs(Pair p){
        clearVisitArray();
        q.clear();
        q.add(p);
        isVisit[p.x][p.y] = 1;
        bfscnt = 0;
        while(!q.isEmpty()){
            p = q.poll();
            bfscnt++;
            for(int i=0; i<4; ++i){
                nx = p.x+dx[i];
                ny = p.y+dy[i];
                if(chk(nx,ny)) continue;
                if(arr[nx][ny] == arr[p.x][p.y] && isVisit[nx][ny] == 0){
                    q.add(new Pair(nx,ny));
                    isVisit[nx][ny] = 1;
                }
            }
        }
        if(bfscnt>3){
            for(int i=0; i<6; ++i){
                for(int j=0; j<12; ++j){
                    if(isVisit[i][j]==1) arr[i][j] = 46;
                }
            }
            return true;
        }
        return false;
    }
    static boolean func(){
        boolean tmp = false;
        for(int i=0; i<12; ++i){
            for(int j=0; j<6; ++j){
                if(arr[j][i]!=46) {
                    tmp = bfs(new Pair(j,i)) || tmp;
                }
            }
        }
        tilt();
        return tmp;
    }
    static void tilt(){
        for(int i=0; i<6; ++i){
            Arrays.fill(tiltarr,46);
            cnt = 0;
            for(int j=0; j<12; ++j){
                if(arr[i][j] != 46){
                    tiltarr[cnt++] = arr[i][j];
                }
            }
            arr[i] = tiltarr.clone();
        }
    }
    static int[][] arr = new int[6][12];
    static int[][] isVisit = new int[6][12];
    static char[] row;
    static int[] tiltarr = new int[12];
    static int cnt,nx,ny,bfscnt,ans;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        for(int i=11; i>=0; --i){
            row = br.readLine().toCharArray();
            for(int j=0; j<6; ++j){
                arr[j][i] = row[j];
            }
        }
        while (func()) {
            ans++;
        }
        System.out.println(ans);
    }
}

// . == 46
// R == 82
// G == 71
// B == 66