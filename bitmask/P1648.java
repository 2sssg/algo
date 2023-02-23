package bitmask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1648 {
	static int n ,m;
	static final int N = 15, M = 15;
	static int[][] dp = new int[N * M][(1 << M) - 1];
	static int MOD = 9901;

	static int solve(int idx, int status){
		if (idx >= n * m){
			if (idx == n * m && status == 0)
				return 1;
			return 0;
		}

		if (dp[idx][status] != -1)
			return dp[idx][status];
		dp[idx][status] = 0;

		if ((status & (1 << 0)) != 0){
			dp[idx][status] += solve(idx + 1, status >> 1);
		} else {
			if (idx % m < (m - 1) && (status & (1 << 1)) == 0)
				dp[idx][status] += solve(idx + 2, status >> 2);
			dp[idx][status] += solve(idx + 1, (status >> 1) | (1 << (m - 1)));
		}
		dp[idx][status] %= MOD;
		return dp[idx][status];
	}

	public static void main(String[] args) throws IOException {
		n = rstn(); m = rstn();
		for (int i = 0; i < N * M; ++i) Arrays.fill(dp[i], -1);
		System.out.println(solve(0, 0));
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
