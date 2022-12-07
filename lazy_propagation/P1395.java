package lazy_propagation;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1395 {
	static int n, m, size = 1;
	static long[] seg;
	static int[] lazy;

	static void init() throws IOException {
		n = rstn(); m = rstn();
		while (n > size) size *= 2;
		seg = new long[size * 2];
		lazy = new int[size * 2];
		Arrays.fill(lazy, 1);
	}

	static void lazyProp(int s, int e, int node) {
		if (lazy[node] == 1) return ;
		seg[node] = (e - s + 1) - seg[node];
		if (s != e) {
			lazy[node * 2] *= -1;
			lazy[node * 2 + 1] *= -1;
		}
		lazy[node] = 1;
	}

	static void update(int s, int e, int node, int l, int r) {
		lazyProp(s, e, node);
		if (r < s || e < l) return ;
		if (l <= s && e <= r) {
			seg[node] = (e - s + 1) - seg[node];
			if (s != e) {
				lazy[node * 2] *= -1 ;
				lazy[node * 2 + 1] *= -1;
			}
			return ;
		}
		int mid = (s + e) >> 1;
		update(s, mid, node * 2, l, r);
		update(mid + 1, e, node * 2 + 1, l, r);
		seg[node] = seg[node * 2] + seg[node * 2 + 1];
	}

	static long query(int s, int e, int node, int l, int r) {
		lazyProp(s, e, node);
		if (r < s || e < l) return 0;
		if (l <= s && e <= r) return seg[node];
		int mid = (s + e) >> 1;
		return query(s, mid, node * 2, l, r) + query(mid + 1, e, node * 2 + 1, l, r);

	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		init();
		while (m-- > 0) {
			System.out.println("========================");
			System.out.println(Arrays.toString(seg));
			if (rstn() == 0) update(1, n, 1, rstn(), rstn());
			else sb.append(query(1, n, 1, rstn(), rstn())).append("\n");
			System.out.println(Arrays.toString(seg));
			System.out.println("========================\n\n");
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