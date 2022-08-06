package koala.preparation.week5.test;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P13302 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n,m;
	static boolean[] no;
	static int[][] dp;
	static int idx;
	static final int ONE=10000,THREE=25000,FIVE=37000;

	static int dfs(int d, int c){
		if (d > n) return 0;

		if (dp[d][c] != -1) return dp[d][c];

		dp[d][c] = Integer.MAX_VALUE;

		if (no[d]) return dp[d][c] = Math.min(dp[d][c], dfs(d + 1, c));
		else {
			if (c > 2) dp[d][c] = Math.min(dp[d][c], dfs(d + 1, c - 3));
			dp[d][c] = Math.min(dp[d][c], dfs(d + 1, c) + ONE);
			dp[d][c] = Math.min(dp[d][c], dfs(d + 3, c + 1) + THREE);
			dp[d][c] = Math.min(dp[d][c], dfs(d + 5, c + 2) + FIVE);

		}

		return dp[d][c];
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		est(); n=rstn(); m=rstn();
		no = new boolean[n+1];
		dp = new int[n+1][n+1];
		if(m!=0){
			est();
			while(st.hasMoreTokens())  no[Integer.parseInt(st.nextToken())] = true;
		}
		dp=new int[n+1][n+1];
		for(int i=0; i<=n; ++i) Arrays.fill(dp[i],-1);
		System.out.println(dfs(1,0));
	}

	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() {return Integer.parseInt(st.nextToken());}
	static int[] ra() throws IOException {return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();}
}
