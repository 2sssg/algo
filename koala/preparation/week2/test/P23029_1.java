package koala.preparation.week2.test;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P23029_1 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] arr;
	static int[][] dp;
	static int n;
	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		n = Integer.parseInt(br.readLine());
		if(n==1){
			System.out.println(br.readLine());
			return;
		}
		arr = new int[n];
		dp = new int[n][2];
		for(int i=0; i<n; ++i) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		dp[0][0] = arr[0];
		dp[1][0] = arr[1];
		dp[1][1] = dp[0][0] + arr[1]/2;
		for(int i=2; i<n; ++i){
			dp[i][0] = Math.max(dp[i-2][0],dp[i-2][1])+arr[i];
			dp[i][1] = dp[i-1][0]+arr[i]/2;
		}
		System.out.println(Math.max(dp[n-1][0],dp[n-1][1]));
	}
}

