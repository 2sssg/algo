package bellman_ford;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P11657 {
	static int n,m;
	static long[] dist;
	static List<Pair>[] adjList;
	static final long INF = Long.MAX_VALUE / 2;

	static void init() throws IOException {
		n = rstn(); m = rstn();
		adjList = new ArrayList[n + 1];
		dist = new long[n + 1];
		Arrays.fill(dist, INF);
		for (int i = 0; i <= n; ++i) adjList[i] = new ArrayList<>();
		for (int i = 0; i < m; ++i) adjList[rstn()].add(new Pair(rstn(), rstn()));
	}

	static boolean bellmanFord() {
		dist[1] = 0;
		boolean update = false;
		for (int i = 1; i < n; ++i) {
			for (int j = 1; j <= n; j++) for (Pair cur : adjList[j]) if (dist[cur.x] > dist[j] + cur.y && (update = true)) dist[cur.x] = dist[j] + cur.y;
//			if (!update) break;
		}
		if (update) for (int i = 1; i <= n; i++) for (Pair cur : adjList[i]) if (dist[cur.x] > dist[i] + cur.y) return true;
		return false;
	}

	public static boolean bellmanford() {
		dist[1] = 0;
		boolean update = false;
		for (int i = 1; i < n; i++) {
			update = false;
			for (int j = 1; j <= n; j++) {
				for (Pair nxt : adjList[j]) {
					if (dist[j] == INF) break;
					if (dist[nxt.x] > dist[j] + nxt.y) {
						dist[nxt.x] = dist[j] + nxt.y;
						update = true;
					}
				}
			}
			if (!update) break;
		}
		if (update) {
			for (int i = 1; i <= n; i++) {
				for (Pair nxt : adjList[i]) {
					if (dist[i] == INF) break;
					if (dist[nxt.x] > dist[i] + nxt.y) return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		init();
		if (!bellmanford())
			for (int i = 2; i <= n; ++i)
				sb.append(dist[i] == INF ? -1 : dist[i]).append("\n");
		else
			sb.append(-1);
		System.out.println(sb);
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
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static boolean chk(int x, int y, int n, int m){return x<0 || y<0 || x>=n || y>=m;}
	static class Pair{int x,y;public Pair(int x, int y) {this.x = x;this.y = y;}}
	static class Triple{ int x,y,z;public Triple(int x, int y,int z) {this.x = x;this.y = y;this.z = z;}}
	static class Quad{ int w,x,y,z;public Quad(int w, int x, int y,int z) {this.w = w; this.x = x;this.y = y;this.z = z;}}
}
