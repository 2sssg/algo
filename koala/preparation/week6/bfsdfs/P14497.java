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

public class P14497 {
	static int n,m,sx,sy,ex,ey,idx;
	static char[][] arr;
	static boolean[][] d = new boolean[301][301];
	static Queue<Pair> q = new ArrayDeque<>();
	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		idx = 0;
		arr = new char[n=rstn()][m=rstn()];
		sx=rstn()-1; sy=rstn()-1; ex=rstn()-1; ey=rstn()-1;
		for(int i=0; i<n; ++i) arr[i] = br.readLine().toCharArray();
		while(++idx>0){
			for(int i=0; i<n; ++i) Arrays.fill(d[i],false);
			q.add(new Pair(sx,sy));
			d[sx][sy] = true;
			char[][] temp = new char[n][m];
			for(int i=0; i<n; ++i) temp[i] = arr[i].clone();
			while(!q.isEmpty()){
				Pair p = q.poll();
				for(int i=0; i<4; ++i){
					int nx = p.x+dx[i];
					int ny = p.y+dy[i];
					if(chk(nx,ny,n,m)) continue;
					if(d[nx][ny]) continue;
					if(arr[nx][ny]=='1'){
						temp[nx][ny] = '0';
					}
					else if(arr[nx][ny]=='0'){
						q.add(new Pair(nx,ny));
						d[nx][ny] = true;
					}else if(arr[nx][ny] == '#'){
						System.out.println(idx);
						return;
					}
				}
			}
			for(int i=0; i<n; ++i){
				for(int j=0; j<m; ++j){
					arr[i][j] = temp[i][j];
				}
			}
		}



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
