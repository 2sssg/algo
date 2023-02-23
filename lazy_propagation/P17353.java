package lazy_propagation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P17353 {
	static long[] a = new long[100001];
	static long[] tr = new long[400001];
	static long[] lazy = new long[400001];
	static int n;
	static long sum(int x, int s, int e, int l, int r) {
		update_lazy(x, s, e);
		if (s > r || e < l) return 0;
		else if (s >= l && e <= r) return tr[x];
		else return sum(x * 2, s, (s + e) / 2, l, r) + sum(x * 2 + 1, (s + e) / 2 + 1, e, l, r);
	}

	static void update_range(int x, int s, int e, int l, int r, long val) {
		update_lazy(x, s, e);
		if (s > r || e < l) return;
		if (s >= l && e <= r) {
			tr[x] += (e - s + 1)*val;
			if (s != e) {
				lazy[x * 2]+= val;
				lazy[x * 2 + 1]+= val;
			}
			return;
		}
		update_range(x * 2, s, (s + e) / 2, l, r, val);
		update_range(x * 2 + 1, (s + e) / 2 + 1, e, l, r, val);
		tr[x] = tr[x * 2] + tr[x * 2 + 1];
	}

	static void update_lazy(int x, int s, int e) {
		if (lazy[x] != 0) {
			tr[x] += (e - s + 1)*lazy[x];
			if (s != e) {
				lazy[x * 2] += lazy[x];
				lazy[x * 2 + 1] += lazy[x];
			}
			lazy[x] = 0;
		}
	}
	public static void main(String[] args) throws IOException {
		n = rn();
		for (int i = 1; i <= n; i++) a[i] = rstn();
		for (int i = 1; i <= n; i++) {
			update_range(1, 1, n, i, i, a[i] - a[i-1]);
		}
		int Q = rstn();
		while (Q-- > 0) {
			int a = rstn();
			if (a == 1) {
				int l = rstn(), r = rstn();
				update_range(1, 1, n, l, r, 1);
				update_range(1, 1, n, r + 1, r + 1, -(r - l + 1));
			}
			else {
				int x = rstn();
				sb.append(sum(1, 1, n, 1, x)).append("\n");
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
