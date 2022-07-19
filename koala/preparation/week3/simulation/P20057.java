package koala.preparation.week3.simulation;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P20057 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] mx = {0,1,0,-1};
	static int[] my = {-1,0,1,0};
	static int[] dx = {-2,-1,-1,-1,0,0,1,1,1,2};
	static int[] dy = {0,-1,0,1,-2,-1,-1,0,1,0};
	static double[] percent = {0.02,0.1,0.07,0.01,0.05,0.00,0.1,0.07,0.01,0.02};
	static int n,answer;
	static int[][] arr,temparr;

	static void init() throws IOException {
		answer = 0;
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		for(int i=0; i<n; ++i) arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
	}

	static void move(){
		int x = n/2, y = n/2;
		int distance = 1;
		int direction = 0;
		outer:while(true){
			for(int i=0; i<distance; ++i){
				x += mx[direction];
				y += my[direction];
				tornado(x,y,direction);
				if(x==0 && y==0) break outer;
			}
			direction = (direction+1)%4;
			if(direction==0 || direction==2) distance++;
		}
	}

	static void tornado(int x, int y,int dir){
		temparr = new int[5][5];
		int cx = 2, cy = 2;
		int sand = 0;
		for(int i=0; i<10; ++i){
			int nx = cx+dx[i];
			int ny = cy+dy[i];
			temparr[nx][ny] = (int)(arr[x][y]*percent[i]);
			sand += temparr[nx][ny];
		}
		temparr[2][1] = arr[x][y]-sand;
		arr[x][y] = 0;
		for(int i=0; i<dir; ++i){
			rotate();
		}
		for(int i=x-2; i<x+3; ++i){
			for(int j=y-2; j<y+3; ++j){
				if(i<0 || j<0 || i>=n || j>=n){
					answer += temparr[i-x+2][j-y+2];
					continue;
				}
				arr[i][j] += temparr[i-x+2][j-y+2];
			}
		}
	}

	static void rotate(){
		int[][] tarr = new int[5][5];
		for(int i=0; i<5; ++i){
			for(int j=0; j<5; ++j){
				tarr[4-j][i] = temparr[i][j];
			}
		}
		for(int i=0; i<5; ++i)
			temparr[i] = tarr[i].clone();
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		init();
		move();
		System.out.println(answer);
	}
}
