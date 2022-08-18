package koala.preparation.week7.dijk;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P22116 {
	static int n;
	static int[][] adjList;

	static void init() throws IOException {
		adjList = new int[n=rn()][n];
		for(int i=0; i<n; ++i) adjList[i] = ra();
	}

	static void dijk(){
		PriorityQueue<Triple> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.z));
		int[][] d = new int[n][n];
		for(int i=0; i<n; ++i) Arrays.fill(d[i],Integer.MAX_VALUE);
		pq.add(new Triple(0,0,0));
		d[0][0] = 0;

		while(!pq.isEmpty()){
			Triple cur = pq.poll();
			if(d[cur.x][cur.y] < cur.z) continue;
			for(int i=0; i<4; ++i){
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if(chk(nx,ny,n,n)) continue;
				int nd = Math.max(Math.abs(adjList[cur.x][cur.y]-adjList[nx][ny]),cur.z);
				if(d[nx][ny]>nd) {
					pq.add(new Triple(nx,ny,nd));
					d[nx][ny] = nd;
				}
			}
		}
		System.out.println(d[n-1][n-1]);

	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		init();
		dijk();
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
