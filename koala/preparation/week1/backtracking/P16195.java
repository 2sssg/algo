package koala.preparation.week1.backtracking;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P16195 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int t,n,m,MODNUM=1000000009;
	static int[][] dp = new int[1005][1005];

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		t = Integer.parseInt(br.readLine());
		dp[1][1] = 1;
		dp[2][1] = 1;
		dp[2][2] = 1;
		dp[3][1] = 1;
		dp[3][2] = 2;
		dp[3][3] = 1;
		for(int i=4; i<1001; ++i){
			for(int j=1; j<=i; ++j){
				dp[i][j] = ((dp[i-1][j-1]+dp[i-2][j-1])%MODNUM+dp[i-3][j-1])%MODNUM;
			}
		}

		while(t-->0){
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			int sum = 0;
			for(int i=0; i<=m; ++i){
				sum = (sum + dp[n][i])%MODNUM;
			}
			bw.write(String.format("%d%n",sum));
		}
		bw.flush();
	}
}
