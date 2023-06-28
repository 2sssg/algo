package random_depense.gold.gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1947 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n;
	static long[] dp;
	public static void main(String[] args) throws IOException {
		n =	Integer.parseInt(br.readLine());
		dp = new long[n + 1];
		if (n == 1) System.out.println(0);
		else if (n == 2) System.out.println(1);
		else if (n == 3) System.out.println(2);
		else {
			dp[2] = 1;
			dp[3] = 2;
			for (int i = 4; i <= n; ++i) dp[i] = ((i - 1) * (dp[i - 1] + dp[i - 2])) % 1_000_000_000;
			System.out.println(dp[n]);
		}
	}
}
