package topology_sort;

import Constant.Source;
import java.io.*;
import java.util.*;

public class P1948 {
	static int n, m, s, e, maxDist;
	static List<Pair>[] adjList;
	static List<Pair>[] radjList;
	static int[] dist;

	static void init() throws IOException {
		n = rn(); m = rn();
		maxDist = 0;
		dist = new int[n + 1];
		Arrays.fill(dist, 1);
		adjList = new ArrayList[n + 1];
		radjList = new ArrayList[n + 1];

		for (int i = 0; i <= n; ++i) adjList[i] = new ArrayList<>();
		for (int i = 0; i <= n; ++i) radjList[i] = new ArrayList<>();

		for (int i = 0; i < m; ++i) {
			int u = rstn(), v = rstn(), w = rstn();
			adjList[u].add(new Pair(v, -w));
			radjList[v].add(new Pair(u, w));
		}
		s = rstn(); e = rstn();
	}

	static void max_dijk() {
		Queue<Pair> q = new ArrayDeque<>();
		q.add(new Pair(s, 0));
		dist[s] = 0;
		while (!q.isEmpty()) {
			Pair cur = q.poll();
			if (dist[cur.x] < cur.y) continue;
			for (Pair nxt : adjList[cur.x]) {
				if (dist[nxt.x] <= cur.y + nxt.y) continue;
				q.add(new Pair(nxt.x, cur.y + nxt.y));
				dist[nxt.x] = cur.y + nxt.y;
			}
		}
		maxDist = -dist[e];
	}

	static int getPathCnt() {
		int cnt = 0;
		boolean[] visit = new boolean[n + 1];
		Queue<Pair> q = new ArrayDeque<>();
		q.add(new Pair(e, 0));
		visit[e] = true;
		while (!q.isEmpty()) {
			Pair cur = q.poll();
			for (Pair nxt : radjList[cur.x]) {
				if (dist[nxt.x] == 1) continue;
				if (-dist[nxt.x] + nxt.y + cur.y != maxDist) continue;
				cnt++;
				if (visit[nxt.x]) continue;
				visit[nxt.x] = true;
				q.add(new Pair(nxt.x, cur.y + nxt.y));
			}
		}
		return cnt;
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		init();
		max_dijk();
		System.out.println(maxDist);
		System.out.println(getPathCnt());
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Integer.parseInt(st.nextToken());}
	static class Pair{int x,y;public Pair(int x, int y) {this.x = x;this.y = y;}

		@Override
		public String toString() {
			return "Pair{" +
					"x=" + x +
					", y=" + y +
					'}';
		}
	}
}
