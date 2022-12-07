package bitmask;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class P2001 {
	static int n, m, k, answer;
	static boolean[][] dp;
	static HashMap<Integer, Integer> gems;
	static List<Pair>[] adjList;

	static void init() throws IOException {
		n = rstn(); m = rstn(); k = rstn();
		dp = new boolean[n + 1][1 << k];
//		for (int i = 0; i <= n; ++i) Arrays.fill(dp[i], -1);
		gems = new HashMap<>();
		for (int i = 0; i < k; ++i) gems.put(rn(), i);
		adjList = new ArrayList[n + 1];
		for (int i = 0; i <= n; ++i) adjList[i] = new ArrayList<>();
		for (int i = 0; i < m; ++i) adjList[rstn()].add(new Pair(rstn(), rstn()));
	}

	static void dfs(int cur, int gemCnt, int curVisit) {
		if (dp[cur][curVisit]) {
			answer = Math.max(answer, gemCnt);
		}

		dp[cur][curVisit] = true;
		System.out.println("cur : " + cur + " gemCnt : " + gemCnt + " curVisit : " + Integer.toBinaryString(curVisit));
		for (Pair nxt : adjList[cur]) {
			if (nxt.y < gemCnt) continue;
			dfs(nxt.x, gemCnt, curVisit);
			if (gems.containsKey(nxt.y) && (curVisit & (1 << (gems.get(cur)))) == 0) {
				dfs(nxt.y, gemCnt + 1, curVisit | (1 << (gems.get(cur))));
			}
		}
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		init();
		dfs(1, 0, 0);
		System.out.println(answer);
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
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
