package koala.preparation.week2.dp1;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P16395 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n,k;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); k = Integer.parseInt(st.nextToken());
		dp = new int[n+2][n+2];
		for(int i=0; i<n; ++i){
			dp[i][0] = 1;
			int j = 0;
			while(dp[i][j++]!=0 || dp[i][j]!=0){
				dp[i+1][j] = dp[i][j-1]+dp[i][j];
			}
		}
		System.out.println(dp[n-1][k-1]);
	}
}

// 1 0 0 0 0 0 0
// 1 1 0 0 0 0 0
// 1 2 1 0 0 0 0
// 1 3 3 1 0 0 0
// 1 4 6 4 1 0 0
