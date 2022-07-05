package barkingdog.x10;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1788 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N,MODNUM = 1000000000;
	static int[] dp = new int[2000002];

	static void fibo(){
		dp[1000001] = 1;
		for(int i=1000002; i<2000002; ++i){
			dp[i] = (dp[i-1]+dp[i-2])%MODNUM;
		}
		for(int i=999999; i>=0; --i){
			dp[i] = (dp[i+2]-dp[i+1])%MODNUM;
		}
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		N = Integer.parseInt(br.readLine());
		fibo();
		System.out.println(dp[N+1000000]==0?"0":dp[N+1000000]>0?"1":"-1");
		System.out.println(Math.abs(dp[N+1000000]));
	}
}
