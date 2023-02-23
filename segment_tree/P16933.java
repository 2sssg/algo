package segment_tree;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P16933 {
	static final long inf = (long)1e15;
	static int n, q;

	static long[] arr = new long[222222];
	static long[] cum;
	static Triple[] tree = new Triple[333333];

	static void segInit(int s, int e, int idx) {
		if (s == e) {
			tree[idx] = new Triple(arr[s], arr[s], arr[s]);
			return;
		}
		long lsum = 0, rsum = 0, mid = (s + e) >> 1;
		tree[idx] = new Triple(-inf, -inf, -inf);
		for (int i = e; i >= s; i--) {
			lsum += arr[i];
			tree[idx].y = max(tree[idx].y, lsum);
		}
		for (int i = s; i <= e; i++) {
			rsum += arr[i];
			tree[idx].z = max(tree[idx].z, rsum);
		}
		segInit(s, (int)mid, idx * 2); segInit((int)mid + 1, e, idx * 2 + 1);
		tree[idx].x = max(tree[idx * 2].x, tree[idx * 2 + 1].x, tree[idx * 2].y + tree[idx * 2 + 1].z);
	}

	static Triple query(int s, int e, int idx, int l, int r) {
		if (e < l || r < s) return new Triple(-inf,-inf,-inf);
		if (l <= s && e <= r) return tree[idx];

		int mid = (s + e) >> 1;
		Triple r1 = query(s, mid, idx * 2, l, r), r2 = query(mid + 1, e, idx * 2 + 1, l, r);
		Triple ret = new Triple(0, 0, 0);
		ret.y = max(r1.y + cum[e] - cum[mid], r2.y);
		ret.z = max(r1.z, cum[mid] - cum[s - 1] + r2.z);
		ret.x = max(r1.x, r2.x, r1.y + r2.z);
		return ret;
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		n = rn(); arr = rabl(); cum = cumarr(arr);
		for (int i = 0; i < 333333; ++i) tree[i] = new Triple(0, 0, 0);
		segInit(1, n, 1);
		q = rn();
		while (q-- > 0) {
			int l = rstn(), r = rstn();
			sb.append(query(1, n, 1, l, r).x).append("\n");
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
//    static void testPrint(Pair[] arr) {for (int i = 0; i < arr.length; ++i) System.out.printf("{x : %d, y : %d}, ", arr[i].x, arr[i].y);}
	////////////////////////////////테스트 출력 ////////////////////////////////////////
	////////////////////////////////입출력/////////////////////////////////////////////

	/////////////////////////////// bfs /////////////////////////////////////////////
	static int dy[] = { -1,0,0,1,1,1,-1,-1 };
	static int dx[] = { 0,1,-1,0,-1,1,1,-1 };
	static boolean chk(int x, int y, int n, int m){return x<0 || y<0 || x>=n || y>=m;}
	/////////////////////////////// bfs /////////////////////////////////////////////

	////////////////////////////// 자료구조 ///////////////////////////////////////////
	static class Pair{int x,y;public Pair(int x, int y) {this.x = x;this.y = y;}}
	static class Triple{ long x,y,z;public Triple(long x, long y, long z) {this.x = x;this.y = y;this.z = z;}}
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
	static int[] cumarr(int[] arr) {int[] ret = new int[arr.length];for (int i = 1; i < arr.length; ++i) ret[i] = ret[i - 1] + arr[i];return ret;}
	static long[] cumarr(long[] arr) {long[] ret = new long[arr.length];for (int i = 1; i < arr.length; ++i) ret[i] = ret[i - 1] + arr[i];return ret;}
	////////////////////////////// 함수 //////////////////////////////////////////////
}
