package extra;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P4095 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int n,m,answer;
	static int[][] arr;
	static int[][] dp;
	static boolean chk(int x, int y, int r, int c){return x<0 || y<0 || x>=r || y>=c;}
	static int[] dx = {-1,-1,0};
	static int[] dy = {0,-1,-1};
	static boolean init() throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		answer = 0;
		return n!=0 && m!=0;
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();

		while(init()){
			arr = new int[n][m];
			dp = new int[n][m];
			for(int i=0; i<n; ++i){
				arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}
			for(int i=0; i<n; ++i){
				for(int j=0; j<m; ++j){
					if(arr[i][j] == 0) continue;
					int min = Integer.MAX_VALUE;
					for(int k=0; k<3; ++k){
						int nx = i+dx[k];
						int ny = j+dy[k];
						if(chk(nx,ny,n,m)) {
							min = 0;
							continue;
						}
						min = Math.min(min, dp[nx][ny]);
					}
					min = min==Integer.MAX_VALUE?0:min;
					dp[i][j] = min+1;
					answer = Math.max(answer,dp[i][j]);
				}
			}
			bw.append(Integer.toString(answer)).append("\n");
		}
		bw.flush();
	}
}
