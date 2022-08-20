package koala.preparation.week7.test;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;
import library.UsefulForAlgo;

public class P25307 {
	// 0: 아무것도없음
	// 1: 기둥 : 못가는 칸
	// 2: 의자 : 가야되는 칸
	// 3: 마네킹 : 여기서 k칸 인접은 못감
	// 4: 시작 위치

	static int n,m,k;
	static int[][] arr;
	static int[][] d;
	static Queue<Pair> mq = new ArrayDeque<>();



	static void init() throws IOException {
		arr = new int[n=rstn()][m=rstn()]; k=rstn();
		for(int i=0; i<n; ++i) arr[i] = ra();
		d = new int[n][m];
		for(int i=0; i<n; ++i) Arrays.fill(d[i],-1);

		for(int i=0; i<n; ++i){
			for(int j=0; j<m; ++j){
				if(arr[i][j] == 3){
					mq.add(new Pair(i,j));
					d[i][j] = 0;
				}
			}
		}

	}

	static void manekingbfs(){
		while(!mq.isEmpty()){
			Pair cur = mq.poll();
			if(d[cur.x][cur.y] == k) continue;
			for(int i=0; i<4; ++i){
				int nx = cur.x+dx[i];
				int ny = cur.y+dy[i];
				if(chk(nx,ny,n,m)) continue;
				if(d[nx][ny] != -1) continue;
				mq.add(new Pair(nx,ny));
				d[nx][ny] = d[cur.x][cur.y]+1;
			}
		}
	}

	static int bfs(int x, int y){
		Queue<Pair> q = new ArrayDeque<>();
		q.add(new Pair(x,y));
		d[x][y] = 0;

		while(!q.isEmpty()){
			Pair p = q.poll();
			if(arr[p.x][p.y] == 2) return d[p.x][p.y];
			for(int i=0; i<4; ++i){
				int nx = p.x+dx[i];
				int ny = p.y+dy[i];
				if(chk(nx,ny,n,m)) continue;
				if(arr[nx][ny] == 1 || d[nx][ny] != -1) continue;
				q.add(new Pair(nx,ny));
				d[nx][ny] = d[p.x][p.y]+1;
			}
		}
		return -1;
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader(false);
		init();
		manekingbfs();
		for(int i=0; i<n; ++i){
			for(int j=0; j<m; ++j){
				if(arr[i][j] == 4){
					System.out.println(bfs(i,j));
					return;
				}
			}
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Integer.parseInt(st.nextToken());}
	static int[] ra() throws IOException {return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();}
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static boolean chk(int x, int y, int n, int m){return x<0 || y<0 || x>=n || y>=m;}
	static class Pair{int x,y;public Pair(int x, int y) {this.x = x;this.y = y;}}
	static class Triple{ int x,y,z;public Triple(int x, int y,int z) {this.x = x;this.y = y;this.z = z;}}
	static class Quad{ int w,x,y,z;public Quad(int w, int x, int y,int z) {this.w = w; this.x = x;this.y = y;this.z = z;}}
}
