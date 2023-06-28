package random_depense.gold.gold3;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class P1470 {
	static int n, l, silverRemain, bronzeRemain, ranking;
	static List<Pair<Integer, Integer>> rank;
	static int[] getMedal;

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		ranking = 1;
		n = rstn(); l = rstn();
		getMedal = new int[n];
		silverRemain = l; bronzeRemain = l;
		rank = new ArrayList<>();
		Triple my = new Triple(rstn() + l, rstn(), rstn());
		for (int i = 1; i < n; ++i) {
			Triple team = new Triple(rstn(), rstn(), rstn());
			if (my.x < team.x) {
				ranking++;
			} else if (my.x == team.x) {
				if (my.y < team.y) ranking++;
				else if (my.y == team.y && my.z < team.z) ranking++;
				else rank.add(new Pair<>(my.y - team.y, my.z - team.z));
			}
		}
		int size = rank.size();
		rank.add(new Pair<>(0, 0));
		Collections.sort(rank, (o1, o2) -> {
			if (o1.x == o2.x) return o1.y - o2.y;
			return o1.x - o2.x;
		});
//		pt(rank);
		int[][] dp = new int[size + 1][size + 1];
		int[] sarr = new int[size + 1];
		for (int i = 1; i <= size; ++i) {
			sarr[i] = sarr[i - 1] + rank.get(i).x;
		}
//		pt("");
		if (size == 0) {
			pt(ranking);
			return ;
		}

		for (int i = 1; i <= size; ++i) {
			dp[i][0] = max(0, dp[i - 1][0] + rank.get(i).y + 1);
			for (int j = 1; j <= i; ++j) {
				dp[i][j] = max(dp[i - 1][j - 1], dp[i - 1][j] + rank.get(j).y + 1);
			}
		}

		testPrint(dp);
		int jmin = 0;
		int ans = 0;
		for (int i = 1; i <= size; ++i) {
//			if (jmin > 0) jmin++;
//			if (rank.get(i).x + rank.get(i).y > l) {
//				jmin = 1;
//			}
			for (int j = jmin; j <= i; ++j) {
				if (sarr[i] + j > l) continue;
				if (dp[i][j] > l) continue;
//				pt("i : " + i + " j : " + j);
				ans = i;
			}
		}

		pt(ranking + ans);

	}

	////////////////////////////////입출력/////////////////////////////////////////////
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static String r() throws IOException {return br.readLine();}
	static int rn() throws IOException {return Integer.parseInt(r());}
	static long rnl() throws IOException {return Long.parseLong(r());}
	static void est() throws IOException {st = new StringTokenizer(r());}
	static int rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Integer.parseInt(st.nextToken());}
	static long rstnl() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Long.parseLong(st.nextToken());}
	static int[] ra(String delim) throws IOException {return Arrays.stream(r().split(delim)).mapToInt(Integer::parseInt).toArray();}
	static long[] ral(String delim) throws IOException {return Arrays.stream(r().split(delim)).mapToLong(Long::parseLong).toArray();}
	static int[] ra() throws IOException {return ra(" ");}
	static long[] ral() throws IOException {return ral(" ");}
	static int[] bra() throws IOException { return bra(0); }
	static int[] bra(int item) throws IOException { int[] temp=ra(); int[] ret=new int[temp.length+1]; ret[0]=item; System.arraycopy(temp,0,ret,1,temp.length); return ret;}
	static int[] rab() throws IOException { return rab(0); }
	static int[] rab(int item) throws IOException { int[] temp=ra();int[] ret=new int[temp.length+1];ret[temp.length]=item;System.arraycopy(temp,0,ret,0,temp.length);return ret;}
	static int[] brab() throws IOException { return brab(0, 0); }
	static int[] brab(int item1, int item2) throws IOException { int[] temp=ra();int[] ret=new int[temp.length+2]; ret[0]=item1; ret[temp.length+1]=item2; System.arraycopy(temp, 0, ret, 1, temp.length); return ret;}
	static long[] bral() throws IOException { return bral(0); }
	static long[] bral(int item) throws IOException { long[] temp=ral(); long[] ret = new long[temp.length+1]; ret[0]=item; System.arraycopy(temp,0,ret,1,temp.length); return ret;}
	static long[] rabl() throws IOException { return rabl(0);}
	static long[] rabl(int item) throws IOException { long[] temp = ral(); long[] ret = new long[temp.length+1]; ret[temp.length]=item; System.arraycopy(temp, 0, ret, 0, temp.length); return ret;}
	static long[] brabl() throws IOException { return brabl(0, 0); }
	static long[] brabl(int item1, int item2) throws IOException { long[] temp = ral(); long[] ret = new long[temp.length+2]; ret[0]=item1; ret[temp.length+1]=item2;System.arraycopy(temp, 0, ret, 1, temp.length); return ret;}
	static void pt(Object o) {System.out.println(o);}
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
	static class Pair<T1,T2> {T1 x;T2 y;public Pair(T1 x, T2 y) {this.x = x;this.y = y;}public String toString() {return "Pair{x="+x+", y="+y+'}';}}
	static class Triple implements Comparable<Triple> {int x;int y;int z;public Triple(int x, int y,int z) {this.x = x;this.y = y;this.z = z;}public String toString() {return "Triple{"+"x="+x+", y="+y+", z="+z+'}';}
		@Override
		public int compareTo(Triple o) {
			if (this.y == o.y) {
				return o.z - this.z;
			}
			return o.y - this.y;
		}
	}
	static class Quad {int w,x,y,z;public Quad(int w, int x, int y,int z) {this.w = w; this.x = x;this.y = y;this.z = z;}public String toString() {return "Quad{"+"w="+w+", x="+x+", y="+y+", z="+z+'}';}}
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
	static int lowerBound(int[] data, int target) {int begin = 0;int end = data.length;while(begin < end) {int mid = (begin + end) / 2;if(data[mid] >= target) end = mid;else begin = mid + 1;}return end;}
	static int upperBound(List<Integer> data, int target) {int begin = 0;int end = data.size();while(begin < end) {int mid = (begin + end) / 2;if(data.get(mid) <= target) begin = mid + 1;else end = mid;} return end;}
	static int upperBound(int[] data, int target) {int begin = 0;int end = data.length;while(begin < end) {int mid = (begin + end) / 2;if(data[mid] <= target) begin = mid + 1;else end = mid;} return end;}
	static long gcd(long a, long b){ if(b == 0) return a; return gcd(b, a % b);}
	static int gcd(int a, int b){ if(b == 0) return a; return gcd(b, a % b);}
	static long lcm(long a, long b) { return a * b / gcd(a, b); }
	static int lcm(int a, int b) { return a * b / gcd(a, b); }
	static int[] carr(int[] arr) {int[] temp = new int[arr.length]; for(int i = 1; i < arr.length; ++i) temp[i] = temp[i - 1] + arr[i]; return temp;}
	static int[] carr(int size) throws IOException {int[] temp = new int[size + 1]; for(int i = 1; i <= size; ++i) temp[i] = temp[i - 1] + rstn(); return temp;}
	////////////////////////////// 함수 //////////////////////////////////////////////
}
