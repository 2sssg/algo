package segment_tree;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class P3392 {
	static final int MX = 30_002;

	static int n,ans;
	static List<Quad> arr;
	static int[] seg = new int[MX * 4];
	static int[] cnt = new int[MX * 4];

	static void init() throws IOException {
		n = rn();
		ans = 0 ;
		arr = new ArrayList<>();
		for (int i = 0; i < n; ++i) {
			int x1 = rstn(), y1 = rstn(), x2 = rstn(), y2 = rstn();
			arr.add(new Quad(x1, y1, y2 - 1, 1));
			arr.add(new Quad(x2, y1, y2 - 1, -1));
		}
		arr.sort(Comparator.comparingInt(o -> o.w));
	}

	static void update(int s, int e, int node, int l, int r, int val) {
		if (e < l || r < s) return;
		if (l <= s && e <= r) {
			cnt[node] += val;
		} else {
			int mid = (s + e) >> 1;
			update(s, mid, 2 * node, l, r, val);
			update(mid + 1, e, 2 * node + 1, l, r, val);
		}

		if (cnt[node] > 0) seg[node] = e - s + 1;
	 	else {
			if (s == e) seg[node] = 0;
			else seg[node] = seg[node * 2] + seg[node * 2 + 1];
		}
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		init();
		for (int i = 0; i < arr.size(); ++i) {
			Quad cur = arr.get(i);
			if (i > 0) ans += (seg[1] * (cur.w - arr.get(i - 1).w));
			update(0, MX, 1, cur.x, cur.y, cur.z);
			System.out.println(ans);
		}
		System.out.println(ans);
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
