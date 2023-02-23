package extra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2449 {
	static int n, k;
	static int[] arr;
	static int[][] dp;

	static int f(int s, int e){
		if(s == e) return 0;
		if(dp[s][e] != -1) return dp[s][e];
		dp[s][e] = IINF;
		for(int mid = s; mid < e; mid++)
			dp[s][e] = min(dp[s][e], (arr[s] == arr[mid + 1] ? 0 : 1) + f(s, mid) + f(mid + 1, e));
		return dp[s][e];
	}

	public static void main(String[] args) throws IOException {
		n = rstn(); k = rstn();
		arr = ra();
		dp = new int[n][n];
		for (int i = 0; i < n; ++i) Arrays.fill(dp[i], -1);
		System.out.println(f(0, n - 1));
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Integer.parseInt(st.nextToken());}
	static int[] ra() throws IOException {return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();}
	static final int IINF = Integer.MAX_VALUE;
	static int min(int... temp) {return Arrays.stream(temp).min().getAsInt();}
}
