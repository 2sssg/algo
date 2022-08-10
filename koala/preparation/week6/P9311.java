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

public class P9311 {
	static int t,n,m;
	static char[][] arr;
	static int[][] d;
	static Queue<Pair> q;
	static final String[] answer = {"Shortest Path: ","No Exit\n"};
	static void qinit() throws IOException {
		n=rstn(); m=rstn();
		arr = new char[n][m];
		d = new int[n][m];
		for(int i=0; i<n; ++i) arr[i] = br.readLine().toCharArray();
		for(int i=0; i<n; ++i) Arrays.fill(d[i],-1);
		q = new ArrayDeque<>();
		for(int i=0; i<n; ++i) for(int j=0; j<m; ++j) if(arr[i][j]=='S') q.add(new Pair(i,j));
		d[q.peek().x][q.peek().y] = 0;
	}

	static int bfs() throws IOException {
		qinit();
		while(!q.isEmpty()){
			Pair p = q.poll();
			for(int i=0; i<4; ++i){
				int nx = p.x+dx[i];
				int ny = p.y+dy[i];
				if(chk(nx,ny,n,m)) continue;
				if(arr[nx][ny] == 'X' || d[nx][ny] != -1) continue;
				if(arr[nx][ny] == 'G') return d[p.x][p.y]+1;
				q.add(new Pair(nx,ny));
				d[nx][ny] = d[p.x][p.y] + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		t = rn();
		while(t-->0) {
			int ans = bfs();
			if(ans == -1){
				sb.append(answer[1]);
			}else{
				sb.append(answer[0]).append(ans).append("\n");
			}
		}
		System.out.println(sb.toString());
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
