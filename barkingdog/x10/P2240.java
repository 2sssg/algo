package barkingdog.x10;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2240 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int T,W;
	static int[][][] dp;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		arr = new int[T];
		dp = new int[2][T][W+1];
		for(int i=0; i<T; ++i){
			arr[i] = Integer.parseInt(br.readLine())-1;
		}

		if(arr[0] == 0){
			dp[0][0][0] = 1;
		}else{
			dp[1][0][1] = 1;
		}

		for(int i=1; i<T; ++i){
			for(int j=0; j<=W; ++j){
				if(arr[i]==0){
					if(j==0){
						dp[0][i][j] = dp[0][i-1][j]+1;
						dp[1][i][j] = dp[1][i-1][j];
					}else{
						dp[0][i][j] = Math.max(dp[0][i-1][j],dp[1][i-1][j-1])+1;
						dp[1][i][j] = Math.max(dp[1][i-1][j],dp[0][i-1][j-1]);
					}
				}else{
					if(j==0){
						dp[1][i][j] = dp[1][i-1][j]+1;
						dp[0][i][j] = dp[0][i-1][j];
					}
					else{
						dp[1][i][j] = Math.max(dp[1][i-1][j],dp[0][i-1][j-1])+1;
						dp[0][i][j] = Math.max(dp[0][i-1][j], dp[1][i-1][j-1]);
					}
				}
			}
		}
		System.out.println(Math.max(Arrays.stream(dp[0][T-1]).max().getAsInt(),Arrays.stream(dp[1][T-1]).max().getAsInt()));
	}
}
