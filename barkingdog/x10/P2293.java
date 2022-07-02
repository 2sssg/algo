package barkingdog.x10;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2293 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] dp = new int[10005], c = new int[10005];
	static int n, k;
	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		String[] t = br.readLine().split(" ");
		n = Integer.parseInt(t[0]);
		k = Integer.parseInt(t[1]);
		for (int i = 0; i < n; ++i)
			c[i] = Integer.parseInt(br.readLine());
		dp[0] = 1;
		for (int i = 0; i < n; ++i)
			for (int j = c[i]; j <= k; ++j)
				dp[j] += dp[j - c[i]];
		System.out.println(dp[k]);
	}
}
