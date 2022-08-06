package koala.preparation.week4.prefixsum;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2315 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, m;
	static int[] loc, sum;
	static long[][][] dp = new long[1005][1005][2];

	static void init() throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		loc = new int[n + 1];
		sum = new int[n + 1];
		for (int i = 1; i <= n; ++i) {
			st = new StringTokenizer(br.readLine());
			loc[i] = Integer.parseInt(st.nextToken());
			sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < 1005; ++i) {
			for (int j = 0; j < 1005; ++j) {
				dp[i][j][0] = -1;
				dp[i][j][1] = -1;
			}
		}
	}

	static long solve(int left, int right, int isLeft) {

		if (left == 1 && right == n) {
			return 0;
		}

		if (dp[left][right][isLeft] != -1) {
			return dp[left][right][isLeft];
		}

		int curLoc = isLeft == 0 ? left : right;
		long result = Long.MAX_VALUE;
		if (left > 1) {
			result = solve(left - 1, right, 0) + (long) (loc[curLoc] - loc[left - 1]) *
				(sum[n] - sum[right] + sum[left - 1]);
		}
		if (right < n) {
			result = Math.min(
				result,
				solve(left, right + 1, 1) + (long) (loc[right + 1] - loc[curLoc]) *
					(sum[n] - sum[right] + sum[left - 1])
			);
		}
		dp[left][right][isLeft] = result;
		return result;
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		init();
		System.out.println(solve(m, m, 0));
	}
}
