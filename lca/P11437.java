package lca;

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

public class P11437 {

	static List<Integer>[] tree;
	static int n, m, node1, node2;
	static int[] depth, parent;

	static void init() throws IOException {
		n = rn();
		depth = new int[n + 1];
		Arrays.fill(depth, -1);
		depth[1] = 0;
		parent = new int[n + 1];
		tree = new ArrayList[n + 1];
		for (int i = 0; i <= n; ++i) tree[i] = new ArrayList<>();
		for (int i = 1; i < n; ++i) {
			node1 = rstn();
			node2 = rstn();
			tree[node1].add(node2);
			tree[node2].add(node1);
		}
		m = rn();
	}

	static void dfs(int node) {
		for (int nxt : tree[node]) {
			if (depth[nxt] != -1) continue;
			parent[nxt] = node;
			depth[nxt] = depth[node] + 1;
			dfs(nxt);
		}
	}

	static int lca(int a, int b) {
		while (depth[a] != depth[b]) {
			if (depth[a] > depth[b])
				a = parent[a];
			else
				b = parent[b];
		}
		while (a != b) {
			a = parent[a];
			b = parent[b];
		}
		return a;
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		init();
		dfs(1);
		for (int i = 0; i < m; ++i) {
			node1 = rstn(); node2 = rstn();
			bw.append(Integer.toString(lca(node1, node2))).append("\n");
		}
		bw.flush();
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
