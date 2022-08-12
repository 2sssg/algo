package koala.preparation.week6;

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

public class P16509 {
	static final int n=10,m=9;
	static Pair ele,king;
	static int[][] d = new int[n][m];

	static int bfs(){
		Queue<Pair> q = new ArrayDeque<>();
		q.add(ele);
		d[ele.x][ele.y] = 0;
		while(!q.isEmpty()){
			Pair p = q.poll();
			if(p.x == king.x && p.y==king.y) return d[p.x][p.y];
			for(int i=0; i<8; ++i){
				int nx1 = p.x + dx[i][0];
				int ny1 = p.y + dy[i][0];
				int nx2 = p.x + dx[i][1];
				int ny2 = p.y + dy[i][1];
				int nx = p.x + dx[i][2];
				int ny = p.y + dy[i][2];
				if(chk(nx,ny,n,m) || chk2(nx1,ny1,king.x,king.y)|| chk2(nx2,ny2,king.x,king.y)||d[nx][ny] != -1) continue;
				q.add(new Pair(nx,ny));
				d[nx][ny] = d[p.x][p.y]+1;
			}
		}
		return -1;
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		for(int i=0; i<n; ++i) Arrays.fill(d[i],-1);
		ele = new Pair(rstn(),rstn());
		king = new Pair(rstn(),rstn());
		System.out.println(bfs());

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
	static int[][] dx = {{-1,-2,-3},{-1,-2,-3},{0,-1,-2},{0,-1,-2},{0,1,2},{0,1,2},{1,2,3},{1,2,3}};
	static int[][] dy = {{0,-1,-2},{0,1,2},{-1,-2,-3},{1,2,3},{-1,-2,-3},{1,2,3},{0,-1,-2},{0,1,2}};
	static boolean chk(int x, int y, int n, int m){return x<0 || y<0 || x>=n || y>=m;}
	static boolean chk2(int x, int y, int kx, int ky){return x==kx&&y==ky;}
	static class Pair{int x,y;public Pair(int x, int y) {this.x = x;this.y = y;}}
	static class Triple{ int x,y,z;public Triple(int x, int y,int z) {this.x = x;this.y = y;this.z = z;}}
	static class Quad{ int w,x,y,z;public Quad(int w, int x, int y,int z) {this.w = w; this.x = x;this.y = y;this.z = z;}}
	////////////////////////////////bfs/////////////////////////////////////////////
}
