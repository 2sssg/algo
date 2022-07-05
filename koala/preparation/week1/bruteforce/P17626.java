package koala.preparation.week1.bruteforce;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P17626 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n;
	static int[] dp = new int[50005];

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		n = Integer.parseInt(br.readLine());
		dp[1] = 1;
		for(int i=2; i<=n; ++i){
			int min = Integer.MAX_VALUE;
			for(int j=1; j*j<=i; ++j){
				min = Math.min(min,dp[i-j*j]);
			}
			dp[i] = min+1;
		}
		System.out.println(dp[n]);
	}
}
