package koala.preparation.week3.twopointer;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class P2842 {
	static class Pair{
		int x,y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static char[][] map;
	static int[][] height;
	static boolean[][] visit;
	static int n,answer,destcnt,smin,smax,tempcnt;
	static int[] dx = {-1,-1,-1,0,0,1,1,1};
	static int[] dy = {-1,0,1,-1,1,-1,0,1};
	static Set<Integer> heightset = new HashSet<>();
	static List<Integer> heightlist = new ArrayList<>();
	static Pair postoffice;

	static void init() throws IOException {
		n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		height = new int[n][n];
		visit = new boolean[n][n];
		for(int i=0; i<n; ++i) map[i] = br.readLine().toCharArray();
		destcnt = 0;
		answer = Integer.MAX_VALUE;
		for(int i=0; i<n; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; ++j){
				height[i][j] = Integer.parseInt(st.nextToken());
				heightset.add(height[i][j]);
				if(map[i][j]!='.'){
					if(map[i][j]=='K')  destcnt++;
					else postoffice = new Pair(i,j);
				}

			}
		}

		heightlist.addAll(heightset);
		Collections.sort(heightlist);
	}

	static void dfs(int x, int y){
		if (map[x][y]=='K') tempcnt++;
		for(int i=0; i<8; ++i){
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx<0 || ny<0 || nx>=n || ny>=n) continue;
			if(visit[nx][ny]) continue;
			if(height[nx][ny]<smin || height[nx][ny]>smax) continue;
			visit[nx][ny] = true;
			dfs(nx,ny);
		}
	}

	static void bs(){
		int end = 0;
		for(int start=0; start<heightlist.size(); ++start){
			smin = heightlist.get(start);
			while(end<heightlist.size()){
				smax = heightlist.get(end);
				if(smin>height[postoffice.x][postoffice.y]) break;
				if(smax<height[postoffice.x][postoffice.y]) {
					end++;
					continue;
				}
				for(int j=0; j<n; ++j){
					Arrays.fill(visit[j],false);
				}
				visit[postoffice.x][postoffice.y] = true;
				tempcnt = 0;
				dfs(postoffice.x,postoffice.y);
				if(tempcnt==destcnt) {
					answer = Math.min(answer,smax-smin);
					break;
				}
				end++;
			}
		}
	}


	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		init();
		bs();
		System.out.println(answer);
	}
}
