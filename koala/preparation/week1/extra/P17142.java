package koala.preparation.week1.extra;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class P17142 {
	static class Pair{
		int x,y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] arr;
	static int[][] visit;
	static int[] dx = {0,1,-1,0};
	static int[] dy = {1,0,0,-1};
	static Queue<Pair> q = new ArrayDeque<>();
	static int n,k,cx,cy,nx,ny,zc,answer;

	static void init() throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); k=Integer.parseInt(st.nextToken());
		arr = new int[n][n];
		visit = new int[n][n];
		answer = 0x7fffffff;
		for (int i = 0; i < n; ++i) Arrays.fill(visit[i],-1);
		zc = 0;
	}

	static int bfs(){
		int[][] tempvisit = new int[n][n];
		for(int i = 0; i<n; ++i){
			for(int j=0; j<n; ++j){
				tempvisit[i][j] = visit[i][j];
				if(tempvisit[i][j] == 0){
					q.add(new Pair(i,j));
				}
			}
		}
//		for(int[] t: tempvisit){
//			System.out.println(Arrays.toString(t));
//		}
//		System.out.println();
		int count = 0;
		int max = 0;
		while(!q.isEmpty()){
			Pair p = q.poll();
			cx = p.x;
			cy = p.y;
			if(arr[cx][cy]!=2){
				max = Math.max(max, tempvisit[cx][cy]);
			}
			count++;
			for(int i=0; i<4; ++i){
				nx = cx + dx[i];
				ny = cy + dy[i];
				if(nx<0 || ny<0 || nx>=n || ny>=n) continue;
				if(tempvisit[nx][ny]!=-1) continue;
				if(arr[nx][ny] == 1) continue;
				q.add(new Pair(nx,ny));
				tempvisit[nx][ny] = tempvisit[cx][cy]+1;
			}
		}
		return count==zc?max:-1;
	}

	static void f(int cur,int x, int y){
		if(cur == k){
			int tempans = bfs();
//			System.out.println(tempans);
//			System.out.println();
			if(tempans!=-1){
				answer = Math.min(tempans,answer);
			}
			return;
		}
		for(int i=x; i<n; ++i){
			for(int j=y; j<n; ++j){
//				System.out.printf("( %d , %d)%n",i,j);
				if(arr[i][j]==0 || arr[i][j]==1) continue;
				if(visit[i][j]==0) continue;
				visit[i][j] = 0;
				f(cur+1,i,j);
				visit[i][j] = -1;
			}
			y=0;
		}
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();

		init();
		for(int i=0; i<n; ++i){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; ++j){
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]!=1) zc++;
			}
		}
		f(0,0,0);
		System.out.println(answer==0x7fffffff?"-1":answer);
	}
}

