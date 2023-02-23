package segment_tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class P9345 {
	static final int MX = 100_005;
	static int t, n, k;
	static Pair[] seg;
	static int[] arr;

	static Pair segInit(int s, int e, int idx) {
		if (s == e) return seg[idx] = new Pair(s, s);
		int mid = (s + e) >> 1;
		Pair l = segInit(s, mid, idx * 2);
		Pair r = segInit(mid + 1, e, idx * 2 + 1);
		return seg[idx] = new Pair(min(l.x, r.x), max(l.y, r.y));
	}

	static Pair query(int s, int e, int idx, int l, int r) {
		if (e < l || r < s) return new Pair(IINF, -IINF);
		if (l <= s && e <= r) return seg[idx];
		int mid = (s + e) >> 1;
		Pair ll = query(s, mid, idx * 2, l, r);
		Pair rr = query(mid + 1, e, idx * 2 + 1, l, r);
		return new Pair(min(ll.x, rr.x), max(ll.y, rr.y));
	}

	static Pair update(int s, int e, int idx, int target, int diff) {
		if (target < s || target > e) return seg[idx];
		if (s == e) return seg[idx] = new Pair(diff, diff);
		int mid = (s + e) >> 1;
		Pair ll = update( s, mid, idx * 2, target, diff);
		Pair rr = update( mid + 1, e, idx * 2 + 1, target, diff);
		return seg[idx] = new Pair(min(ll.x, rr.x), max(ll.y, rr.y));
	}

	public static void main(String[] args) throws IOException {
		t = rn();
		seg = new Pair[MX * 4];
		arr = new int[MX];
		for (int i = 0; i < MX * 4; ++i) seg[i] = new Pair(0, 0);
		while (t-- > 0) {
			n = rstn(); k = rstn();
			segInit(0, n - 1, 1);
			for (int i = 0; i < n; i++) arr[i] = i;
			while (k-- > 0) {
				int q = rstn(), a = rstn(), b = rstn();
				if (q == 0) {
					update(0, n - 1, 1, arr[a], b);
					update(0, n - 1, 1, arr[b], a);
					arr[b] = swap(arr[a], arr[a] = arr[b]);
				} else {
					Pair p = query(0, n - 1, 1, a, b);
					sb.append(a == p.x && b == p.y ? "YES\n" : "NO\n");
				}
			}
		}
		System.out.println(sb);
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
	////////////////////////////// 함수 //////////////////////////////////////////////









}
