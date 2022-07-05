package barkingdog.x10;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2133 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static long[] dp;
	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		N = Integer.parseInt(br.readLine());
		dp = new long[35];
		dp[0] = 1; dp[2] = 3;
		for(int i = 3; i <= N; ++i){
			dp[i] += dp[i-2] * 3;
			for(int j = i - 4; j >= 0; j -= 2){
				dp[i] += dp[j] * 2;
			}
		}
		System.out.println(dp[N]);
	}
}
