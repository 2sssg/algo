package koala.preparation.week2.dp2;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2631 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n;
	static int[] arr,dp;

	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		n = rn();
		arr = new int[n]; dp = new int[n];
		for(int i=0; i<n; ++i) {
			arr[i] = rn();
			for(int j=i-1; j>=0; --j)
				if(arr[i]>arr[j])
					dp[i] = Math.max(dp[i],dp[j]+1);
		}
		System.out.println(n-Arrays.stream(dp).max().getAsInt()-1);
	}
}


// 3 7 5 2 6 1 4