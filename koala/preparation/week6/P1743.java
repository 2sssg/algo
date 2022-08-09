package koala.preparation.week6;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P1743 {
	static int n,m,k,answer;
	static boolean[][] arr,visit;

	static int dfs(int x, int y){
		int ret = 1;
		visit[x][y] = true;
		for(int i=0; i<4; ++i){
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(chk(nx,ny,n,m)) continue;
			if(!arr[nx][ny] || visit[nx][ny]) continue;
			visit[nx][ny] = true;
			ret += dfs(nx,ny);
		}
		return ret;
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		est(); n=rstn(); m=rstn(); k=rstn();
		arr = new boolean[n][m];
		visit = new boolean[n][m];
		for(int i=0; i<k; ++i){
			est();arr[rstn()-1][rstn()-1] = true;
		}
		for(int i=0; i<n; ++i)for(int j=0; j<m; ++j)if(arr[i][j] && !visit[i][j]) answer = Math.max(answer,dfs(i,j));

		System.out.println(answer);
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() {return Integer.parseInt(st.nextToken());}
	static int[] ra() throws IOException {return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();}
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static boolean chk(int x, int y, int n, int m){return x<0 || y<0 || x>=n || y>=m;}
}
