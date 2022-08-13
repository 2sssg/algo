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

public class P17129 {
	static int n,m;
	static int[][] arr;
	static boolean[][] visit = new boolean[3001][3001];

	static void init() throws IOException {
		arr=new int[n=rstn()][m=rstn()];
		visit = new boolean[3001][3001];
		for(int i=0; i<n; ++i) arr[i] = ra();
	}

	static String bfs(){
		Queue<Triple> q = new ArrayDeque<>();

		for(int i=0; i<n; ++i){
			for(int j=0; j<m; ++j){
				if(arr[i][j] == 2){
					q.add(new Triple(i,j,0));
					visit[i][j] = true;
					i=n;
					break;
				}
			}
		}

		while(!q.isEmpty()){
			Triple t = q.poll();
			for(int i=0; i<4; ++i){
				int nx = t.x+dx[i];
				int ny = t.y+dy[i];
				int nz = t.z+1;
				if(chk(nx,ny,n,m) || arr[nx][ny] == 1 || visit[nx][ny]) continue;
				if(arr[nx][ny] != 0) return String.format("TAK%n%d",nz);
				q.add(new Triple(nx,ny,nz));
				visit[nx][ny] = true;
			}
		}
		return "NIE";
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
	static int[] ra() throws IOException {return Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();}
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static boolean chk(int x, int y, int n, int m){return x<0 || y<0 || x>=n || y>=m;}
	static class Pair{int x,y;public Pair(int x, int y) {this.x = x;this.y = y;}}
	static class Triple{ int x,y,z;public Triple(int x, int y,int z) {this.x = x;this.y = y;this.z = z;}}
	static class Quad{ int w,x,y,z;public Quad(int w, int x, int y,int z) {this.w = w; this.x = x;this.y = y;this.z = z;}}
	////////////////////////////////bfs/////////////////////////////////////////////
}
