package bitmask;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1562 {
	static int n, answer;
	static final int MOD = 1_000_000_000;
	static int[][][] dp = new int[105][10][1 << 10];

	static int dfs(int depth, int cur, int visit) {
		if (dp[depth][cur][visit] > 0)
			return dp[depth][cur][visit];
		if (depth == n - 1) {
			if (visit == (1 << 10) - 1)
				return 1;
			return 0;
		}
		int res = 0;
		if (cur == 0) {
			res += dfs(depth + 1, cur + 1, visit | (1 << 1));
			res %= MOD;
		} else if (cur == 9) {
			res += dfs(depth + 1, cur - 1, visit | (1 << 8));
			res %= MOD;
		} else {
			res += dfs(depth + 1, cur + 1, visit | (1 << (cur + 1)));
			res %= MOD;
			res += dfs(depth + 1, cur - 1, visit | (1 << (cur - 1)));
			res %= MOD;
		}
		return (dp[depth][cur][visit] = res);
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		n = rn();
		dp = new int[105][10][1 << 10];

		for (int i = 1; i <= 9; ++i) {
			answer += dfs(0, i, 1 << i);
			answer %= MOD;
//			System.out.println(answer);
		}
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
