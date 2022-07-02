package barkingdog.x10;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P11057 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] dp;
	static int N;
	static int MOD_NUM = 10007;

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		N = Integer.parseInt(br.readLine());
		dp = new int[N + 1][10];
		Arrays.fill(dp[1], 1);
		for (int i = 2; i < N + 1; ++i) {
			for (int j = 0; j < 10; ++j) {
				for (int k = j; k >= 0; --k) {
					dp[i][j] += dp[i - 1][k] % MOD_NUM;
					dp[i][j] %= MOD_NUM;
				}
			}
		}
		int answer = 0;
		for(int i=0; i<10; ++i){
			answer += dp[N][i]%MOD_NUM;
		}
		System.out.println(answer%MOD_NUM);
	}
}
