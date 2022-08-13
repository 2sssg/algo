package koala.preparation.week6.test;

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

public class P17836 {
	static int n,m,t,answer = Integer.MAX_VALUE;
	static int[][] d,arr;

	static void init() throws IOException {
		arr = new int[n=rstn()][m=rstn()]; t=rstn();
		d = new int[n][m];
		for(int i=0; i<n; ++i) Arrays.fill(d[i],-1);
		for(int i=0; i<n; ++i) arr[i] = ra();
	}

	static String bfs(){
		Queue<Pair> q = new ArrayDeque<>();
		d[0][0] = 0;
		q.add(new Pair(0,0));

		while(!q.isEmpty()){
			Pair p = q.poll();
			if(d[p.x][p.y]>t) {
				if(answer>t) return "Fail";
				else return Integer.toString(answer);
			}
			if(d[p.x][p.y]>=answer) return Integer.toString(answer);
			if(p.x == n-1 && p.y == m-1) return Integer.toString(d[p.x][p.y]);
			if(arr[p.x][p.y]==2){
				answer = d[p.x][p.y]+Math.abs((n-1)-p.x) + Math.abs((m-1)-p.y);
				continue;
			}
			for(int i=0; i<4; ++i){
				int nx = p.x+dx[i];
				int ny = p.y+dy[i];
				if(chk(nx,ny,n,m) || arr[nx][ny]==1 || d[nx][ny] != -1) continue;
				q.add(new Pair(nx,ny));
				d[nx][ny] = d[p.x][p.y] + 1;
			}
		}

		return answer>t?"Fail":Integer.toString(answer);
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
