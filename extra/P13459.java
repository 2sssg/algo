package extra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

public class P13459 {
	static int n, m;

	static char[][] arr;
	static HashSet<Pairr> visit = new HashSet<>();

	static int getRow(int x, int y) {
		int ret = -1;
		for (int i = x + 1; i < arr.length; ++i) {
			if (arr[i][y] == '#' || arr[i][y] == 'R' || arr[i][y] == 'B') break;
			ret = i;
			if (arr[i][y] == 'O') break;
		}
		return ret;
	}

	static void slide() {
		for (int i = arr.length - 2; i > 0; --i) {
			for (int j = 1; j < arr[0].length - 1; ++j) {
				if (arr[i][j] == 'R' || arr[i][j] == 'B') {
					int row = getRow(i, j);
					if (row == -1) continue;
					if (arr[row][j] == 'O' && arr[i][j] == 'B') {
						arr[row][i] = 'B';
						arr[i][j] = 'X';
					} else {
						arr[row][j] = arr[i][j];
						arr[i][j] = '.';
					}
				}
			}
		}
	}

	static void rotation() {
		char[][] temp = new char[arr[0].length][arr.length];
		for (int i = 0; i < arr.length; ++i) {
			for (int j = 0; j < arr[0].length; ++j) {
				temp[arr[0].length - j - 1][i] = arr[i][j];
			}
		}
		arr = temp;
	}

	static int check() {
		for (int i = 0; i < arr.length; ++i) {
			for (int j = 0; j < arr[0].length; ++j) {
				if (arr[i][j] == 'X') return -1;
				if(arr[i][j] == 'O') return 0;
			}
		}
		return 1;
	}

	static boolean check2(int x, int y) {
		for (int i = x + 1; i < arr.length; ++i) {
			if (arr[i][y] == '#') return true;
			if (arr[i][y] == 'O') return false;
		}
		return true;
	}

	static char[][] copy() {
		char[][] temp = new char[arr.length][arr[0].length];
		for (int i = 0; i < arr.length; ++i) {
			for (int j = 0; j < arr[0].length; ++j) {
				temp[i][j] = arr[i][j];
			}
		}
		return temp;
	}

	static boolean dfs(int rotCnt, int depth) {

		for (int i = 0; i < 4 - rotCnt; ++i) rotation();
		System.out.println(1);
		testPrint(arr);
		System.out.println();
		if (depth > 10) return false;
		int c = check();
		if (c == 1) return true;
		else if (c == -1) return false;
		System.out.println(2);


		Pair r = new Pair(0, 0);
		Pair b = new Pair(0, 0);
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				if (arr[i][j] == 'R') {
					r = new Pair(i, j);
				} else if (arr[i][j] == 'B') {
					b = new Pair(i, j);
				}
			}
		}
		Pairr prr = new Pairr(r, b);
		if (visit.contains(prr)) return false;
		visit.add(prr);

		testPrint(arr);
		System.out.println();


		l: for (int i = 1; i <= 4; ++i) {
			rotation();
			for (int x = 0; x < arr.length; ++x) {
				for (int y = 0; y < arr[0].length; ++y) {
					if (arr[x][y] == 'B') {
						if (!check2(x, y)) continue l;
					}
				}
			}
			char[][] temp = copy();
			slide();
			if (dfs(i, depth + 1)) return true;
			arr = temp;
		}
		for (int i = 0; i < rotCnt; ++i) rotation();
		return false;
	}



	public static void main(String[] args) throws IOException {
		arr = new char[n = rstn()][m = rstn()];

		for (int i = 0; i < n; ++i) arr[i] = r().toCharArray();


		if (dfs(0, 0)) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
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
	static class Pairr{
		Pair r,b;

		public Pairr(Pair r, Pair b) {
			this.r = r;
			this.b = b;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) {
				return true;
			}
			if (o == null || getClass() != o.getClass()) {
				return false;
			}
			Pairr pairr = (Pairr) o;
			return r.equals(pairr.r) && b.equals(pairr.b);
		}

		@Override
		public int hashCode() {
			return Objects.hash(r, b);
		}
	}
	static class Pair{int x,y;public Pair(int x, int y) {this.x = x;this.y = y;}

		@Override
		public boolean equals(Object o) {
			if (this == o) {
				return true;
			}
			if (o == null || getClass() != o.getClass()) {
				return false;
			}
			Pair pair = (Pair) o;
			return x == pair.x && y == pair.y;
		}

		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}
	}
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
	static long gcd(long a, long b){ if(b == 0) return a; return gcd(b, a % b);}
	static int gcd(int a, int b){ if(b == 0) return a; return gcd(b, a % b);}
	static long lcm(long a, long b) { return a * b / gcd(a, b); }
	static int lcm(int a, int b) { return a * b / gcd(a, b); }
	////////////////////////////// 함수 //////////////////////////////////////////////
}
