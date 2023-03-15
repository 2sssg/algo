package extra;

import java.util.*;
import java.io.*;

public class P24232 {
	static final int IN = 1, OUT = 0;
	static int n;
	static ArrayList<Triple>[] adjList;
	static int[] dp;
	static boolean[] visited;
	static int[] rev;

	static void init() throws IOException {
		n = rn();
		dp = new int[n + 1];
		adjList = new ArrayList[n + 1];
		visited = new boolean[n + 1];
		for (int i = 0; i < n + 1; i++) adjList[i] = new ArrayList<>();
		rev = new int[n + 1];
		for (int i = 0; i < n - 1; i++) {
			int u = rstn(), v = rstn();
			adjList[u].add(new Triple(v, OUT, i + 1));
			adjList[v].add(new Triple(u, IN, i + 1));
		}
	}

	private static int dfs1(int root) {
		visited[root] = true;
		int ret = 0;
		for (Triple next : adjList[root]) if (!visited[next.x]) ret += dfs1(next.x) + next.y;
		return ret;
	}



	private static void dfs2(int from, int to, int dir) {
		visited[to] = true;
		if (dir == IN) dp[to] += dp[from] - 1;
		else if (dir == OUT) dp[to] += dp[from] + 1;
		for (Triple next : adjList[to]) if (!visited[next.x]) dfs2(to, next.x, next.y);
	}


	private static void dfs3(int root) {
		visited[root] = true;
		for (Triple next : adjList[root]) {
			if (visited[next.x]) continue;
			dfs3(next.x);
			rev[next.z] = next.y;
		}
	}

	public static void main(String[] args) throws Exception {
		init();
		dp[1] = dfs1(1);

		Arrays.fill(visited, false);
		visited[1] = true;
		for (Triple next : adjList[1]) dfs2(1, next.x, next.y);


		int min = Integer.MAX_VALUE;
		int minNode = 0;
		for (int i = 1; i < n + 1; i++) {
			int cost = dp[i];
			if (cost < min) {
				min = cost;
				minNode = i;
			}
		}

		Arrays.fill(visited, false);
		dfs3(minNode);

		for (int i = 1; i < n; i++) sb.append(rev[i]);
		System.out.println(sb);
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
	static class Triple{ int x,y,z;public Triple(int x, int y,int z) {this.x = x;this.y = y;this.z = z;}}
	static class Quad{ int w,x,y,z;public Quad(int w, int x, int y,int z) {this.w = w; this.x = x;this.y = y;this.z = z;}}
	////////////////////////////// 자료구조 ///////////////////////////////////////////

	////////////////////////////// 상수 //////////////////////////////////////////////
	static final int IINF = Integer.MAX_VALUE;
	static final long LINF = Long.MAX_VALUE;
	static final int HIINF = Integer.MAX_VALUE / 2;
	static final long HLINF = Long.MAX_VALUE / 2;
	static final String ALPHA = "abcdefghijklmnopqrstuvwxyz";
	static final String CAP_ALPHA = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

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
	static long gcd(long a, long b){ if(b == 0) return a; return gcd(b, a % b);}
	static int gcd(int a, int b){ if(b == 0) return a; return gcd(b, a % b);}
	static long lcm(long a, long b) { return a * b / gcd(a, b); }
	static int lcm(int a, int b) { return a * b / gcd(a, b); }
	////////////////////////////// 함수 //////////////////////////////////////////////
}
