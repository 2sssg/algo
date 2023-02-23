package koala.prepare_shake;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P17300 {
	static int n;
	static int[] arr;
	static boolean[] check = new boolean[10];
	static List<Pair>[] adjList;

	static void init() {
		adjList = new ArrayList[10];
		for (int i = 0; i < 10; ++i) adjList[i] = new ArrayList<>();

		adjList[1].add(new Pair(2,3));
		adjList[1].add(new Pair(5,9));
		adjList[1].add(new Pair(4,7));
		adjList[1].add(new Pair(-1,8));
		adjList[1].add(new Pair(-1,6));

		adjList[2].add(new Pair(-1,3));
		adjList[2].add(new Pair(-1,1));
		adjList[2].add(new Pair(-1,4));
		adjList[2].add(new Pair(-1,6));
		adjList[2].add(new Pair(-1,7));
		adjList[2].add(new Pair(-1,9));
		adjList[2].add(new Pair(5,8));

		adjList[3].add(new Pair(2,1));
		adjList[3].add(new Pair(5,7));
		adjList[3].add(new Pair(6,9));
		adjList[3].add(new Pair(-1,4));
		adjList[3].add(new Pair(-1,8));

		adjList[4].add(new Pair(-1,1));
		adjList[4].add(new Pair(-1,7));
		adjList[4].add(new Pair(-1,2));
		adjList[4].add(new Pair(-1,8));
		adjList[4].add(new Pair(-1,3));
		adjList[4].add(new Pair(-1,9));
		adjList[4].add(new Pair(5,6));

		adjList[5].add(new Pair(-1,1));
		adjList[5].add(new Pair(-1,2));
		adjList[5].add(new Pair(-1,3));
		adjList[5].add(new Pair(-1,4));
		adjList[5].add(new Pair(-1,6));
		adjList[5].add(new Pair(-1,7));
		adjList[5].add(new Pair(-1,8));
		adjList[5].add(new Pair(-1,9));

		adjList[6].add(new Pair(-1,3));
		adjList[6].add(new Pair(-1,2));
		adjList[6].add(new Pair(-1,8));
		adjList[6].add(new Pair(-1,9));
		adjList[6].add(new Pair(-1,1));
		adjList[6].add(new Pair(-1,7));
		adjList[6].add(new Pair(5,4));

		adjList[7].add(new Pair(4,1));
		adjList[7].add(new Pair(5,3));
		adjList[7].add(new Pair(8,9));
		adjList[7].add(new Pair(-1,2));
		adjList[7].add(new Pair(-1,6));

		adjList[8].add(new Pair(-1,7));
		adjList[8].add(new Pair(-1,4));
		adjList[8].add(new Pair(5,2));
		adjList[8].add(new Pair(-1,6));
		adjList[8].add(new Pair(-1,9));
		adjList[8].add(new Pair(-1,1));
		adjList[8].add(new Pair(-1,3));

		adjList[9].add(new Pair(8,7));
		adjList[9].add(new Pair(5,1));
		adjList[9].add(new Pair(6,3));
		adjList[9].add(new Pair(-1,2));
		adjList[9].add(new Pair(-1,4));
	}

	public static void main(String[] args) throws IOException {
		n = rn();
		arr = ra();
		if (n < 3 || n > 9) {
			System.out.println("NO");
			return ;
		}
		init();

		for (int i = 0; i < n - 1; ++i) {
			int cur = arr[i];
			check[cur] = true;
			int next = arr[i + 1];
			if (check[next]) {
				System.out.println("NO");
				return ;
			}

			for (Pair nxt : adjList[cur]) {
				if (nxt.x != -1 && check[nxt.x]) nxt.x = -1;
				if (nxt.y != -1 && check[nxt.y]) nxt.y = -1;
				if (nxt.x == -1 && nxt.y == -1) continue;

				if (nxt.x != -1) {
					if (next == nxt.x) {
						nxt.x = -1;
						check[next] = true;
						break;
					}
				} else {
					if (next == nxt.y) {
						nxt.y = -1;
						check[next] = true;
						break;
					}
				}
			}
			if (!check[next]) {
				System.out.println("NO");
				return ;
			}
		}
		System.out.println("YES");
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
