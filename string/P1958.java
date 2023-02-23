package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1958 {
	public static void main(String[] args) throws IOException {
		int[][][] dp = new int[101][101][101];
		String s1 = br.readLine(), s2 = br.readLine(), s3 = br.readLine();
		for (int i = 1; i <= s1.length(); i++) for (int j = 1; j <= s2.length(); j++) for (int k = 1; k <= s3.length(); k++) dp[i][j][k] = s1.charAt(i - 1) == s2.charAt(j - 1) && s2.charAt(j - 1) == s3.charAt(k - 1) ? dp[i - 1][j - 1][k - 1] + 1 : max(dp[i - 1][j][k], dp[i][j - 1][k], dp[i][j][k - 1]);
		System.out.println(dp[s1.length()][s2.length()][s3.length()]);
	}
	static int max(int... temp) {return Arrays.stream(temp).max().getAsInt();}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
}
