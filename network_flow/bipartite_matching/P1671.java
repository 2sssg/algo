package network_flow.bipartite_matching;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

public class P1671 {
	static int n;
	static Triple[] shark;
	static boolean[] visited;
	static int[] bmatch;
	static List<Integer>[] adjList;

	static void init() throws IOException {
		n = rn();
		shark = new Triple[n];

		for (int i = 0; i < n; ++i) shark[i] = new Triple(rstn(),rstn(),rstn());

		bmatch = new int[n + 1];
		Arrays.fill(bmatch, -1);

		adjList = new ArrayList[n];
		for (int i = 0; i < n; ++i) adjList[i] = new ArrayList<>();

		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				if (i == j) continue;
				if (shark[i].compare(shark[j])) {
					if (shark[i].equals(shark[j])&& i > j) continue;
					adjList[i].add(j);
				}
			}
		}
	}

	static boolean dfs(int a) {
		for (int i = 0; i < adjList[a].size(); ++i) {
			int b = adjList[a].get(i);
			if (visited[b]) continue;
			visited[b] = true;
			if (bmatch[b] == -1 || dfs(bmatch[b])) {
				bmatch[b] = a;
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		init();

		int answer = 0;
		for (int i = 0; i < n; ++i) {
			visited = new boolean[n];
			answer += dfs(i) ? 1 : 0;
			visited = new boolean[n];
			answer += dfs(i) ? 1 : 0;
		}

		System.out.println(n - answer);

	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	private static int swap(int localA, int localB) {return localA;}
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Integer.parseInt(st.nextToken());}
	static class Triple{
		int x,y,z;public Triple(int x, int y,int z) {this.x = x;this.y = y;this.z = z;}
		boolean compare(Triple o) {return this.x >= o.x && this.y >= o.y && this.z >= o.z;}
		@Override
		public boolean equals(Object o) {
			Triple triple = (Triple) o;
			return x == triple.x && y == triple.y && z == triple.z;
		}
		@Override
		public int hashCode() {
			return Objects.hash(x, y, z);
		}
	}
}
