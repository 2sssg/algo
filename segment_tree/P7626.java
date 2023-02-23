package segment_tree;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class P7626 {
	static final int MX = 400_001;
	static class Vert implements Comparable<Vert> {
		int x;
		Pair y;
		boolean start;

		public Vert(int x, int y1, int y2, boolean start) {
			this.x = x;
			this.y = new Pair(y1, y2);
			this.start = start;
		}
		@Override
		public int compareTo(Vert o) { return this.x - o.x; }
	}

	static List<Vert> verts = new ArrayList<>();
	static List<Integer> ylist;
	static long[] segtree = new long[MX * 4];
	static long[] cnt = new long[MX * 4];
	static int n;

	static void init() throws IOException {
		n = rn();
		HashSet<Integer> ytemp = new HashSet<>();
		for (int i = 0; i < n; i++) {
			int x1 = rstn(), x2 = rstn(), y1 = rstn(), y2 = rstn();
			verts.add(new Vert(x1, y1 + 1, y2 + 1, true));
			verts.add(new Vert(x2, y1 + 1, y2 + 1, false));
			ytemp.add(y1 + 1);
			ytemp.add(y2 + 1);
		}
		ylist = new ArrayList<>(ytemp);
		Collections.sort(ylist);
		Collections.sort(verts);
	}

	static void updateRange(int s, int e, int idx, int l, int r, int val) {
		if (l > e || r < s) return;
		if (l <= s && e <= r) {
			cnt[idx] += val;
		} else {
			int mid = (s + e) >> 1;
			updateRange(s, mid, idx * 2, l, r, val);
			updateRange(mid + 1, e, idx * 2 + 1, l, r, val);
		}

		if (cnt[idx] != 0) {
			segtree[idx] = (long) ylist.get(e) - ylist.get(s - 1);
		} else {
			if (s == e) segtree[idx] = 0;
			else segtree[idx] = segtree[idx * 2] + segtree[idx * 2 + 1];
		}
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		init();

		long ret = 0;
		int diff_x;
		for (int i = 0; i < verts.size(); i++) {
			if (i > 0) {
				diff_x = verts.get(i).x - verts.get(i - 1).x;
				ret += segtree[1] * diff_x;
			}
			int val = verts.get(i).start ? 1 : -1;
			int y1Idx = lowerBound(ylist, verts.get(i).y.x);
			int y2Idx = lowerBound(ylist, verts.get(i).y.y);
			updateRange(1, ylist.size(), 1, y1Idx + 1, y2Idx, val);
		}

		System.out.println(ret);
	}

	////////////////////////////////입출력/////////////////////////////////////////////
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
	static long rnl() throws IOException {return Long.parseLong(br.readLine());}
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Integer.parseInt(st.nextToken());}
	static long rstnl() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Long.parseLong(st.nextToken());}
	static int[] ra() throws IOException {return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();}
	static long[] ral() throws IOException {return Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();}
	static int[] rab() throws IOException { int[] temp = ra(); int[] ret = new int[temp.length + 1]; System.arraycopy(temp, 0, ret, 1, temp.length); return ret;}
	static long[] rabl() throws IOException { long[] temp = ral(); long[] ret = new long[temp.length + 1]; System.arraycopy(temp, 0, ret, 1, temp.length); return ret;}
	////////////////////////////////테스트 출력 ////////////////////////////////////////
	static void testPrint(int[] arr){ System.out.println(Arrays.toString(arr));}
	static void testPrint(char[] arr){ System.out.println(Arrays.toString(arr));}
	static void testPrint(long[] arr){System.out.println(Arrays.toString(arr));}
	static void testPrint(int[] arr,int end){ for(int i=0; i<=end; ++i) System.out.print(arr[i]+" ");}
	static void testPrint(int[] arr,int start,int end){ for(int i=start; i<=end; ++i) System.out.print(arr[i]+" ");}
	static void testPrint(int[][] arr){ for(int[] t: arr) testPrint(t); }
	static void testPrint(long[][] arr){ for(long[] t: arr) testPrint(t); }
	static void testPrint(char[][] arr){ for(char[] t: arr) testPrint(t); }
	static void testPrint(int[][] arr, int er, int ec){ for(int i=0; i<=er; ++i) testPrint(arr[i], ec); }
	static void testPrint(Pair[] arr) {for (int i = 0; i < arr.length; ++i) System.out.printf("{x : %d, y : %d}, ", arr[i].x, arr[i].y);}
	////////////////////////////////테스트 출력 ////////////////////////////////////////
	////////////////////////////////입출력/////////////////////////////////////////////

	/////////////////////////////// bfs /////////////////////////////////////////////
	static int dy[] = { -1,0,0,1,1,1,-1,-1 };
	static int dx[] = { 0,1,-1,0,-1,1,1,-1 };
	static boolean chk(int x, int y, int n, int m){return x<0 || y<0 || x>=n || y>=m;}
	/////////////////////////////// bfs /////////////////////////////////////////////

	////////////////////////////// 자료구조 ///////////////////////////////////////////
	static class Pair{int x,y;public Pair(int x, int y) {this.x = x;this.y = y;}}
	static class Triple{ int x,y,z;public Triple(int x, int y,int z) {this.x = x;this.y = y;this.z = z;}}
	static class Quad{ int w,x,y,z;public Quad(int w, int x, int y,int z) {this.w = w; this.x = x;this.y = y;this.z = z;}}
	////////////////////////////// 자료구조 ///////////////////////////////////////////

	////////////////////////////// 상수 //////////////////////////////////////////////
	static final int IINF = Integer.MAX_VALUE;
	static final long LINF = Long.MAX_VALUE;
	static final int HIINF = Integer.MAX_VALUE / 2;
	static final long HLINF = Long.MAX_VALUE / 2;
	////////////////////////////// 상수 //////////////////////////////////////////////

	////////////////////////////// 함수 //////////////////////////////////////////////
	// b = swap(a, a = b);
	static int swap(int localA, int localB) {return localA;}
	static int max(int... temp) {return Arrays.stream(temp).max().getAsInt();}
	static int min(int... temp) {return Arrays.stream(temp).min().getAsInt();}
	static long max(long... temp) {return Arrays.stream(temp).max().getAsLong();}
	static long min(long... temp) {return Arrays.stream(temp).min().getAsLong();}
	static int lowerBound(List<Integer> data, int target) {int begin = 0;int end = data.size();while(begin < end) {int mid = (begin + end) / 2;if(data.get(mid) >= target) end = mid;else begin = mid + 1;}return end;}
	static int upperBound(List<Integer> data, int target) {int begin = 0;int end = data.size();while(begin < end) {int mid = (begin + end) / 2;if(data.get(mid) <= target) begin = mid + 1;else end = mid;} return end;}
	////////////////////////////// 함수 //////////////////////////////////////////////
}
