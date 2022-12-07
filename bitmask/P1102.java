package bitmask;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1102 {

	static int[][] dp;
	static int[][] cost;
	static int n, p, pos, cnt;

	static int init = 1_023_525_232;

	public static void main(String[] args) throws IOException{
		br = Source.getBufferedReader();
		n = rn();
		cost = new int[n][n];
		dp = new int[n+1][1<<16];
		for(int i=0; i<n; i++) cost[i] = ra();
		String status = br.readLine();
		p = rn();

		for(int i=0; i<n+1; i++) Arrays.fill(dp[i], -1);

		for(int i=0; i < n; i++)
			if(status.charAt(i) == 'Y' && cnt++ >= 0)
				pos |= (1<<i);
		int res = dfs(cnt,pos);
		System.out.println(res == init ? -1 : res);
	}

	static int dfs(int cnt, int pNum) {
		if(cnt >= p) return 0;
		if(dp[cnt][pNum] != -1) return dp[cnt][pNum];
		dp[cnt][pNum] = init;
		for(int i=0; i<n; i++)
			if((pNum &(1<<i)) == (1<<i))
				for(int j=0; j<n; j++)
					if((i!=j) && ((pNum&(1<<j)) != (1<<j)))
						dp[cnt][pNum] = Math.min(dp[cnt][pNum], dfs(cnt+1, pNum|(1<<j)) + cost[i][j]);
		return dp[cnt][pNum];
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
	static int[] ra() throws IOException {return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();}
}


