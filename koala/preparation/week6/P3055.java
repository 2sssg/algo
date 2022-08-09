package koala.preparation.week6;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class P3055 {
	static int n,m;
	static char[][] arr;
	static int[][] wdist;
	static int[][] dist;

	static void init() throws IOException {
		est(); n=rstn(); m=rstn();
		arr = new char[n][m];
		wdist = new int[n][m];
		dist = new int[n][m];
		for(int i=0; i<n; ++i){Arrays.fill(wdist[i],Integer.MAX_VALUE);Arrays.fill(dist[i],-1);}
		for(int i=0; i<n; ++i) arr[i] = br.readLine().toCharArray();
	}

	static void wbfs(){
		Queue<Pair> q = new ArrayDeque<>();
		for(int i=0; i<n; ++i){
			for(int j=0; j<m; ++j){
				if(arr[i][j]=='*'){
					q.add(new Pair(i,j));
					wdist[i][j] = 0;
				}
			}
		}
		while(!q.isEmpty()){
			Pair p = q.poll();
			for(int i=0; i<4; ++i){
				int nx = p.x+dx[i];
				int ny = p.y+dy[i];
				if(chk(nx,ny,n,m)) continue;
				if(arr[nx][ny] == 'X' || arr[nx][ny] == 'D' || wdist[nx][ny] != -1) continue;
				q.add(new Pair(nx,ny));
				wdist[nx][ny] = wdist[p.x][p.y]+1;
			}
		}
	}

	static String bfs(){
		Queue<Pair> q = new ArrayDeque<>();
		for(int i=0; i<n; ++i){
			for(int j=0; j<m; ++j){
				if(arr[i][j]=='S'){
					q.add(new Pair(i,j));
					dist[i][j] = 0;
				}
			}
		}

		while(!q.isEmpty()){
			Pair p = q.poll();
			int cd = dist[p.x][p.y];
			for(int i=0; i<4; ++i){
				int nx = p.x+dx[i];
				int ny = p.y+dy[i];
				if(chk(nx,ny,n,m)) continue;
				if(arr[nx][ny]=='D') return String.valueOf(dist[p.x][p.y]+1);
				if(arr[nx][ny] == 'X' || dist[nx][ny] != -1) continue;
				if(wdist[nx][ny] <= cd+1) continue;
				q.add(new Pair(nx,ny));
				dist[nx][ny] = cd+1;
			}
		}
		return "KAKTUS";
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		init();
		wbfs();
		System.out.println(bfs());
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() {return Integer.parseInt(st.nextToken());}
	static int[] ra() throws IOException {return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();}
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static boolean chk(int x, int y, int n, int m){return x<0 || y<0 || x>=n || y>=m;}
	static class Pair{int x,y;public Pair(int x, int y) {this.x = x;this.y = y;}}
}
