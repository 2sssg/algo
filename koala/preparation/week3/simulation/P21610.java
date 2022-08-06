package koala.preparation.week3.simulation;

import static library.UsefulForAlgo.*;
import static Constant.Source.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import static java.util.Arrays.*;

import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P21610 {
	static class Pair{
		int x,y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public void move(int d, int s){
			int directionX = dx[d-1];
			int directionY = dy[d-1];
			directionX *= s;
			directionY *= s;
			this.x += directionX;
			this.y += directionY;
			this.replace();
		}

		private void replace(){
			while(this.x<0)
				this.x = n+this.x;
			while(this.x>=n)
				this.x = this.x-n;
			while(this.y<0)
				this.y = n+this.y;
			while(this.y>=n)
				this.y = this.y-n;
		}

		@Override
		public String toString() {
			return "Pair{" +
				"x=" + x +
				", y=" + y +
				'}';
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n,m;
	static int[][] arr;
	static boolean[][] lastRain;
	static int[] dx = {0,-1,-1,-1,0,1,1,1};
	static int[] dy = {-1,-1,0,1,1,1,0,-1};
	static int[] dx2 = {-1,-1,1,1};
	static int[] dy2 = {-1,1,1,-1};
	static List<Pair> cloud = new ArrayList<>();

	static void init() throws IOException {
		cloud.clear();
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		lastRain = new boolean[n][n];
		arr = new int[n][n];
		for(int i=0; i<n; ++i) arr[i] = stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		cloud.add(new Pair(n-1,0));
		cloud.add(new Pair(n-1,1));
		cloud.add(new Pair(n-2,0));
		cloud.add(new Pair(n-2,1));
	}

	static void oneCycle() throws IOException{
		st = new StringTokenizer(br.readLine());
		int d = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		for(int i=0; i<n; ++i) fill(lastRain[i],false);
//		System.out.println("=============================");
//		System.out.println("default cloud : "+cloud);
		moveCloud(d,s);
//		System.out.println("after move cloud : "+ cloud);
//		System.out.println("before rain");
//		testPrint(arr);
		rain();
//		System.out.println("after rain, before waterCopy");
//		testPrint(arr);
		waterCopyBug();
//		System.out.println("after waterCopy");
//		testPrint(arr);
		makeCloud();
//		System.out.println("after making cloud");
//		testPrint(arr);
//		System.out.println("next clouds : "+ cloud);
//		System.out.println("=============================");

	}

	static void moveCloud(int d, int s) {
		for(Pair c: cloud)
			c.move(d,s);
	}

	static void rain(){
		for(Pair c: cloud){
			arr[c.x][c.y]++;
			lastRain[c.x][c.y] = true;
		}
	}

	static void waterCopyBug(){
		for(Pair c: cloud){
			int cx = c.x;
			int cy = c.y;
			int count = 0;
			for(int i=0; i<4; ++i){
				int nx = cx+dx2[i];
				int ny = cy+dy2[i];
				if(nx<0 || ny<0 || nx>=n || ny>=n) continue;
				if(arr[nx][ny]>0) count++;
			}
			arr[cx][cy] += count;
		}
	}

	static void makeCloud(){
		cloud.clear();
		for(int i=0; i<n; ++i){
			for(int j=0; j<n; ++j){
				if(arr[i][j]<2 || lastRain[i][j]) continue;
				arr[i][j] -= 2;
				cloud.add(new Pair(i,j));
			}
		}
	}

	public static void main(String[] args) throws IOException {
		br = getBufferedReader();
		init();
		while(m-->0) oneCycle();
		System.out.println(stream(arr).flatMapToInt(Arrays::stream).sum());
	}
}
