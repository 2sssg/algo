package barkingdog.x10;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P17841 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static char[] unist = {'U', 'N', 'I', 'S', 'T'};
	static int[][] dp = new int[100005][6];
	static int n;
	static int MOD_NUM = 1000000007;


	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		dp = new int[100005][6];
		n = Integer.parseInt(br.readLine());
		for (int i = 1; i <= n; ++i) {
			String word = br.readLine();
			for (int j = 0; j < 5 && j < word.length(); ++j) {
				if (unist[j] == word.charAt(j)) {
					dp[i][j + 1] = 1;
				} else {
					break;
				}
			}
			int firstMatch = Integer.MAX_VALUE;
			for (int j = 0; j < 5; ++j) {
				if (word.charAt(0) == unist[j]) {
					firstMatch = Math.min(firstMatch, j);
				}
			}
			for (int j = 0; j < word.length() && j + firstMatch < 5; ++j) {
				if (word.charAt(j) == unist[j + firstMatch]) {
					dp[i][j + firstMatch + 1] += dp[i - 1][firstMatch]%MOD_NUM;
					dp[i][j + firstMatch + 1] %= MOD_NUM;
				}
				else {
					break;
				}
			}
			for (int j = 0; j < 6; ++j) {
				dp[i][j] += dp[i - 1][j]%MOD_NUM;
				dp[i][j] %= MOD_NUM;
			}
		}

		System.out.println(dp[n][5]);


	}
}
