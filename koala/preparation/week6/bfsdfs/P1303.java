package koala.preparation.week6.bfsdfs;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1303 {
	static class Pair{
		int x,y;
		public Pair(int x, int y) {this.x = x;this.y = y;}
	}
	static int n,m;
	static int[] answer;
	static char[][] arr;
	static boolean[][] visit;
	static Queue<Pair> q = new ArrayDeque<>();

	static void init() throws IOException {
		est(); m=rstn(); n=rstn();
		answer = new int[2];
		arr = new char[n][m];
		visit = new boolean[n][m];
		for(int i=0; i<n; ++i) arr[i] = br.readLine().toCharArray();
	}

	static void bfs(int x, int y, char c){
		int ret = 0;
		q.add(new Pair(x,y));
		visit[x][y] = true;
		while(!q.isEmpty()){
			ret++;
			Pair p = q.poll();
			for(int i=0; i<4; ++i){
				int nx = p.x+dx[i];
				int ny = p.y+dy[i];
				if(chk(nx,ny,n,m)) continue;
				if(arr[nx][ny] != c || visit[nx][ny]) continue;
				q.add(new Pair(nx,ny));
				visit[nx][ny] = true;
			}
		}
		answer[c=='B'?1:0] += ret*ret;
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		init();
		for(int i=0; i<n; ++i){
			for(int j=0; j<m; ++j){
				if(!visit[i][j]) bfs(i,j,arr[i][j]);
			}
		}
		System.out.println(Arrays.toString(answer).replaceAll("[\\[\\],]",""));
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() {return Integer.parseInt(st.nextToken());}
	static int[] ra() throws IOException {return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();}
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static boolean chk(int x, int y, int n, int m){return x<0 || y<0 || x>=n || y>=m;}
}
