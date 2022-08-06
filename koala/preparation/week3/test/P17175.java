package koala.preparation.week3.test;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P17175 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] dp;
	static int n;
	static int MODNUM = 1000000007;
	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		n = Integer.parseInt(br.readLine());
		dp = new int[51];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 3;
		dp[3] = 5;
		for(int i=4; i<51; ++i) dp[i] = (dp[i-2]+dp[i-1]+1)%MODNUM;
		System.out.println(dp[n]);
	}
}
