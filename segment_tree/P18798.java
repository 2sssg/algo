package segment_tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P18798 {
	static int n, k, m, c = 260000;
	static int[] arr;
	static int[] tree = new int[1111111], fenwick = new int[555555];

	static void init() throws IOException {
		n = rstn(); k = rstn();
		arr = new int[n + 1];
		for (int i = 1; i <= n ; i++) arr[i] = rstn();
		m = rstn();
	}

	static void build(int s, int e, int index) {
		int mid = (s + e) >> 1;
		if (s == e) {
			tree[index] = arr[mid];
			if(arr[mid]==k) update2(mid, 1);
			return;
		}
		build(s, mid, index << 1);
		build(mid + 1, e, (index << 1) | 1);
		tree[index] = tree[index << 1] & tree[(index << 1) | 1];
	}

	static void update2(int loc, int v) {
		while(loc <= c) {
			fenwick[loc] += v;
			loc += (loc & -loc);
		}
	}

	static void update(int index, int s, int e, int l, int r, int x) {
		if (l > e || r < s) return;
		if ((tree[index] & x) == x) return;
		int mid = (s + e) >> 1;
		if (s == e) {
			if (tree[index] == k) update2(mid, -1);
			tree[index] |= x;
			if (tree[index] == k) update2(mid, 1);
			return;
		}
		update(index << 1, s, mid, l, r, x);
		update((index << 1) | 1, mid + 1, e, l, r, x);
		tree[index] = tree[index << 1] & tree[(index << 1) | 1];
	}

	static int query(int x) {
		int ret=0;
		while(x != 0) {
			ret += fenwick[x];
			x -= (x & -x);
		}
		return ret;
	}

	public static void main(String[] args) throws IOException {
		init();
		build(1, n, 1);
		while (m-- > 0) {
			if (rstn() == 1) {
				int l = rstn(), r = rstn(), x = rstn();
				update(1, 1, n, l, r, x);
			}
			else {
				int l = rstn(), r = rstn();
				sb.append(query(r)-query(l-1)).append("\n");
			}
		}
		System.out.println(sb);
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int swap(int localA, int localB) {return localA;}
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Integer.parseInt(st.nextToken());}
	static int[] ra() throws IOException {return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();}
	static int dy[] = { -1,0,0,1,1,1,-1,-1 };
	static int dx[] = { 0,1,-1,0,-1,1,1,-1 };
	static boolean chk(int x,int y){return (x | y) == x;}
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
