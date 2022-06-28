package barkingdog.x1B;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P6497 {

	static class Edge implements Comparable<Edge> {

		int v1;
		int v2;
		int w;

		@Override
		public String toString() {
			return "Edge{" +
				"v1=" + v1 +
				", v2=" + v2 +
				", w=" + w +
				'}';
		}

		public Edge(int v1, int v2, int w) {
			this.v1 = v1;
			this.v2 = v2;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return this.w - o.w;
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static Edge[] edges;
	static int[] parents;

	static int V, E;

	static void union(int v1, int v2) {
		v1 = find(v1);
		v2 = find(v2);
		if (v1 < v2) {
			parents[v2] = v1;
		} else {
			parents[v1] = v2;
		}
	}

	static int find(int x) {
		if (parents[x] == x) {
			return x;
		}
		return parents[x] = find(parents[x]);
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		while (true) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			if (V == 0 && E == 0) {
				break;
			}
			parents = new int[V];
			edges = new Edge[E];
			int cost = 0;
			for (int i = 0; i < E; ++i) {
				st = new StringTokenizer(br.readLine());
				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				cost += w;
				edges[i] = new Edge(v1, v2, w);
			}
			Arrays.sort(edges);
			for (int i = 0; i < V; ++i) {
				parents[i] = i;
			}
			int ans = 0;
			for (int i = 0; i < E; ++i) {
				Edge cur = edges[i];
				if (find(cur.v1) != find(cur.v2)) {
					ans += cur.w;
					union(cur.v1, cur.v2);
				}
			}
			System.out.println(cost - ans);
		}


	}
}


