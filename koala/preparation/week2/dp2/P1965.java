package koala.preparation.week2.dp2;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1965 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n;
	static int[] arr,dp = new int[1001];
	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		n = Integer.parseInt(br.readLine());
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		for(int i=1; i<n; ++i)
			for(int j=i-1; j>=0; --j)
				if(arr[i]>arr[j])
					dp[i] = Math.max(dp[i],dp[j]+1);
		System.out.println(Arrays.stream(dp).max().getAsInt()+1);
	}
}
