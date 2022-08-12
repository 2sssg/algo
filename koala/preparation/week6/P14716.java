package koala.preparation.week6;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P14716 {
	static int n,m,answer;
	static int[][] arr;
	static boolean[][] visit = new boolean[251][251];

	static void dfs(int x, int y){
		visit[x][y] = true;
		for(int i=0; i<8; ++i) if(!chk(x+dx[i],y+dy[i],n,m)&&!visit[x+dx[i]][y+dy[i]]&&arr[x+dx[i]][y+dy[i]]==1) dfs(x+dx[i],y+dy[i]);
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		arr = new int[n=rstn()][m=rstn()];
		for(int i=0; i<n; ++i) arr[i] = ra();
		for(int i=0; i<n; ++i)for(int j=0; j<m; ++j)if(arr[i][j]==1 && !visit[i][j] && ++answer>0) dfs(i,j);
		System.out.println(answer);
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
	static int[] dx = {-1,-1,-1,0,0,1,1,1};
	static int[] dy = {-1,0,1,-1,1,-1,0,1};
	static boolean chk(int x, int y, int n, int m){return x<0 || y<0 || x>=n || y>=m;}
	static class Pair{int x,y;public Pair(int x, int y) {this.x = x;this.y = y;}}
	static class Triple{ int x,y,z;public Triple(int x, int y,int z) {this.x = x;this.y = y;this.z = z;}}
	static class Quad{ int w,x,y,z;public Quad(int w, int x, int y,int z) {this.w = w; this.x = x;this.y = y;this.z = z;}}
	////////////////////////////////bfs/////////////////////////////////////////////
}
