package koala.preparation.week1.extra;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P10971 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] w,dp;
	static int n,bit;

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		n = Integer.parseInt(br.readLine());
		bit = (1<<n)-1;
		w = new int[n][n];
		dp = new int[n][bit];
		for(int i=0; i<n; ++i){
			Arrays.fill(dp[i],-1);
			w[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		System.out.println(tsp(0,1));
	}
	static int tsp(int x, int check) {
		if(check == bit) {
			if(w[x][0] == 0) return 987654321;
			else return w[x][0];
		}

		if(dp[x][check] != -1) return dp[x][check];

		dp[x][check] = 987654321;

		for(int i=0; i<n; i++) {
			int next = check | (1<<i);
			if(w[x][i] ==0 || (check & (1<<i)) != 0) continue;
			dp[x][check] = Math.min(dp[x][check], tsp(i, next) + w[x][i]);
		}
		return dp[x][check];
	}
}
