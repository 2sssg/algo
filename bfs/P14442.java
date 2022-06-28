package bfs;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class P14442 {
	static class Pair{
		int x; int y; int k;

		public Pair(int x, int y, int k) {
			this.x = x;
			this.y = y;
			this.k = k;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,M,K;
	static int[][] arr;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int[][][] visit;

	static boolean chk(int x, int y){
		return x<0 || y<0 || x>=N || y>=M;
	}

	static int bfs(){
		Queue<Pair> q = new ArrayDeque<>();
		q.add(new Pair(0,0,0));
		visit[0][0][0] = 0;

		while(!q.isEmpty()){
			Pair p = q.poll();
			int curX = p.x;
			int curY = p.y;
			int curK = p.k;
			if(curX == N-1 && curY == M-1){
				return visit[curX][curY][curK]+1;
			}
			for(int i=0; i<4; ++i){
				int nx = curX + dx[i];
				int ny = curY + dy[i];
				if(chk(nx,ny)) continue;
				if(arr[nx][ny] == 0 && visit[nx][ny][curK] == -1){
					q.add(new Pair(nx,ny,curK));
					visit[nx][ny][curK] = visit[curX][curY][curK]+1;
				}
				if(arr[nx][ny] == 1 && curK<K && visit[nx][ny][curK+1] == -1){
					q.add(new Pair(nx,ny,curK+1));
					visit[nx][ny][curK+1] = visit[curX][curY][curK]+1;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visit = new int[N][M][K+1];

		for(int i=0; i<N; ++i){
			arr[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
			for(int j=0; j<M; ++j){
				for(int k=0; k<=K; ++k){
					visit[i][j][k] = -1;
				}
			}
		}
//		for(int i=0; i<N; ++i){
//			System.out.println(Arrays.toString(arr[i]));
//		}
//
		System.out.println(bfs());

	}
}
