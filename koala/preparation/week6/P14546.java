package koala.preparation.week6;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P14546 {
	static int t,n,m,sx,sy,ex,ey;
	static char enterchar;
	static char[][] arr;
	static boolean[][] visit;
	static void init() throws IOException {
		m=rstn(); n=rstn(); sy=rstn()-1; sx=n-rstn(); ey=rstn()-1; ex=n-rstn();
		arr = new char[n][m];
		visit = new boolean[n][m];
		for(int i=0; i<n; ++i) arr[i] = br.readLine().toCharArray();
		enterchar = arr[sx][sy];
	}

	static boolean dfs(int x, int y){
		visit[x][y] = true;
		if(x==ex && y==ey) return true;
		for(int i=0; i<4; ++i){
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(chk(nx,ny,n,m) || visit[nx][ny] || arr[nx][ny] != enterchar) continue;
			if(dfs(nx,ny)) return true;
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		t=rn();
		while(t-->0){
			init();
			bw.write(dfs(sx,sy)?"YES\n":"NO\n");
		}
		bw.flush();
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
