package barkingdog.x10;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P9465 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int T,M;
	static int[][] arr;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		T = Integer.parseInt(br.readLine());
		while(T-->0){
			M = Integer.parseInt(br.readLine());
			if(M==1){
				bw.write(String.valueOf(Math.max(Integer.parseInt(br.readLine()),Integer.parseInt(br.readLine()))));
				bw.write("\n");
				continue;
			}
			arr = new int[2][M];
			dp = new int[2][M];
			arr[0] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			arr[1] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			dp[0][0] = arr[0][0];
			dp[1][0] = arr[1][0];
			dp[0][1] = arr[1][0]+arr[0][1];
			dp[1][1] = arr[0][0]+arr[1][1];
			for(int i=2; i<M; ++i){
				dp[0][i] = Math.max(dp[1][i-1],dp[1][i-2])+arr[0][i];
				dp[1][i] = Math.max(dp[0][i-1],dp[0][i-2])+arr[1][i];
			}
			bw.write(String.valueOf(Math.max(dp[0][M-1],dp[1][M-1])));
			bw.write("\n");
		}

		bw.flush();
		bw.close();
	}
}
