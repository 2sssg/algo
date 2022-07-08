package koala.preparation.week1.backtracking;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P15993 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int t,n,MODNUM=1000000009;
	static int[][] dp = new int[100005][2];

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		t = Integer.parseInt(br.readLine());
		dp[1][1] = 1;
		dp[2][0] = 1;
		dp[2][1] = 1;
		dp[3][0] = 2;
		dp[3][1] = 2;
		for(int i=4; i<100002; ++i){
			dp[i][0] = ((dp[i-1][1]+dp[i-2][1])%MODNUM+dp[i-3][1])%MODNUM;
			dp[i][1] = ((dp[i-1][0]+dp[i-2][0])%MODNUM+dp[i-3][0])%MODNUM;
		}

		while(t-->0){
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			bw.write(String.format("%d %d%n",dp[n][1],dp[n][0]));
		}
		bw.flush();
	}
}
