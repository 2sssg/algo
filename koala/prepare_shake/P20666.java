package koala.prepare_shake;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P20666 {
	static int n, m, p;
	static PriorityQueue<Pair> pq;
	static boolean[] check;
	static long[] arr;
	static List<Pair>[] adjList;

	static void init() throws IOException {
		n = rstn(); m = rstn();
		pq = new PriorityQueue<>((o1, o2) -> {
			if (o1.y > o2.y) return 1;
			else if (o1.y < o2.y) return -1;
			return 0;
		});
		check = new boolean[n + 1];
		arr = new long[n + 1];
		System.arraycopy(Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray(), 0, arr, 1, n);
		adjList = new ArrayList[n + 1];
		for (int i = 0; i <= n; ++i) adjList[i] = new ArrayList<>();

		p = rn();
		while (p-- > 0) {
			int a = rstn(), b = rstn(), t = rstn();
			arr[b] += t;
			adjList[a].add(new Pair(b, t));
		}
		for (int i = 1; i <= n; ++i) pq.add(new Pair(i, arr[i]));
	}

	public static void main(String[] args) throws IOException {
		init();
		long ans = 0;
		for (int i = 0; i < m; ) {
			Pair p = pq.poll();
			if (check[(int)p.x]) continue;
			i++;
			check[(int)p.x] = true;
			for (Pair down : adjList[(int)p.x]) {
				arr[(int)down.x] -= down.y;
				pq.add(new Pair(down.x, arr[(int)down.x]));
			}
			ans = Math.max(ans, p.y);
		}
		System.out.println(ans);
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
	static class Pair{long x,y;public Pair(long x, long y) {this.x = x;this.y = y;}}
	static class Triple{ int x,y,z;public Triple(int x, int y,int z) {this.x = x;this.y = y;this.z = z;}}
	static class Quad{ int w,x,y,z;public Quad(int w, int x, int y,int z) {this.w = w; this.x = x;this.y = y;this.z = z;}}
	static final int IINF = Integer.MAX_VALUE;
	static final long LINF = Long.MAX_VALUE;
	static final int HIINF = Integer.MAX_VALUE / 2;
	static final long HLINF = Long.MAX_VALUE / 2;
	static int max(int... temp) {return Arrays.stream(temp).max().getAsInt();}
	static int min(int... temp) {return Arrays.stream(temp).min().getAsInt();}
}
