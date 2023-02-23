package network_flow;

import Constant.Source;
import java.io.*;
import java.util.*;

public class P2316 {
	static int n, p;
	static List<Integer>[] adjList;
	static int[][] c, f;

	static void init() throws IOException {
		n = rstn(); p = rstn();
		c = new int[MAX][MAX];
		f = new int[MAX][MAX];
		adjList = new ArrayList[MAX];
		for (int i = 0; i < MAX; ++i) adjList[i] = new ArrayList<>();

		for (int i = 1; i <= n; ++i){
			adjList[i].add(OUT + i);
			adjList[OUT + i].add(i);
			c[i][OUT + i] = 1;
		}

		for(int i = 0; i < p; ++i){
			int u, v;
			u = rstn(); v = rstn();

			adjList[OUT + u].add(v);
			adjList[v].add(OUT + u);
			c[OUT + u][v] = 1;

			adjList[OUT + v].add(u);
			adjList[u].add(OUT + v);
			c[OUT + v][u] = 1;
		}
	}

	static int networkFlow(int start, int end){
		int ans = 0;
		while(true) {
			int[] visit = new int[MAX];
			Arrays.fill(visit, -1);
			Queue<Integer> q = new ArrayDeque<>();
			q.add(start);
			while (!q.isEmpty()) {
				int cur = q.poll();
				for (int i = 0; i < adjList[cur].size(); ++i){
					int nxt = adjList[cur].get(i);
					if (visit[nxt] == -1 && c[cur][nxt] - f[cur][nxt] > 0) {
						visit[nxt] = cur;
						q.add(nxt);
						if (nxt == end) break;
					}
				}
			}

			if(visit[end] == -1) break;

			int flow = IINF;
			for (int i = end; i != start; i = visit[i]) flow = Math.min(flow, c[visit[i]][i] - f[visit[i]][i]);
			for(int i = end; i != start; i = visit[i]) {
				f[visit[i]][i] += flow;
				f[i][visit[i]] -= flow;
			}
			ans += flow;
		}
		return ans;
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		init();
		System.out.println(networkFlow(OUT + 1, 2));
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Integer.parseInt(st.nextToken());}
	static final int IINF = Integer.MAX_VALUE, MAX = 802, OUT = 401;
}
