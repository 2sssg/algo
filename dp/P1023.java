package dp;

import java.io.*;
import java.util.*;

public class P1023 {
	static long[][][] dp;
	static int n;
	static long k;

	static long f(int length, int cnt, int check, int no) {
		if (n < length || n < cnt) return 0;
		if (dp[length][cnt][0] != -1) return dp[length][cnt][0];
		if (length == n) {
			if (check == 0) return 0;
			else return dp[length][cnt][0] = 1;
		}
		if (check < 0) no = 1;
		if (no == 1)
			return (dp[length][cnt][0] = ff(length + 1, cnt) + ff(length + 1, cnt + 1));
		return dp[length][cnt][0] = f(length + 1, cnt, check + 1, no)
				+ f(length + 1, cnt + 1, check - 1, no);
	}

	static long ff(int length, int cnt) {
		if (n < length || n < cnt) return 0;
		if (dp[length][cnt][1] != -1) return dp[length][cnt][1];
		if (length == n) return dp[length][cnt][1] = 1;
		return (dp[length][cnt][1] = ff(length + 1, cnt) + ff(length + 1, cnt + 1));
	}

	static void fff(int length, int cnt, int check, int no, long nth) {
		if (length == n) return;
		if (check < 0) no = 1;
		if (dp[length + 1][cnt][no] < nth) {
			sb.append(')');
			fff(length + 1, cnt + 1, check - 1, no, nth - dp[length + 1][cnt][no]);
		} else {
			sb.append('(');
			fff(length + 1, cnt, check + 1, no, nth);
		}
	}

	public static void main(String[] args) throws IOException {
		n = rstn(); k = rstnl();
		dp = new long[n + 5][n + 5][2];
		for (int i = 0; i < n + 5; ++i) for (int j = 0; j < n + 5; ++j) Arrays.fill(dp[i][j], -1);
		if (f(0, 0, 0, 0) < k + 1) sb.append(-1);
		else fff(0, 0, 0, 0, k + 1);
		System.out.println(sb);
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Integer.parseInt(st.nextToken());}
	static long rstnl() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Long.parseLong(st.nextToken());}
}
