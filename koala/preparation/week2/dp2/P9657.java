package koala.preparation.week2.dp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P9657 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static boolean[] dp = new boolean[1005];
	public static void main(String[] args) throws IOException {
		dp[1] = true;
		dp[3] = true;
		dp[4] = true;
		for(int i=5; i<1002; ++i){
			dp[i] = !(dp[i-1]&&dp[i-3]&&dp[i-4]);
		}
		System.out.println(Arrays.toString(dp));
		System.out.println(dp[Integer.parseInt(br.readLine())]?"SK":"CY");
	}
}
