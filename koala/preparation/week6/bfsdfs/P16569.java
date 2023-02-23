package koala.preparation.week6.bfsdfs;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import library.UsefulForAlgo;

public class P16569 {
	static int n,m,v,x,y,height,time;
	static int[][] d;
	static int[][] arr;
	static boolean[][] vol;

	static void init() throws IOException {
		n=rstn(); m=rstn(); v=rstn(); x=rstn()-1; y=rstn()-1;
		d=new int[n][m];
		arr=new int[n][m];
		vol = new boolean[n][m];
		for(int i=0; i<n; ++i) Arrays.fill(d[i],Integer.MAX_VALUE);
		for(int i=0; i<n; ++i) arr[i] = ra();

	}

	static void bfs() throws IOException {
		PriorityQueue<Triple> pq = new PriorityQueue<>(Comparator.comparingInt(o->o.z));
		for(int i=0; i<v; ++i) {
			int tx = rstn()-1,ty=rstn()-1,tz=rstn();
			vol[tx][ty] = true;
			d[tx][ty] = tz;
			pq.add(new Triple(tx,ty,tz));
		}
		while(!pq.isEmpty()){
			Triple t = pq.poll();
			for(int i=0; i<4; ++i){
				int nx = t.x+dx[i];
				int ny = t.y+dy[i];
				int nz = d[t.x][t.y]+1;
				if(chk(nx,ny,n,m) || d[nx][ny]<=nz) continue;
				pq.add(new Triple(nx,ny,nz));
				d[nx][ny] = nz;
			}
		}
	}

	static void bfs2(){
		Queue<Pair> q = new ArrayDeque<>();
		int[][] dd = new int[n][m];
		for(int i=0; i<n; ++i) Arrays.fill(dd[i],-1);
		q.add(new Pair(x,y));
		dd[x][y] = 0;

		while(!q.isEmpty()){
			Pair p = q.poll();
			if(height < arr[p.x][p.y]){
				height = arr[p.x][p.y];
				time = dd[p.x][p.y];
			}
			for(int i=0; i<4; ++i){
				int nx = p.x+dx[i];
				int ny = p.y+dy[i];
				int nt = dd[p.x][p.y]+1;
				if(chk(nx,ny,n,m) || nt>=d[nx][ny] || dd[nx][ny] != -1 || vol[nx][ny]) continue;
				q.add(new Pair(nx,ny));
				dd[nx][ny] =  nt;
			}
		}

	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		init();
		bfs();
		bfs2();
		System.out.println(height+" "+time);
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
