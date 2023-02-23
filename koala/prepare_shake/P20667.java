package koala.prepare_shake;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P20667 {
	static int n, m, k;
	static int[][] dp;

	public static void main(String args[]) throws IOException {
		br = Source.getBufferedReader();
		n = rstn(); m = rstn(); k = rstn();
		dp = new int[501][1001];
		for(int i = 0; i < n; i++) {
			int cpu = rstn(), memory = rstn(), priority = rstn();
			for(int j = 500; j >= 0; j--) {
				for(int k = 1000; k >= 0; k--) {
					if(dp[j][k] > 0) {
						int nxtP = min(500, priority + j);
						int nxtC = Math.min(1000, cpu + k);
						dp[nxtP][nxtC] = max(dp[nxtP][nxtC], dp[j][k] + memory);
					}
				}
			}
			dp[priority][cpu] = max(memory, dp[priority][cpu]);
		}
		int solve = 501;
		for(int j=500; j >= 0; j--) {
			for(int l = 1000; l >= m; l--) {
				if (dp[j][l] >= k) solve = j;
			}
		}
		if(solve==501) {
			System.out.println(-1);
			return ;
		}

		System.out.println(solve);
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Integer.parseInt(st.nextToken());}
	static int max(int... temp) {return Arrays.stream(temp).max().getAsInt();}
	static int min(int... temp) {return Arrays.stream(temp).min().getAsInt();}
}
