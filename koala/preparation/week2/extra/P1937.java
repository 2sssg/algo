package koala.preparation.week2.extra;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1937 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] arr,dp;
	static int n,answer;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};

	static int dfs(int x, int y){
		for(int i=0; i<4; ++i){
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx<0 || ny<0 || nx>=n || ny>=n) continue;
			if(arr[nx][ny]<=arr[x][y]) continue;
			if(dp[nx][ny]!=-1) {
				dp[x][y] = Math.max(dp[nx][ny]+1, dp[x][y]);
				continue;
			}
			dp[x][y] = Math.max(dfs(nx,ny)+1,dp[x][y]);
		}
		if(dp[x][y] == -1){
			dp[x][y] = 0;
		}
		return dp[x][y];
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		dp = new int[n][n];
		for(int i=0; i<n; ++i){
			arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			Arrays.fill(dp[i],-1);
		}
		for(int i=0; i<n; ++i){
			for(int j=0; j<n; ++j){
				if(dp[i][j] == -1){
					dfs(i,j);
				}
			}
		}
		for(int i=0; i<n; ++i){
			for(int j=0; j<n; ++j){
				answer = Math.max(answer,dp[i][j]);
			}
		}
		System.out.println(answer+1);

	}
}
