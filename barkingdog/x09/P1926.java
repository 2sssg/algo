package barkingdog.x09;

import java.awt.Point;
import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1926 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Queue<Point> q = new LinkedList<>();
    static StringTokenizer st;
    static int row, col,cnt,maxArea,tempArea;
    static int[][] paper;
    static boolean[][] visited;
    static Point curP;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        paper = new int[row+2][col+2];
        visited = new boolean[row+2][col+2];
        for(int i=1; i<row+1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<col+1; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for(int i=1; i<row+1; i++){
            for(int j=1; j<col+1; j++){
                tempArea = 0;
                if(paper[i][j]==1 && !visited[i][j]){
                    cnt++;
                    q.add(new Point(i,j));
                    visited[i][j] = true;
                }
                while(!q.isEmpty()){
                    curP = q.poll();
                    tempArea++;
                    for(int k=0; k<4; k++){
                        if(paper[curP.x+dx[k]][curP.y+dy[k]] == 1 && !visited[curP.x+dx[k]][curP.y+dy[k]]){
                            q.add(new Point(curP.x+dx[k], curP.y+dy[k]));
                            visited[curP.x+dx[k]][curP.y+dy[k]] = true;
                        }
                    }
                }
                maxArea = Math.max(tempArea,maxArea);

            }
        }
        bw.write(String.valueOf(cnt));
        bw.write("\n");
        bw.write(String.valueOf(maxArea));
        bw.flush();
        bw.close();
    }
}
