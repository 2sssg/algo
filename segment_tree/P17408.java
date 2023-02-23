package segment_tree;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P17408 {

	static int n, m;
	static int[] arr;
	static Pair[] seg;

	static void init() throws IOException {
		n = rn();
		arr = new int[n + 1];
		for (int i = 1; i <= n; ++i) arr[i] = rstn();
		int size = 1;
		while (n > size) size *= 2;
		seg = new Pair[size * 2];
		for (int i = 0; i < size * 2; ++i) seg[i] = new Pair(0, 0);
		m = rn();
	}

	static void segInit(int s, int e, int node) {
		if (s == e) {
			seg[node].x = arr[s];
			return ;
		}
		int mid = (s + e) >> 1;
		segInit(s, mid, node * 2);
		segInit(mid + 1, e, node * 2 + 1);
		seg[node].maxPair(seg[node * 2], seg[node * 2 + 1]);
	}

	static void update(int s, int e, int node, int idx, int diff) {
		if (idx < s || e < idx) return ;
		if (s == e) {
			seg[node].x = diff;
			return ;
		}
		int mid = (s + e) >> 1;
		update(s, mid, node * 2, idx, diff);
		update(mid + 1, e, node * 2 + 1, idx, diff);
		seg[node].maxPair(seg[node * 2], seg[node * 2 + 1]);
	}

	static Pair query(int s, int e, int node, int l, int r) {
		if (r < s || e < l) return null;
		if (l <= s && e <= r) return seg[node];
		int mid = (s + e) >> 1;
		Pair ret = new Pair(0, 0);
		Pair left = query(s, mid, node * 2, l, r);
		Pair right = query(mid + 1, e, node * 2 + 1, l, r);
		ret.maxPair(left, right);
		return ret;
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		init();
		segInit(1, n, 1);
		while (m-- > 0) {
			if (rstn() == 1) {
				update(1, n, 1, rstn(), rstn());
			} else {
				Pair ret = query(1, n, 1, rstn(), rstn());
				sb.append((ret.x + ret.y)).append("\n");
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
	static class Pair{int x,y;

		@Override
		public String toString() {
			return "Pair{" +
					"x=" + x +
					", y=" + y +
					'}';
		}

		public Pair(int x, int y) {this.x = x;this.y = y;}

		public void maxPair (Pair o1, Pair o2) {
			if (o1 == null) {
				this.x = o2.x;
				this.y = o2.y;
			} else if (o2 == null) {
				this.x = o1.x;
				this.y = o1.y;
			} else {
				int[] temp = new int[]{o2.x, o2.y, o1.x, o1.y};
				Arrays.sort(temp);
				this.x = temp[2];
				this.y = temp[3];
			}
		}
	}
	static class Triple{ int x,y,z;public Triple(int x, int y,int z) {this.x = x;this.y = y;this.z = z;}}
	static class Quad{ int w,x,y,z;public Quad(int w, int x, int y,int z) {this.w = w; this.x = x;this.y = y;this.z = z;}}
	static final int IINF = Integer.MAX_VALUE;
	static final long LINF = Long.MAX_VALUE;
	static final int HIINF = Integer.MAX_VALUE / 2;
	static final long HLINF = Long.MAX_VALUE / 2;
}
