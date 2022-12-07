package merge_sort_tree;

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

public class P2912 {
	static int n, size = 1, c, m;
	static int[] arr;
	static Pair[] seg;
	static int[][] color;
	static int[] count;


	private static int lowerBound(int c, int target) {
		if (c == 0) return 0;
		int l = 0;
		int r = color[c].length;
		int mid = 0;
		while (l < r) {
			mid = (l + r) / 2;
			if (color[c][mid] < target) l = mid + 1;
			else r = mid;
		}
		return r;
	}

	private static int upperBount(int c, int target) {
		if (c == 0) return 0;
		int l = 0;
		int r = color[c].length;
		int mid = 0;
		while (l < r) {
			mid = (l + r) / 2;
			if (color[c][mid] <= target) l = mid + 1;
			else r = mid;
		}
		return r;
	}

	static void init() throws IOException {
		n = rstn(); c = rstn();
		arr = new int[n + 1];
		count = new int[c + 1];
		color = new int[c + 1][];
		for (int i = 1; i <= n; ++i) {
			arr[i] = rstn();
			count[arr[i]]++;
		}
		for (int i = 1; i <= c; i++) {
			color[i] = new int[count[i]];
			count[i] = 0;
		}
		for (int i = 1; i <= n; i++) {
			int idx = count[arr[i]];
			color[arr[i]][idx] = i;
			count[arr[i]]++;
		}
		while (n > size) size *= 2;
		seg = new Pair[size * 2];
		m = rn();
	}

	static Pair seginit(int s, int e, int node) {
		if (s == e) return seg[node] = new Pair(arr[s], 1);

		int mid = (s + e) >> 1;
		Pair left = seginit(s, mid, node * 2);
		Pair right = seginit(mid + 1, e, node * 2 + 1);

		if (left.x == right.x) return seg[node] = new Pair(left.x, upperBount(left.x, e) - lowerBound(left.x, s));
		int lCount = upperBount(left.x, e) - lowerBound(left.x, s);
		int rCount = upperBount(right.x, e) - lowerBound(right.x, s);
		if (lCount > rCount) {
			return seg[node] = new Pair(left.x, lCount);
		} else if (lCount < rCount) {
			return seg[node] = new Pair(right.x, rCount);
		} else {
			return seg[node] = new Pair(0, 0);
		}
	}

	private static Pair query(int node, int l, int r, int ql, int qr) {
		if (qr < l || r < ql) return new Pair(0, 0);
		if (ql <= l && r <= qr) return seg[node];
		int mid = (l + r) / 2;
		Pair left = query(node * 2, l, mid, ql, qr);
		Pair right = query(node * 2 + 1, mid + 1, r, ql, qr);
		if (left.x == right.x)
			return new Pair(left.x, upperBount(left.x, qr) - lowerBound(left.x, ql));
		int lCount = upperBount(left.x, qr) - lowerBound(left.x, ql);
		int rCount = upperBount(right.x, qr) - lowerBound(right.x, ql);
		if (lCount > rCount) {
			return new Pair(left.x, lCount);
		} else if (lCount < rCount) {
			return new Pair(right.x, rCount);
		} else {
			return new Pair(0, 0);
		}
	}


	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		init();
		seginit(1, n, 1);
		while (m-- > 0) {
			int a = rstn(), b = rstn();
			Pair qry = query(1, 1, n, a, b);
			int k = b - a + 1;
			if (qry.y > k / 2) {
				bw.write("yes " + qry.x + "\n");
			} else {
				bw.write("no\n");
			}
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
