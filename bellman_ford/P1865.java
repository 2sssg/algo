package bellman_ford;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P1865 {
	static int t, n, m, w;
	static List<Pair>[] adjList;
	static int[] dist;
	static final int INF = 987654321;

	static boolean bellmanFord() {
		Arrays.fill(dist, INF);
		dist[1] = 0;
		boolean update = false;

		for (int i = 1; i < n; ++i) {
			for (int j = 1; j <= n; j++) for (Pair cur : adjList[j]) if (dist[cur.x] > dist[j] + cur.y && (update = true)) dist[cur.x] = dist[j] + cur.y;
			if (!update) break;
		}
		if (update) for (int i = 1; i <= n; i++) for (Pair cur : adjList[i]) if (dist[cur.x] > dist[i] + cur.y) return true;
		return false;
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		t = rn();
		while (t-- > 0) {
			n = rstn(); m = rstn(); w = rstn();
			dist = new int[n + 1];
			adjList = new ArrayList[n + 1];
			for (int i = 0; i <= n; ++i) adjList[i] = new ArrayList<>();
			int v1, v2, weight;
			for (int i = 0; i < m; ++i) {
				v1 = rstn(); v2 = rstn(); weight = rstn();
				adjList[v1].add(new Pair(v2, weight));
				adjList[v2].add(new Pair(v1, weight));
			}
			for (int i = 0; i < w; ++i) {
				v1 = rstn(); v2 = rstn(); weight = rstn();
				adjList[v1].add(new Pair(v2, -weight));
			}
			bw.append(bellmanFord() ? "YES\n" : "NO\n");
		}
		bw.flush();
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
