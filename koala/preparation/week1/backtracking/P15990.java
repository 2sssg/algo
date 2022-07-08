package koala.preparation.week1.backtracking;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P15990 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int t,n;
	static int MODNUM = 1000000009;
	static int[][] dp = new int[100005][3];

	static void f(){
		dp[1][0] = 1;
		dp[2][1] = 1;
		dp[3][0] = 1;
		dp[3][1] = 1;
		dp[3][2] = 1;
		for(int i=4; i<100002; ++i){
			dp[i][0] = (dp[i-1][1]+dp[i-1][2])%MODNUM;
			dp[i][1] = (dp[i-2][0]+dp[i-2][2])%MODNUM;
			dp[i][2] = (dp[i-3][0]+dp[i-3][1])%MODNUM;
		}
 	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		f();
		t = Integer.parseInt(br.readLine());
		while(t-->0){
			n = Integer.parseInt(br.readLine());
			bw.write(String.valueOf(((dp[n][0]+dp[n][1])%MODNUM+dp[n][2])%MODNUM));
			bw.write("\n");
		}
		bw.flush();
	}
}
