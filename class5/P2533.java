package class5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2533 {
	static int n;
	static List<Integer>[] adjList;
	static int[][] dp;
	static boolean[] visit;

	static void dfs(int cur) {
		visit[cur] = true;
		dp[cur][0] = 0;
		dp[cur][1] = 1;

		for (int nxt: adjList[cur]) {
			if (visit[nxt]) continue;
			dfs(nxt);
			dp[cur][0] += dp[nxt][1];
			dp[cur][1] += Math.min(dp[nxt][0], dp[nxt][1]);
		}
	}

	public static void main(String[] args) throws IOException {
		n = rn();
		adjList = new ArrayList[n + 1];
		dp = new int[n + 1][2];
		visit = new boolean[n + 1];

		for (int i = 0; i <= n; ++i) adjList[i] = new ArrayList<>();
		for (int i = 1; i < n; ++i) {
			int v1 = rstn(), v2 = rstn();
			adjList[v1].add(v2);
			adjList[v2].add(v1);
		}
		dfs(1);
		System.out.println(Math.min(dp[1][0], dp[1][1]));
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
}
