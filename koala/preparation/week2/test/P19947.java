package koala.preparation.week2.test;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P19947 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int h,y;
	static int[] dp;
	static double o = 0.05, t = 0.2, f = 0.35;
	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		dp = new int[15];
		st = new StringTokenizer(br.readLine());
		h = Integer.parseInt(st.nextToken()); y = Integer.parseInt(st.nextToken());
		dp[1] = (int)(h+h*o);
		dp[3] = (int)(h+h*t);
		dp[5] = (int)(h+h*f);
		for(int i=2; i<11; ++i){
			dp[i] = Math.max(dp[i],(int)(dp[i-1]+dp[i-1]*o));
			if(i>3){
				if(i>5)
					dp[i] = Math.max(dp[i],(int)(dp[i-5]+dp[i-5]*f));
				dp[i] = Math.max(dp[i],(int)(dp[i-3]+dp[i-3]*t));
			}
		}
		System.out.println(dp[y]);
	}
}
