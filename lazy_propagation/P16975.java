package lazy_propagation;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P16975 {
	static int n, m;
	static long[] arr, seg, lazy;

	static void init() throws IOException {
		n = rn();
		arr = new long[n + 1];
		for (int i = 1; i <= n; ++i) arr[i] = rstn();
		int size = 1;
		while (n > size) size *= 2;
		seg = new long[size * 2];
		lazy = new long[size * 2];
		m = rn();
	}

	static long segInit(int s, int e, int node) {
		if (s == e) return seg[node] = arr[s];
		int mid = (s + e) >> 1;
		return seg[node] = segInit(s, mid, node * 2) + segInit(mid + 1, e, node * 2 + 1);
	}

	static void lazyProp(int s, int e, int node) {
		if (lazy[node] == 0) return ;
		if (s != e) {
			lazy[node * 2] += lazy[node];
			lazy[node * 2 + 1] += lazy[node];
		}
		seg[node] += (e - s + 1) * lazy[node];
		lazy[node] = 0;
	}

	static void update(int s, int e, int node, int l, int r, int diff) {
		lazyProp(s, e, node);
		if (e < l || r < s) return ;
		if (l <= s && e <= r) {
			if (s != e) {
				lazy[node * 2] += diff;
				lazy[node * 2 + 1] += diff;
			}
			seg[node] += ((long)(e - s + 1) * diff);
			return ;
		}
		int mid = (s + e) >> 1;
		update(s, mid, node * 2, l, r, diff); update(mid + 1, e, node * 2 + 1, l, r, diff);
		seg[node] = seg[node * 2] + seg[node * 2 + 1];
	}

	static long query(int s, int e, int node, int idx) {
		lazyProp(s, e, node);
		if (idx < s || e < idx) return 0;
		if (s == e) return seg[node];
		int mid = (s + e) >> 1;
		return query(s, mid, node * 2, idx) + query(mid + 1, e, node * 2 + 1, idx);
	}


	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		init();
		segInit(1, n, 1);
		while (m-- > 0) {
			if (rstn() == 1) update(1, n, 1, rstn(), rstn(), rstn());
			else sb.append(query(1, n, 1, rstn())).append("\n");
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
	static final int IINF = Integer.MAX_VALUE;
	static final long LINF = Long.MAX_VALUE;
	static final int HIINF = Integer.MAX_VALUE / 2;
	static final long HLINF = Long.MAX_VALUE / 2;
}
