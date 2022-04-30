package barkingdog.x0C;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P1941 {
    static class Pair{
        int x; int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Queue<Pair> q = new LinkedList<>();
    static void func(int depth, int cur,int scnt){
        if(depth == 7){
            if(scnt>3){
                for(int i=0; i<5; ++i){
                    for (int j=0; j<5; ++j){
                        bfsArray[i][j] = isUsed[i*5+j];
                    }
                }
                if(bfs()) cnt++;
            }
            return;
        }
        for(int i=cur; i<25; ++i){
            if(isUsed[i] == 0){
                isUsed[i] =1;
                if(arr[i/5][i%5] == 18){
                    func(depth+1,i+1,scnt+1);
                }else{
                    func(depth+1,i+1,scnt);
                }
                isUsed[i] = 0;
            }
        }
    }
    static boolean bfs(){
        q.clear();
        for(int i=0;i<5;++i) Arrays.fill(isVisit[i],0);
        Pair p = new Pair(0,0);
        l:for(int i=0; i<5; ++i){
            for(int j=0; j<5; ++j){
               if(bfsArray[i][j]==1){
                   p = new Pair(i,j);
                   break l;
               }
            }
        }
        q.add(p);
        isVisit[p.x][p.y] = 1;
        int ccnt = 0;
        while(!q.isEmpty()){
            ccnt++;
            p = q.poll();
            for(int i=0; i<4; ++i){
                if(p.x+dx[i]<0 || p.y+dy[i]<0 || p.x+dx[i]>=5 || p.y+dy[i]>=5) continue;
                if(isVisit[p.x+dx[i]][p.y+dy[i]]==0&& bfsArray[p.x+dx[i]][p.y+dy[i]]==1){
                    q.add(new Pair(p.x+dx[i], p.y+dy[i]));
                    isVisit[p.x+dx[i]][p.y+dy[i]] = 1;
                }
            }
        }
        return ccnt==7;
    }
    static int cnt;
    static int[][] arr = new int[5][5];
    static int[][] bfsArray = new int[5][5];
    static int[][] isVisit = new int[5][5];
    static int[] isUsed = new int[25];
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        for(int i=0; i<5; ++i) arr[i] = Arrays.stream(br.readLine().split("")).map(p->p.charAt(0)-'A').mapToInt(Integer::intValue).toArray();
        func(0,0,0);
        System.out.println(cnt);
    }
}