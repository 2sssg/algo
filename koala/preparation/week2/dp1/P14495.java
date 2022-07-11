package koala.preparation.week2.dp1;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class P14495 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BigInteger[] dp = new BigInteger[118];
	public static void main(String[] args) throws IOException {
		dp[1] = BigInteger.valueOf(1);
		dp[2] = BigInteger.valueOf(1);
		dp[3] = BigInteger.valueOf(1);
		for(int i=4; i<117; ++i) dp[i] = dp[i-1].add(dp[i-3]);
		System.out.println(dp[Integer.parseInt(br.readLine())]);
	}
}
