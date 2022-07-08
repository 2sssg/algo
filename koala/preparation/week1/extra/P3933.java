package koala.preparation.week1.extra;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P3933 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n;
	static int[][] dp = new int[40000][5];
	static void f(){
		for (int i=1; i*i<40000; i++) {
			dp[i * i][1] = 1;
			for (int j = i * i; j < 40000; j++) {
				dp[j][2] += dp[j - i * i][1];
				dp[j][3] += dp[j - i * i][2];
				dp[j][4] += dp[j - i * i][3];
			}
		}
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		f();
		while(true){
			n = Integer.parseInt(br.readLine());
			if(n==0) break;
			System.out.println(dp[n][4]+dp[n][1]+dp[n][2]+dp[n][3]);
		}
	}
}
