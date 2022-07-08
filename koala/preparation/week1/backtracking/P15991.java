package koala.preparation.week1.backtracking;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P15991 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int t,MODNUM=1000000009;
	static int[] dp = new int[100005];


	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 2;
		dp[4] = 3;
		dp[5] = 3;
		dp[6] = 6;
		for(int i=7; i<100002; ++i){
			dp[i] = (dp[i-2]+dp[i-4])%MODNUM;
			dp[i] = (dp[i]+dp[i-6])%MODNUM;
		}
		t = Integer.parseInt(br.readLine());
		while(t-->0){
			bw.write(String.valueOf(dp[Integer.parseInt(br.readLine())]));
			bw.write("\n");
		}
		bw.flush();
	}
}
