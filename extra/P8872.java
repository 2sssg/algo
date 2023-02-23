package extra;

import java.io.*;
import java.util.*;

public class P8872 {
	static int n, m, k, x, y, z, u, v, r, g, res;
	static int[] dist, back;
	static boolean[] visited, visited2;
	static List<Integer> ra;
	static List<Pair> f;
	static List<Pair>[] adjList;

	static void init() throws IOException {
		n = rstn(); m = rstn(); k = rstn();
		adjList = new ArrayList[n + 1];
		f = new ArrayList<>();
		ra = new ArrayList<>();
		for (int i = 0; i <= n; ++i) adjList[i] = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			x = rstn(); y = rstn(); z = rstn();
			adjList[x + 1].add(new Pair(y + 1, z));
			adjList[y + 1].add(new Pair(x + 1, z));
		}
		back = new int[n + 1]; dist = new int[n + 1]; visited = new boolean[n + 1]; visited2 = new boolean[n + 1];
		Arrays.fill(back, 0); Arrays.fill(dist, HIINF);
	}

	static void dfs(int here, int dis) {
		visited[here] = true;
		dist[here] = dis;
		if (dist[here] > r) {
			r = dist[here];
			v = here;
		}
		for (Pair nxt : adjList[here]) {
			if (visited[nxt.x]) continue;
			dfs(nxt.x, dis + nxt.y);
		}
	}

	static void dfs2(int here, int dis) {
		visited2[here] = true;
		dist[here] = dis;
		if (dist[here] > r) {
			r = dist[here];
			u = here;
		}
		for (Pair nxt : adjList[here]) {
			if (visited2[nxt.x])continue;
			dfs2(nxt.x, dis + nxt.y);
			back[nxt.x] = here;
		}
	}

	public static void main(String[] args) throws IOException {
		init();

		for (int i = 1; i <= n; i++) {
			if (visited[i]) continue;
			r = 0;
			u = i;
			dfs(i, 0);
			r = 0;
			back[v] = 0;
			dfs2(v, 0);
			f.add(new Pair(u, r));
			res = Math.max(r, res);
		}

		for (Pair nxt : f) {
			int it = nxt.x;
			g = HIINF;
			while (it != 0) {
				int rad = Math.max(dist[it], nxt.y - dist[it]);
				g = Math.min(g, rad);
				it = back[it];
			}
			ra.add(g);
		}
		ra.sort(Collections.reverseOrder());
		if (ra.size() >= 2)
			res = Math.max(res, ra.get(0) + ra.get(1) + k);
		if (ra.size() >= 3)
			res = Math.max(res, ra.get(1) + ra.get(2) + 2 * k);
		System.out.println(res > 1000 ? 1 : res);
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Integer.parseInt(st.nextToken());}
	static class Pair{int x,y;public Pair(int x, int y) {this.x = x;this.y = y;}}
	static final int HIINF = Integer.MAX_VALUE / 2;
}
