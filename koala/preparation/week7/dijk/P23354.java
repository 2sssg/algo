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

public class P23354 {
	static int n,answer;
	static int[][] adjList,d;
	static boolean[] visit;
	static Pair loc;
	static List<Pair> l;

	static void init() throws IOException {
		l = new ArrayList<>();
		answer = Integer.MAX_VALUE;
		n=rn();
		adjList = new int[n][n];
		for(int i=0; i<n; ++i) adjList[i] = ra();
		for(int i=0; i<n; ++i){
			for(int j=0; j<n; ++j){
				if(adjList[i][j] ==0) l.add(new Pair(i,j));
				else if(adjList[i][j] == -1) {
					l.add(0,new Pair(i,j));
				}
			}
		}
		System.out.println(l);
		d = new int[l.size()][l.size()];

		visit = new boolean[l.size()];
	}

	static void dijk(Pair cur, int idx){
		int[][] dist = new int[n][n];
		for(int i=0; i<n; ++i) Arrays.fill(dist[i],Integer.MAX_VALUE);
		PriorityQueue<Triple> pq = new PriorityQueue<>(Comparator.comparingInt(o->o.z));
		pq.add(new Triple(cur.x,cur.y,0));
		dist[cur.x][cur.y] = 0;

		while(!pq.isEmpty()){
			Triple t = pq.poll();
			if(t.z != dist[t.x][t.y]) continue;
			for(int i=0; i<4; ++i){
				int nx = t.x+dx[i];
				int ny = t.y+dy[i];
				if(chk(nx,ny,n,n)) continue;
				int nz = t.z + Math.max(adjList[t.x][t.y],0);
				if(dist[nx][ny] > nz){
					dist[nx][ny] = nz;
					pq.add(new Triple(nx,ny,nz));
				}
			}
		}
		for(int i=0; i<l.size(); ++i) d[idx][i] = dist[l.get(i).x][l.get(i).y];
	}

	static void f(int depth, int idx, int cost){
		if(cost>answer) return;
		if(depth == l.size()-1){
			answer = Math.min(answer,cost+d[idx][0]);
			return;
		}
		for(int i=1; i<l.size(); ++i){
			if(visit[i]) continue;
			cost += d[idx][i];
			visit[i] = true;
			f(depth+1, i, cost);
			cost -= d[idx][i];
			visit[i] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		init();
		for(int i=0; i<l.size(); ++i){
			dijk(l.get(i),i);
		}
		f(0,0,0);
		System.out.println(answer);

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
	static class Pair{int x,y;public Pair(int x, int y) {this.x = x;this.y = y;}

		@Override
		public String toString() {
			return "Pair{" +
				"x=" + x +
				", y=" + y +
				'}';
		}
	}
	static class Triple{ int x,y,z;public Triple(int x, int y,int z) {this.x = x;this.y = y;this.z = z;}}
	static class Quad{ int w,x,y,z;public Quad(int w, int x, int y,int z) {this.w = w; this.x = x;this.y = y;this.z = z;}}
}
