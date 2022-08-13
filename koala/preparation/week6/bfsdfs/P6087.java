package koala.preparation.week6.bfsdfs;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;
import library.UsefulForAlgo;

public class P6087 {
	static int n,m;
	static char[][] arr;
	static Triple s;

	static void init() throws IOException {
		est(); m=rstn();n=rstn();
		arr = new char[n][m];
		for(int i=0; i<n; ++i) arr[i] = br.readLine().toCharArray();
		for(int i=0; i<n; ++i) for(int j=0; j<m; ++j) if(arr[i][j] == 'C') s = new Triple(i,j,-1);
	}

	static int bfs(){
		Deque<Quad> dq = new ArrayDeque<>();
		int[][] d = new int[n][m];
		for(int i=0; i<n; ++i) Arrays.fill(d[i],0x3f3f3f3f);

		d[s.x][s.y] = 0;

		for(int i=0; i<4; ++i){
			int nx = s.x+dx[i];
			int ny = s.y+dy[i];
			if(chk(nx,ny,n,m)) continue;
			if(arr[nx][ny]=='*') continue;
			dq.addFirst(new Quad(0,nx,ny,i));
			d[nx][ny] = 0;
		}

		while(!dq.isEmpty()){
			Quad t = dq.pollFirst();
//			UsefulForAlgo.testPrint(d);
			if(arr[t.x][t.y] == 'C') {
				return d[t.x][t.y];
			}
			if(d[t.x][t.y] != t.w) continue;

			for(int i=0; i<4; ++i){
				int nx = t.x + dx[i];
				int ny = t.y + dy[i];
				if(chk(nx,ny,n,m)) continue;
				int dist = i==t.z?d[t.x][t.y]:d[t.x][t.y]+1;
				if(arr[nx][ny] == '*') continue;
				if(d[nx][ny]>=dist){
					d[nx][ny] = dist;
					if(i==t.z){
						dq.addFirst(new Quad(dist,nx,ny,i));
					}else{
						dq.addLast(new Quad(dist,nx,ny,i));
					}
				}

			}
		}
		return -1;
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		init();
		System.out.println(bfs());
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
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
	static class Triple{ int x,y,z;public Triple(int x, int y,int z) {this.x = x;this.y = y;this.z = z;}}
	static class Quad{ int w,x,y,z;public Quad(int w, int x, int y,int z) {this.w = w; this.x = x;this.y = y;this.z = z;}}
}
