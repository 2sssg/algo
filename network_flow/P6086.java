package network_flow;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class P6086 {
	static int n;
	static int[][] capacity, flow;
	static final int MAXN = 52;

	static int alphatoi(char c) {
		if ('a' <= c && c <= 'z') return c - 'a' + 26;
		else if ('A' <= c && c <= 'Z') return c - 'A';
		else return -1;
	}

	static void init() throws IOException {
		n = rn();
		capacity = new int[MAXN][MAXN];
		flow = new int[MAXN][MAXN];
		for (int i = 0; i < n; ++i) {
			int u,v,cap;
			est();
			u = alphatoi(st.nextToken().charAt(0));
			v = alphatoi(st.nextToken().charAt(0));
			cap = rstn();
			capacity[u][v] += cap;
			capacity[v][u] += cap;
		}
	}

	static int maximumFlow(int source, int sink) {
		int totalFlow = 0;

		while (true) {
			int[] parent = new int[MAXN];
			Arrays.fill(parent, -1);
			Queue<Integer> q = new ArrayDeque<>();
			q.add(source);

			while (!q.isEmpty() && parent[sink] == -1) {
				int here = q.poll();
				for (int there = 0; there < MAXN; ++there) {
					if (capacity[here][there] - flow[here][there] > 0 && parent[there] == -1) {
						q.add(there);
						parent[there] = here;
					}
				}
			}

			if (parent[sink] == -1) break;

			int amount = IINF;
			for(int p = sink; p != source; p = parent[p])
				amount = Math.min(capacity[parent[p]][p] - flow[parent[p]][p], amount);

			for(int p = sink; p != source; p = parent[p]) {
				flow[parent[p]][p] += amount;
				flow[p][parent[p]] -= amount;
			}

			totalFlow += amount;
		}
		return totalFlow;
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		init();
		System.out.println(maximumFlow(0, 25));
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
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static boolean chk(int x, int y, int n, int m){return x<0 || y<0 || x>=n || y>=m;}
	static class Pair{int x,y;public Pair(int x, int y) {this.x = x;this.y = y;}}
	static class Triple{ int x,y,z;public Triple(int x, int y,int z) {this.x = x;this.y = y;this.z = z;}}
	static class Quad{ int w,x,y,z;public Quad(int w, int x, int y,int z) {this.w = w; this.x = x;this.y = y;this.z = z;}}
	static final int IINF = Integer.MAX_VALUE;
	static final long LINF = Long.MAX_VALUE;
	static final int HIINF = Integer.MAX_VALUE / 2;
	static final long HLINF = Long.MAX_VALUE / 2;
}
