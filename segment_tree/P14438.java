package segment_tree;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P14438 {
	static int n, m;
	static int[] arr, tree;

	static void init() throws IOException {
		n = rn();
		arr = new int[n + 1];
		for (int i = 1; i <= n; ++i) arr[i] = rstn();

		int size = 1;
		while (n > size) size *= 2;
		tree = new int[size * 2];
		treeInit(1, n, 1);
		m = rn();
	}

	static int treeInit(int s, int e, int node) {
		if (s == e) {
			tree[node] = arr[s];
			return tree[node];
		}
		int mid = (s + e) >> 1;
		return tree[node] = Math.min(treeInit(s, mid, node * 2), treeInit(mid + 1, e, node * 2 + 1));
	}

	static int update(int s, int e, int node, int idx, int diff) {
		if (idx < s || e < idx) return tree[node];
		if (s == e) return tree[node] = diff;
		int mid = (s + e) >> 1;
		return tree[node] = Math.min(update(s, mid, node * 2, idx, diff),
				update(mid + 1, e, node * 2 + 1, idx, diff));
	}

	static int query(int s, int e, int node, int l , int r) {
		if (r < s || e < l) return Integer.MAX_VALUE;
		if (l <= s && e <= r) return tree[node];
		int mid = (s + e) >> 1;
		return Math.min(query(s, mid, node * 2, l, r), query(mid + 1, e, node * 2 + 1, l , r));
	}


	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		init();
		while (m-- > 0) {
			if (rstn() == 1) update(1, n, 1, rstn(), rstn());
			else sb.append(query(1, n, 1, rstn(), rstn())).append("\n");
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
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static boolean chk(int x, int y, int n, int m){return x<0 || y<0 || x>=n || y>=m;}
	static class Pair{int x,y;public Pair(int x, int y) {this.x = x;this.y = y;}}
	static class Triple{ int x,y,z;public Triple(int x, int y,int z) {this.x = x;this.y = y;this.z = z;}}
	static class Quad{ int w,x,y,z;public Quad(int w, int x, int y,int z) {this.w = w; this.x = x;this.y = y;this.z = z;}}
}
