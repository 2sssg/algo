package extra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P1396 {
	static final int MX = 200005;
	static int n, m, q;
	static List<Triple> edge;
	static int[][] par;
	static int[] lv, P, w, s;
	static List<Integer>[] adjList;

	static int find(int a) {
		return P[a] < 0 ? a : (P[a] = find(P[a]));
	}

	static void dfs(int u, int p, int level) {
		lv[u] = level;
		for (int v : adjList[u]) {
			if (v == u) continue;
			par[v][0] = u;
			dfs(v, u, level + 1);
		}
	}

	static int lca(int x, int y) {
		if (lv[x] > lv[y]) x = swap(y, y = x);
		for (int i = 18; i >= 0; i--) {
			if (lv[y] - lv[x] >= (1 << i)) {
				y = par[y][i];
			}
		}
		if (x == y) return x;
		for (int i = 18; i >= 0; i--) {
			if (par[x][i] != par[y][i]) {
				x = par[x][i];
				y = par[y][i];
			}
		}
		return par[x][0];
	}

	static void init() throws IOException {
		n = rstn(); m = rstn();
		edge = new ArrayList<>();
		par = new int[MX][20];
		lv = new int[MX]; P = new int[MX]; w = new int[MX]; s = new int[MX];
		adjList = new ArrayList[MX];

		for (int i = 0; i < MX; ++i) adjList[i] = new ArrayList<>();
		for (int i = 0; i < m; ++i) {
			int a = rstn(), b = rstn(), c = rstn();
			edge.add(new Triple(c, a, b));
		}
		edge.sort((o1, o2) -> o1.x != o2.x ? o1.x - o2.x : o1.y != o2.y ? o1.y - o2.y : o1.z - o2.z);
		Arrays.fill(P, -1);
		for (int i = 1; i <= n; ++i) s[i] = 1;
		q = rstn();
	}

	public static void main(String[] args) throws IOException {
		init();
		for (Triple t : edge) {
			t.y = find(t.y);
			t.z = find(t.z);
			if (t.y != t.z) {
				adjList[++n].add(t.y);
				adjList[n].add(t.z);
				P[t.y] = n;
				P[t.z] = n;
				w[n] = t.x;
				s[n] = s[t.y] + s[t.z];
			}
		}
		for (int i = 1; i <= n; ++i) if (P[i] < 0) dfs(i, i, 0);
		for (int j = 1; j <= 18; j++) for (int i = 1; i <= n; i++) par[i][j] = par[par[i][j - 1]][j - 1];

		while (q-- > 0) {
			int x = rstn(), y = rstn();
			if (find(x) != find(y)) sb.append("-1\n");
			else {
				int L = lca(x, y);
				sb.append(w[L]).append(" ").append(s[L]).append("\n");
			}
		}
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
	static int dy[] = { -1,0,0,1,1,1,-1,-1 };
	static int dx[] = { 0,1,-1,0,-1,1,1,-1 };
	static boolean chk(int x, int y, int n, int m){return x<0 || y<0 || x>=n || y>=m;}
	static class Pair{int x,y;public Pair(int x, int y) {this.x = x;this.y = y;}}
	static class Triple{ int x,y,z;public Triple(int x, int y,int z) {this.x = x;this.y = y;this.z = z;}}
	static class Quad{ int w,x,y,z;public Quad(int w, int x, int y,int z) {this.w = w; this.x = x;this.y = y;this.z = z;}}
	static final int IINF = Integer.MAX_VALUE;
	static final long LINF = Long.MAX_VALUE;
	static final int HIINF = Integer.MAX_VALUE / 2;
	static final long HLINF = Long.MAX_VALUE / 2;
	static int max(int... temp) {return Arrays.stream(temp).max().getAsInt();}
	static int min(int... temp) {return Arrays.stream(temp).min().getAsInt();}
}
