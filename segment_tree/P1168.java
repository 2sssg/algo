package segment_tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1168 {
	static int n, k;
	static int[] seg;

	static void init() throws IOException {
		n = rstn(); k = rstn();
		int size = 1;
		while (size < n) size *= 2;
		seg = new int[size * 2];
	}

	static int segInit(int s, int e, int idx) {
		if (s == e) return seg[idx] = 1;
		return seg[idx] = segInit(s, (s + e) >> 1, idx * 2) + segInit(((s + e) >> 1) + 1, e, idx * 2 + 1);
	}

	static int update(int s, int e, int idx, int diff) {
		seg[idx]--;
		if (s == e) return 0;
		int mid = (s + e) >> 1;
		if (diff <= mid) return update(s, mid, idx * 2, diff);
		else return update(mid + 1, e, idx * 2 + 1, diff);
	}

	static int query(int s, int e, int idx, int loc) {
		if (s == e) return s;
		int mid = (s + e) >> 1;
		if (loc <= seg[2 * idx]) return query(s, mid, idx * 2, loc);
		else return query(mid + 1, e, idx * 2 + 1, loc - seg[2 * idx]);

	}

	public static void main(String[] args) throws IOException {
		init();
		segInit(1, n, 1);
		int index = 1;
		sb.append("<");
		for (int i = 0; i < n; i++) {
			int size = n - i; // 사람 수
			index += k - 1;
			if (index % size == 0) index = size;
			else if (index > size) index %= size;
			int num = query(1, n, 1, index);
			update(1, n, 1, num);
			sb.append(num).append(", ");
		}
		sb.setLength(sb.length() - 2);
		sb.append(">");
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
