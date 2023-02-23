package extra;

import java.io.*;
import java.util.*;

public class P18118 {
	static int t, n, m;

	static long[][] dp = new long[10][110000];
	public static void main(String[] args) throws IOException {
		t = rn();
		while (t-- > 0) {
			n = rstn(); m = rstn();
			for (int i = 0; i <= n; i++)
				for (int j = 0; j <= m; j++)
					dp[i][j] = -IINF;

			dp[0][0] = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					for (int k = 0; k < 10; k++)
						dp[i + 1][(j * 10 + k) % m] = Math.max(dp[i + 1][(j * 10 + k) % m], 10 * dp[i][j] + k);
					dp[i + 1][(j * 100 + 11) % m] = Math.max(dp[i + 1][(j * 100 + 11) % m], 100 * dp[i][j] + 11);
				}
			}
			sb.append(dp[n][0]).append("\n");
		}
		System.out.println(sb);
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Integer.parseInt(st.nextToken());}
	static final int IINF = Integer.MAX_VALUE;
}
