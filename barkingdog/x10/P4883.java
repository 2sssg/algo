package barkingdog.x10;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P4883 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int n;
	static int[][] arr,dp;

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		int k = 0;
		while(true){
			n = Integer.parseInt(br.readLine());
			if(n==0) break;
			k++;
			arr = new int[n][3];
			dp = new int[n][3];
			for(int i=0; i<n; ++i){
				arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}
			dp[0][1] = arr[0][1];
			dp[0][2] = dp[0][1]+arr[0][2];

			dp[1][0] = dp[0][1]+arr[1][0];
			dp[1][1] = Math.min(dp[0][1],Math.min(dp[1][0],dp[0][2]))+arr[1][1];
			dp[1][2] = Math.min(dp[1][1],Math.min(dp[0][1],dp[0][2]))+arr[1][2];
			for(int i=2; i<n; ++i){
				int min1 = Math.min(dp[i-1][0],dp[i-1][1]);
				int min2 = Math.min(dp[i-1][1], dp[i-1][2]);
				int min3 = Math.min(min1,min2);
				dp[i][0] = min1+arr[i][0];
				dp[i][1] = Math.min(min3,dp[i][0])+arr[i][1];
				dp[i][2] = Math.min(min2,dp[i][1])+arr[i][2];
			}
			bw.write(String.format("%d. %d%n",k,dp[n-1][1]));
		}
		bw.flush();
		bw.close();
	}
}
