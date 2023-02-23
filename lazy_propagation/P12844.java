package lazy_propagation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P12844 {
	static int n, m;
	static int[] arr, seg, lazy;

	static void init() throws IOException {
		n = rn(); arr = rab(); m = rn();
		int size = 1;
		while (size < n) size *= 2;
		seg = new int[size * 2];
		lazy = new int[size * 2];
	}

	static void segInit(int s, int e, int idx) {
		if (s == e) { seg[idx] = arr[s]; return; }
		int mid = (s + e) >> 1;
		segInit(s, mid, idx * 2);
		segInit(mid + 1, e, idx * 2 + 1);
		seg[idx] = seg[idx * 2] ^ seg[idx * 2 + 1];
	}

	static void lazyProp(int start, int end, int idx) {
		if (lazy[idx] != 0) {
			if ((end - start + 1) % 2 == 1) {
				seg[idx] ^= lazy[idx];
			}
			if (start != end) {
				lazy[idx * 2] ^= lazy[idx];
				lazy[idx * 2 + 1] ^= lazy[idx];
			}
			lazy[idx] = 0;
		}
	}

	static void update(int s, int e, int idx, int diff, int l, int r) {
		lazyProp(s, e, idx);
		if (r < s || e < l) return;
		if (l <= s && e <= r) {
			lazy[idx] ^= diff;
			lazyProp(s, e, idx);
			return;
		}

		int mid = (s + e) >> 1;
		update(s, mid, idx * 2, diff, l, r);
		update(mid + 1, e, idx * 2 + 1, diff, l, r);

		seg[idx] = seg[idx * 2] ^ seg[idx * 2 + 1];
	}

	static int query(int s, int e, int idx, int l, int r) {
		lazyProp(s, e, idx);
		if (r < s || e < l) return 0;
		if (l <= s && e <= r) return seg[idx];
		int mid = (s + e) >> 1;
		return query(s, mid, idx * 2, l, r) ^ query(mid + 1, e, idx * 2 + 1, l, r);
	}

	public static void main(String[] args) throws IOException {
		init();
		segInit(1, n, 1);
		while (m-- > 0) {
			if (rstn() == 1) {
				int i = rstn(), j = rstn(), k = rstn();
				update( 1, n, 1,  k, i + 1, j + 1);
			} else {
				int i = rstn(), j = rstn();
				sb.append(query(1, n, 1, i + 1, j + 1)).append("\n");
			}
		}
		System.out.print(sb);
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int swap(int localA, int localB) {return localA;}
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Integer.parseInt(st.nextToken());}
	static long rstnl() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Long.parseLong(st.nextToken());}
	static int[] ra() throws IOException {return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();}
	static long[] ral() throws IOException {return Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();}
	static int[] rab() throws IOException { int[] temp = ra(); int[] ret = new int[temp.length + 1]; System.arraycopy(temp, 0, ret, 1, temp.length); return ret;}
	static long[] rabl() throws IOException { long[] temp = ral(); long[] ret = new long[temp.length + 1]; System.arraycopy(temp, 0, ret, 1, temp.length); return ret;}
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
	static long max(long... temp) {return Arrays.stream(temp).max().getAsLong();}
	static long min(long... temp) {return Arrays.stream(temp).min().getAsLong();}
}
