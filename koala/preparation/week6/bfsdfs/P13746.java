package koala.preparation.week6.bfsdfs;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P13746 {
	static int n,m,answer;
	static char[][] arr;
	static boolean[][] visit = new boolean[51][51];

	static void dfs(int x, int y){
		visit[x][y] = true;
		for(int i=0; i<4; ++i){
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(chk(nx,ny,n,m) || visit[nx][ny] || arr[nx][ny] == 'W') continue;
			dfs(nx,ny);
		}
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		arr = new char[n=rstn()][m=rstn()];
		for(int i=0; i<n; ++i) arr[i] = br.readLine().toCharArray();
		for(int i=0; i<n; ++i)for(int j=0; j<m; ++j)if(arr[i][j]=='L'&&!visit[i][j]&&++answer>0) dfs(i,j);
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
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static boolean chk(int x, int y, int n, int m){return x<0 || y<0 || x>=n || y>=m;}
	static class Pair{int x,y;public Pair(int x, int y) {this.x = x;this.y = y;}}
	////////////////////////////////bfs/////////////////////////////////////////////
}
