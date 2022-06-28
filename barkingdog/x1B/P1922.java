package barkingdog.x1B;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1922 {

	static class Edge implements Comparable<Edge> {

		int v1;
		int v2;
		int w;

		public Edge(int v1, int v2, int w) {
			this.v1 = v1;
			this.v2 = v2;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return this.w - o.w;
		}

		@Override
		public String toString() {
			return "Edge{" +
				"v1=" + v1 +
				", v2=" + v2 +
				", w=" + w +
				'}';
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static Edge[] edges;
	static int[] parents;

	static int V, E;

	static int find(int v) {
		if (parents[v] == v) {
			return v;
		}
		return parents[v] = find(parents[v]);
	}

	static void union(int v1, int v2) {
		v1 = find(v1);
		v2 = find(v2);

		if (v1 != v2) {
			if(v1<v2){
				parents[v2] = v1;
			}else{
				parents[v1] = v2;
			}
		}

	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		edges = new Edge[E];
		parents = new int[V + 1];
		for (int i = 0; i < E; ++i) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			edges[i] = new Edge(v1, v2, w);
		}
		Arrays.sort(edges);
		for (int i = 1; i <= V; ++i) {
			parents[i] = i;
		}
		System.out.println(Arrays.toString(edges));

		int ans = 0;
		for (int i = 0; i < E; ++i) {
			Edge cur = edges[i];
			System.out.println(Arrays.toString(parents));
			if (find(cur.v1) != find(cur.v2)) {
				ans += cur.w;
				union(cur.v1, cur.v2);
			}
		}

		System.out.println(ans);


	}

}
