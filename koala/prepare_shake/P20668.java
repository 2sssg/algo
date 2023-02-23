package koala.prepare_shake;

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

public class P20668 {
	static final long fac = 10*9*8*7*6*5*4*3*2;
	static int n, m;
	static List<Triple>[] adjList;
	static long[][] dist;
	static void init() throws IOException {
		n = rstn(); m = rstn();
		adjList = new ArrayList[n + 1];
		for (int i = 0; i <= n; ++i) adjList[i] = new ArrayList<>();
		dist = new long[n + 1][11];
		for (int i = 0; i <= n; ++i) Arrays.fill(dist[i], LINF);
		for (int i = 0; i < m; ++i) {
			int a = rstn(), b = rstn(), l = rstn(), k = rstn();
			adjList[a].add(new Triple(b, fac * l, k));
			adjList[b].add(new Triple(a, fac * l, k));
		}
	}

	static long dijk() {
		// 노드, 속도, 소요시간
		PriorityQueue<Triple> pq = new PriorityQueue<>(Comparator.comparingLong(o->o.z));
		pq.add(new Triple(1, 1, 0L));
		dist[1][1] = 0;
		while (!pq.isEmpty()) {
			Triple cur = pq.poll();
			if (dist[cur.x][(int)cur.y] < cur.z) continue;
//			if (cur.x == n) return dist[cur.x][(int)cur.y];
			for (Triple nxt : adjList[cur.x]) {
				for (int i = 0; i < 3; ++i) {
					int nx = nxt.x;
					long ny = cur.y + dx[i];
					if (ny <= 0 || nxt.z < ny) continue;
					long nz = cur.z + nxt.y / ny;
					if (dist[nx][(int)ny] <= nz) continue;
					Triple nT = new Triple(nx, ny, nz);
					pq.add(nT);
					dist[nx][(int)ny] = nz;
				}
			}
		}
		return min(dist[n]);
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		init();
		long ans = dijk();
		System.out.print(ans / 3628800);
		ans %= fac;
		double y = (double)ans / 3628800;
		System.out.println(String.format("%.9f", y).substring(1));

	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	private static int swap(int localA, int localB) {return localA;}
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Integer.parseInt(st.nextToken());}
	static int[] ra() throws IOException {return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();}
	static int dx[] = { 0,1,-1,0,-1,1,1,-1 };
	static int dy[] = { -1,0,0,1,1,1,-1,-1 };
	static boolean chk(int x, int y, int n, int m){return x<0 || y<0 || x>=n || y>=m;}
	static class Pair{int x,y;public Pair(int x, int y) {this.x = x;this.y = y;}}
	static class Triple{ int x;long y,z;public Triple(int x, long y,long z) {this.x = x;this.y = y;this.z = z;}}
	static class Quad{ int w,x,y,z;public Quad(int w, int x, int y,int z) {this.w = w; this.x = x;this.y = y;this.z = z;}}
	static final int IINF = Integer.MAX_VALUE;
	static final long LINF = Long.MAX_VALUE;
	static final int HIINF = Integer.MAX_VALUE / 2;
	static final long HLINF = Long.MAX_VALUE / 2;
	static int max(int... temp) {return Arrays.stream(temp).max().getAsInt();}
	static int min(int... temp) {return Arrays.stream(temp).min().getAsInt();}
	static long min(long... temp) {return Arrays.stream(temp).min().getAsLong();}
}
