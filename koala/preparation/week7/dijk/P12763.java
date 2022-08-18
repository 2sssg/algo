package koala.preparation.week7.dijk;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P12763 {
	static int n,t,m,l;
	static List<Triple>[] adjList;

	static void init() throws IOException {
		n=rn(); t=rstn(); m=rstn(); l=rn();
		adjList = new ArrayList[n+1];
		for(int i=1; i<=n; ++i) adjList[i] = new ArrayList<>();
		for(int i=0; i<l; ++i) {
			int v1=rstn(),v2=rstn(),time = rstn(),w=rstn();
			adjList[v1].add(new Triple(v2,time,w));
			adjList[v2].add(new Triple(v1,time,w));
		}
	}

	static int dijk(){
		PriorityQueue<Triple> pq = new PriorityQueue<>(Comparator.comparingInt(o->o.z));
		int[][] d = new int[n+1][10001];
		for(int i=0; i<=n; ++i) Arrays.fill(d[i],Integer.MAX_VALUE);
		// 정점, 시간, 돈
		pq.add(new Triple(1,0,0));
		// 정점, 시간, 돈
		d[1][0] = 0;

		while(!pq.isEmpty()){
			Triple cur = pq.poll();
			if(d[cur.x][cur.y] < cur.z) continue;
			for(Triple itm: adjList[cur.x]){
				int nx = itm.x;
				int nt = cur.y+itm.y;
				int nm = d[cur.x][cur.y]+itm.z;
				if(nt>t || nm>m) continue;
				if(d[nx][nt]>nm){
					pq.add(new Triple(nx,nt,nm));
					d[nx][nt] = nm;
				}
			}
		}

		return Arrays.stream(d[n]).min().getAsInt();
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		init();
		int answer = dijk();
		System.out.println(answer == Integer.MAX_VALUE?-1:answer);
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
