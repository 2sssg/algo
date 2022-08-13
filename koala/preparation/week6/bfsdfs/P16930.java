package koala.preparation.week6.bfsdfs;

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

public class P16930 {
	static int n,m,k;
	static char[][] arr;
	static int[][] d;
	static Pair s,e;

	static void init() throws IOException {
		arr = new char[n=rstn()][m=rstn()]; k=rstn();
		d = new int[n][m];
		for(int i=0; i<n; ++i) Arrays.fill(d[i],-1);
		for(int i=0; i<n; ++i) arr[i] = br.readLine().toCharArray();
		s = new Pair(rstn()-1,rstn()-1);
		e = new Pair(rstn()-1,rstn()-1);
	}

	static int bfs(){
		Queue<Pair> q = new ArrayDeque<>();
		q.add(s);
		d[s.x][s.y] = 0;
		while(!q.isEmpty()){
			Pair p = q.poll();
			if(p.x==e.x && p.y==e.y) return d[p.x][p.y];
			for(int i=0; i<4; ++i){
				for(int j=1; j<=k; ++j){
					int nx = p.x+j*dx[i];
					int ny = p.y+j*dy[i];
					if(chk(nx,ny,n,m) || arr[nx][ny] == '#') break;
					if(d[nx][ny]==-1){
						q.add(new Pair(nx,ny));
						d[nx][ny] = d[p.x][p.y]+1;
					}
					else if(d[nx][ny] == d[p.x][p.y]+1) continue;
					else break;

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
