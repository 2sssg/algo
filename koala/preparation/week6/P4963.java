package koala.preparation.week6;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P4963 {
	static int n,m;
	static int[][] arr;
	static boolean[][] visit;
	static int answer;

	static boolean init() throws IOException {
		est(); m=rstn(); n=rstn();
		answer = 0;
		arr = new int[n][m];
		visit = new boolean[n][m];
		for(int i=0; i<n; ++i) arr[i] = ra();
		return !(n==0 && m==0);
	}

	static void dfs(int x, int y){
		for(int i=0; i<8; ++i){
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx<0 || ny<0 || nx>=n || ny>=m) continue;
			if(visit[nx][ny] ) continue;
			if(arr[nx][ny] == 0) continue;
			visit[nx][ny] = true;
			dfs(nx,ny);
		}
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		while(init()){
			for(int i=0; i<n; ++i){
				for(int j=0; j<m; ++j){
					if(arr[i][j]==0 || visit[i][j]) continue;
					answer++;
					dfs(i,j);
				}
			}
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() {return Integer.parseInt(st.nextToken());}
	static int[] ra() throws IOException {return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();}
	static int[] dx = {-1,-1,-1,0,0,1,1,1};
	static int[] dy = {-1,0,1,-1,1,-1,0,1};
}
