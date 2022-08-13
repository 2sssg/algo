package koala.preparation.week6.bfsdfs;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import library.UsefulForAlgo;

public class P16441 {
	static int n,m;
	static char[][] arr;
	static boolean[][] mask;
	static boolean[][][] visit;
	static void init() throws IOException {
		arr = new char[n=rstn()][m=rstn()];
		mask = new boolean[n][m];
		for(int i=0; i<n; ++i) arr[i] = br.readLine().toCharArray();
	}

	static void dfs(int x, int y, int dir){
		if(arr[x][y] == '+'){
			visit[x][y][dir] = true;
			int nx = x+dx[dir];
			int ny = y+dy[dir];
			if(chk(nx,ny,n,m) || visit[nx][ny][dir]) return;

			dfs(nx,ny,dir);
		}else{
			visit[x][y][0] = true;
			visit[x][y][1] = true;
			visit[x][y][2] = true;
			visit[x][y][3] = true;
			for(int i=0; i<4; ++i){
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(chk(nx,ny,n,m)) continue;
				boolean v = visit[nx][ny][0]||visit[nx][ny][1]||visit[nx][ny][2]||visit[nx][ny][3];
				if(arr[nx][ny] == '+' && visit[nx][ny][dir])continue;
				if(arr[nx][ny] != '+' ||arr[nx][ny]=='#' || v) continue;
				dfs(nx,ny,i);
			}
		}
	}

	static void maskMap(){
		for(int i=0; i<n; ++i){
			for(int j=0; j<m; ++j){
				mask[i][j] = mask[i][j]||visit[i][j][0]||visit[i][j][1]||visit[i][j][2]||visit[i][j][3];
			}
		}
	}

	static void makeMap(){
		for(int i=0; i<n; ++i){
			for(int j=0; j<m; ++j){
				if(arr[i][j] == '#' || arr[i][j] =='+' || mask[i][j]) continue;
				arr[i][j] = 'P';
			}
		}
	}

	static void print() throws IOException {
		for(int i=0; i<n; ++i){
			for(int j=0; j<m; ++j){
				bw.write(String.valueOf(arr[i][j]));
			}
			bw.write("\n");
		}
		bw.flush();
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		init();

		for(int i=0; i<n; ++i){
			for(int j=0; j<m; ++j){
				if(arr[i][j]=='W') {
					visit = new boolean[101][101][4];
					dfs(i,j,0);
					for(int x=0; x<n; ++x){
						for(int y=0; y<m; ++y){
							System.out.print(visit[x][y][0]||visit[x][y][1]||visit[x][y][2]||visit[x][y][3]?1:0);
						}
						System.out.println();
					}
					System.out.println();
					maskMap();
				}
			}
		}
		makeMap();
		print();
	}
	////////////////////////////////bfs/////////////////////////////////////////////
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
	////////////////////////////////bfs/////////////////////////////////////////////
}
