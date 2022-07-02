package barkingdog.x10;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11052 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int[] P,dp;

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		br.readLine();
		P = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		dp = new int[P.length+1];
		dp[1] = P[0];
		dp[2] = Math.max(dp[1]+dp[1],P[1]);
		for(int i=3; i<P.length+1; ++i){
			dp[i] = P[i-1];
			for(int j=i-1; j>=(i+1)/2; --j){
				dp[i] = Math.max(dp[i],dp[j]+dp[i-j]);
			}
		}
		System.out.println(dp[P.length]);
	}
}
