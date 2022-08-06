package koala.preparation.week4.test;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P17130 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n,m;
	static char[][] arr;
	static int[][] dp;
	static int[] dx = {-1,0,1};
	static int[] dy = {-1,-1,-1};


	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new char[n][m];
		dp = new int[n][m];
		int rx=0,ry=0;
		for(int i=0; i<n; ++i) {
			String temp =br.readLine();
			for(int j=0; j<m; ++j){
				arr[i][j] = temp.charAt(j);
				if(arr[i][j] =='R'){
					rx=i; ry=j;
				}
			}
		}
//		for(char[] c: arr) System.out.println(Arrays.toString(c));
		for(int i=0; i<n; ++i){
			Arrays.fill(dp[i],-1);
		}
		dp[rx][ry] = 0;
		for(int j=ry+1; j<m; ++j){
			for(int i=0; i<n; ++i){
				if(arr[i][j] == '#') continue;
				for(int k=0; k<3; ++k){
					int nx = i+dx[k];
					int ny = j+dy[k];
					if(nx<0 || ny<0 || nx>=n || ny>=m) continue;
					if(dp[nx][ny]==-1) continue;
					dp[i][j] = Math.max(dp[i][j],dp[nx][ny]);
				}
				if(dp[i][j]!=-1 && arr[i][j]=='C'){
					dp[i][j]++;
				}
			}
		}
//		System.out.println();
//		for(int[] t: dp){
//			System.out.println(Arrays.toString(t));
//		}
		int answer = -1;
		for(int i=0; i<n; ++i){
			for(int j=0; j<m; ++j){
				if(arr[i][j] == 'O'){
					answer = Math.max(answer,dp[i][j]);
				}
			}
		}
		System.out.println(answer);


	}
}
