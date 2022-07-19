package koala.preparation.week2.extra;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2225 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n,k;

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		int[][] dp = new int[205][205];
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		Arrays.fill(dp[1],1);
		for (int i = 1; i <= k; i++) dp[i][0] = 1;
		for (int i = 2; i <= k; i++)
			for (int j = 1; j <= n; j++)
				dp[i][j] = (dp[i-1][j] + dp[i][j-1])%1000000000;
		System.out.println(dp[k][n]);
	}
}
