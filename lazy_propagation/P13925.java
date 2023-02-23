package lazy_propagation;

import Constant.Source;
import java.io.*;
import java.util.*;

public class P13925 {
	static final long MOD = (long) (1e9 + 7);
	static int n, m;
	static long[] arr, seg;
	static long[][] lazy;

	static void init() throws IOException {
		sb.setLength(0);

		n = rn();
		arr = new long[n + 1];
		for (int i = 1; i <= n; ++i) arr[i] = rstn();
		int size = 1;
		while (size < n) size *= 2;
		seg = new long[size * 2];
		lazy = new long[size * 2][2];
		for (int i = 0; i < size * 2; ++i) {
			lazy[i][0] = 1; lazy[i][1] = 0;
		}
		m = rn();
	}

	static long segInit(int s, int e, int node) {
		if (s == e) return seg[node] = arr[e];
		int mid = (s + e) >> 1;
		return seg[node] = ((segInit(s, mid, node * 2) + segInit(mid + 1, e, node * 2 + 1)) % MOD);
	}

	static void laz(int s, int e, int node) {
		long a = lazy[node][0];
		long b = lazy[node][1];
		if(a == 1 && b == 0) return;
		if(s != e){
			for (int i = node * 2; i <= node * 2 + 1; i++) {
				long aa = lazy[i][0];
				long bb = lazy[i][1];

				lazy[i][0] = a * aa;
				lazy[i][0] %= MOD;

				lazy[i][1] = a * bb + b;
				lazy[i][1] %= MOD;
			}
		}
		seg[node] = a * seg[node] + (e - s + 1) * b;
		seg[node] %= MOD;

		lazy[node][0] = 1;
		lazy[node][1] = 0;
	}

	static void update(int s, int e, int node, int l, int r, long mul, long sum){
		laz(s, e, node);
		if(r < s || e < l) return;
		if(l <= s && e <= r){
			lazy[node][0] *= mul;
			lazy[node][0] %= MOD;

			lazy[node][1] *= mul;
			lazy[node][1] %= MOD;

			lazy[node][1] += sum;
			lazy[node][1] %= MOD;

			laz(s, e, node);
			return;
		}

		int mid = (s + e) >> 1;
		update(s, mid, node * 2, l, r, mul, sum);
		update(mid + 1, e, node * 2 + 1, l, r, mul, sum);
		seg[node] = (seg[node * 2] + seg[node * 2 + 1]) % MOD;
	}

	static long query(int s, int e, int node, int l, int r){
		laz(s, e, node);
		if(r < s || e < l) return 0;
		if(l <= s && e <= r) return seg[node] % MOD;
		int mid = (s + e) >> 1;
		return (query(s, mid, node * 2, l, r) + query(mid + 1, e, node * 2 + 1, l, r)) % MOD;
	}


	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		init();
		segInit(1, n, 1);

		while(m-- > 0){
			int type = rstn();
			int x = rstn(), y = rstn(), v = 0;
			if(type != 4) v = rstn();

			if(type == 1) update(1, n, 1, x, y, 1, v);
			else if(type == 2) update(1, n, 1,  x, y, v, 0);
			else if(type == 3) update(1, n, 1,  x, y, 0, v);
			else sb.append(query(1, n, 1,  x, y)).append("\n");
		}
		System.out.println(sb);

	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Integer.parseInt(st.nextToken());}
}