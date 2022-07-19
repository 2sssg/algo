package koala.preparation.week2.dp2;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P14430 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int r,c,answer;
	static int[][] arr=new int[305][305],dp=new int[305][305];
	static int[] dx = {0,1};
	static int[] dy = {1,0};


	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken()); c = Integer.parseInt(st.nextToken());
		for(int i=1; i<=r; ++i){
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=c; ++j){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i = 1; i <= r; i++){
			for(int j = 1; j <= c; j++){
				dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + arr[i][j]);
				dp[i][j] = Math.max(dp[i][j], dp[i][j - 1] + arr[i][j]);
				answer = Math.max(dp[i][j], answer);
			}
		}
		System.out.println(answer);
	}
}
