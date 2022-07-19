package koala.preparation.week2.dp2;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P5582 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String s1,s2;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader(false,false);
		s1 = br.readLine();
		s2 = br.readLine();
		int answer = 0;
		dp = new int[s1.length()+1][s2.length()+1];
		for(int i=1; i<s1.length()+1; ++i){
			for(int j=1; j<s2.length()+1; ++j){
				if(s1.charAt(i-1)==s2.charAt(j-1)){
					dp[i][j] = dp[i-1][j-1]+1;
					answer = Math.max(answer,dp[i][j]);
				}
			}
		}
		System.out.println(answer);
	}
}
