package barkingdog.x09;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P5427 {
    static class Pair{
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Queue<Pair> q = new LinkedList<>();
    static StringTokenizer st;

    static int N,row,col,x,y,nx,ny,curX,curY, ans;
    static int[][] visit1, visit2;
    static char[][] map;
    static char[] temp;
    static char tmp;
    static Pair p;

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        l:while(N-->0){
            st = new StringTokenizer(br.readLine());
            col = Integer.parseInt(st.nextToken());
            row = Integer.parseInt(st.nextToken());
            map = new char[row][col];
            visit1 = new int[row][col];
            visit2 = new int[row][col];


            for(int i=0; i<row; i++){
                temp = br.readLine().toCharArray();
                for(int j=0; j<col; j++){
                    visit1[i][j] = -1;
                    visit2[i][j] = -1;
                    tmp = temp[j];
                    map[i][j] = tmp;
                    if(tmp =='@'){
                        x = i;
                        y = j;
                    }else if(tmp == '*'){
                        q.add(new Pair(i,j));
                        visit2[i][j] = 0;
                    }
                }
            }

            while(!q.isEmpty()){
                p = q.poll();
                curX = p.x;
                curY = p.y;
                for(int i=0; i<4; i++){
                    nx = curX + dx[i];
                    ny = curY + dy[i];
                    if(nx<0 || ny<0 || nx>=row || ny>=col) continue;
                    if(map[nx][ny] != '#' && visit2[nx][ny]<0){
                        q.add(new Pair(nx,ny));
                        visit2[nx][ny] = visit2[curX][curY] + 1;
                    }
                }
            }

            q.add(new Pair(x,y));
            visit1[x][y] = 0;
            while(!q.isEmpty()){
                p = q.poll();
                curX = p.x;
                curY = p.y;

//                System.out.println("( " + curX + " , " +curY+ " )");
//                System.out.println("불의 시간 :  " + visit2[curX][curY]);
//                System.out.println("사람의 시간 :  " + visit1[curX][curY]);
                for(int i=0; i<4; i++){
                    nx = curX + dx[i];
                    ny = curY + dy[i];
                    if(nx<0 || ny<0 || nx>=row || ny>=col) {
                        System.out.println(visit1[curX][curY] + 1);
                        q.clear();
                        continue l;
                    }
                    if(map[nx][ny] =='.' && visit1[nx][ny]<0 && (visit2[nx][ny] > visit1[curX][curY] + 1||visit2[nx][ny]<0)){
                        q.add(new Pair(nx,ny));
                        visit1[nx][ny] = visit1[curX][curY] + 1;
                    }

                }
            }
            System.out.println("IMPOSSIBLE");
        }
    }
}
