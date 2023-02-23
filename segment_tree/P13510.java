package segment_tree;

import Constant.Source;
import java.io.*;
import java.util.*;

public class P13510 {
	static int n;
	static boolean[] visit;
	static ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
	static ArrayList<ArrayList<Pair>> tree = new ArrayList<>();

	private static class SegTree {
		int n;
		int[] max;
		SegTree(int n) {
			this.n = n;
			int treeSize = 1;
			while (treeSize < n) treeSize <<= 1;
			treeSize <<= 1;
			max = new int[treeSize];
		}
		void update(int node, int start, int end, int idx, int val) {
			if (idx < start || end < idx) return;
			if (start == end) {
				max[node] = val;
				return;
			}
			int mid = (start+end) >> 1;
			update(node<<1, start, mid, idx, val);
			update(node<<1|1, mid+1, end, idx, val);
			max[node] = Integer.max(max[node<<1], max[node<<1|1]);
		}
		int get(int node, int start, int end, int left, int right) {
			if (end < left || right < start) return 0;
			if (left <= start && end <= right) return max[node];
			int mid = (start+end) >> 1;
			return Integer.max(get(node<<1, start, mid, left, right), get(node<<1|1, mid+1, end, left, right));
		}
		void update(int idx, int val) {
			update(1, 0, n-1, idx, val);
		}
		int get(int left, int right) {
			return get(1, 0, n-1, left, right);
		}
	}
	private static class HLD {
		int id = 0;
		int[] dep, par, sz, in, out, top;
		Triple[] edges;
		ArrayList<ArrayList<Pair>> tree;
		SegTree sg;
		HLD(int n, ArrayList<ArrayList<Pair>> tree, Triple[] edges, int root) {
			n++;
			this.tree = tree;
			this.edges = edges;
			sg = new SegTree(n);
			dep = new int[n]; par = new int[n]; sz = new int[n];
			in = new int[n]; out = new int[n]; top = new int[n];
			dfs1(root); dfs2(root); edgesSort();
			for (int i = 1; i < edges.length; i++) {
				sg.update(in[edges[i].x], edges[i].z);
			}
		}
		void dfs1(int v) {
			sz[v] = 1;
			ArrayList<Pair> e = tree.get(v);
			for (int i = 0; i < e.size(); i++) {
				int adj = e.get(i).x;
				dep[adj] = dep[v]+1;
				par[adj] = v;
				dfs1(adj);
				sz[v] += sz[adj];
				if (sz[adj] > sz[e.get(0).x]) swap(tree.get(v), i, 0);
			}
		}
		void dfs2(int v) {
			in[v] = ++id;
			ArrayList<Pair> e = tree.get(v);
			for (int i = 0; i < e.size(); i++) {
				int adj = e.get(i).x;
				top[adj] = i == 0 ? top[v] : adj;
				dfs2(adj);
			}
			out[v] = id;
		}
		void edgesSort() {
			for (int i = 1; i < edges.length; i++) {
				if (dep[edges[i].x] > dep[edges[i].y]) continue;
				edges[i].y = swap(edges[i].x, edges[i].x=edges[i].y);
			}
		}
		void update(int idx, int w) {
			sg.update(in[edges[idx].x], w);
		}
		int query(int a, int b) {
			int ret = 0;
			while (top[a] != top[b]) {
				if (dep[top[a]] < dep[top[b]]) b = swap(a, a=b);
				int st = top[a];
				ret = Integer.max(ret, sg.get(in[st], in[a]));
				a = par[st];
			}
			if (dep[a] > dep[b]) b = swap(a, a=b);
			return Integer.max(ret, sg.get(in[a]+1, in[b]));
		}
	}
	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		n = rn();
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
			tree.add(new ArrayList<>());
		}
		Triple[] edges = new Triple[n];
		for (int i = 1; i < n; i++) {
			int start = rstn(), end = rstn(), weight = rstn();
			graph.get(start).add(new Pair(end, weight));
			graph.get(end).add(new Pair(start, weight));
			edges[i] = new Triple(start, end, weight);
		}
		int root = (int) (Math.random() * n + 1);
		visit = new boolean[n + 1];
		visit[root] = true;
		dfs(graph, tree, root);
		HLD hld = new HLD(n, tree, edges, root);
		int q = Integer.parseInt(br.readLine());
		while (q-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int type = Integer.parseInt(st.nextToken());
			if (type == 1) {
				int idx = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				hld.update(idx, cost);
			} else {
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				bw.write(Integer.toString(hld.query(u, v)));
				bw.newLine();
			}
			bw.flush();
		}
	}

	static void dfs(ArrayList<ArrayList<Pair>> graph, ArrayList<ArrayList<Pair>> tree, int v) {
		for (Pair adj : graph.get(v)) {
			if (visit[adj.x]) continue;
			tree.get(v).add(new Pair(adj.x, adj.y));
			visit[adj.x] = true;
			dfs(graph, tree, adj.x);
		}
	}
	static void swap(ArrayList arrList, int idx1, int idx2) {
		arrList.set(idx2, arrList.set(idx1, arrList.get(idx2)));
	}

	////////////////////////////////입출력/////////////////////////////////////////////
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
	static long rnl() throws IOException {return Long.parseLong(br.readLine());}
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Integer.parseInt(st.nextToken());}
	static long rstnl() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Long.parseLong(st.nextToken());}
	static int[] ra() throws IOException {return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();}
	static long[] ral() throws IOException {return Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();}
	static int[] rab() throws IOException { int[] temp = ra(); int[] ret = new int[temp.length + 1]; System.arraycopy(temp, 0, ret, 1, temp.length); return ret;}
	static long[] rabl() throws IOException { long[] temp = ral(); long[] ret = new long[temp.length + 1]; System.arraycopy(temp, 0, ret, 1, temp.length); return ret;}
	////////////////////////////////테스트 출력 ////////////////////////////////////////
	static void testPrint(int[] arr){ System.out.println(Arrays.toString(arr));}
	static void testPrint(char[] arr){ System.out.println(Arrays.toString(arr));}
	static void testPrint(long[] arr){System.out.println(Arrays.toString(arr));}
	static void testPrint(int[] arr,int end){ for(int i=0; i<=end; ++i) System.out.print(arr[i]+" ");}
	static void testPrint(int[] arr,int start,int end){ for(int i=start; i<=end; ++i) System.out.print(arr[i]+" ");}
	static void testPrint(int[][] arr){ for(int[] t: arr) testPrint(t); }
	static void testPrint(long[][] arr){ for(long[] t: arr) testPrint(t); }
	static void testPrint(char[][] arr){ for(char[] t: arr) testPrint(t); }
	static void testPrint(int[][] arr, int er, int ec){ for(int i=0; i<=er; ++i) testPrint(arr[i], ec); }
	static void testPrint(Pair[] arr) {for (int i = 0; i < arr.length; ++i) System.out.printf("{x : %d, y : %d}, ", arr[i].x, arr[i].y);}
	////////////////////////////////테스트 출력 ////////////////////////////////////////
	////////////////////////////////입출력/////////////////////////////////////////////

	/////////////////////////////// bfs /////////////////////////////////////////////
	static int dy[] = { -1,0,0,1,1,1,-1,-1 };
	static int dx[] = { 0,1,-1,0,-1,1,1,-1 };
	static boolean chk(int x, int y, int n, int m){return x<0 || y<0 || x>=n || y>=m;}
	/////////////////////////////// bfs /////////////////////////////////////////////

	////////////////////////////// 자료구조 ///////////////////////////////////////////
	static class Pair{int x,y;public Pair(int x, int y) {this.x = x;this.y = y;}}
	static class Triple{ int x,y,z;public Triple(int x, int y,int z) {this.x = x;this.y = y;this.z = z;}}
	static class Quad{ int w,x,y,z;public Quad(int w, int x, int y,int z) {this.w = w; this.x = x;this.y = y;this.z = z;}}
	////////////////////////////// 자료구조 ///////////////////////////////////////////

	////////////////////////////// 상수 //////////////////////////////////////////////
	static final int IINF = Integer.MAX_VALUE;
	static final long LINF = Long.MAX_VALUE;
	static final int HIINF = Integer.MAX_VALUE / 2;
	static final long HLINF = Long.MAX_VALUE / 2;
	////////////////////////////// 상수 //////////////////////////////////////////////

	////////////////////////////// 함수 //////////////////////////////////////////////
	// b = swap(a, a = b);
	static int swap(int localA, int localB) {return localA;}
	static int max(int... temp) {return Arrays.stream(temp).max().getAsInt();}
	static int min(int... temp) {return Arrays.stream(temp).min().getAsInt();}
	static long max(long... temp) {return Arrays.stream(temp).max().getAsLong();}
	static long min(long... temp) {return Arrays.stream(temp).min().getAsLong();}
	////////////////////////////// 함수 //////////////////////////////////////////////
}