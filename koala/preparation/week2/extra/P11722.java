package koala.preparation.week2.extra;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P11722 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] arr,dp;
	static int n,answer;

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		n = Integer.parseInt(br.readLine());
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		dp = new int[n];
		for(int i=1; i<n; ++i){
			for(int j=i-1; j>=0; --j){
				if(arr[i]<arr[j]){
					dp[i] = Math.max(dp[i],dp[j]+1);
				}
			}
			answer = Math.max(answer,dp[i]);
		}
		System.out.println(answer+1);
	}
}
