package bfs;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1600 {
	static class Pair{
		int x; int y; int cnt;
		public Pair(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int K,N,M;
	static int[][] arr;
	static int[][][] dist;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int[] mdx = {1,1,2,2,-1,-1,-2,-2};
	static int[] mdy = {2,-2,1,-1,2,-2,1,-1};

	static boolean chk(int x, int y){
		return x<0 || y<0 || x>=N || y>=M;
	}

	static int bfs(){
		Queue<Pair> q = new ArrayDeque<>();
		q.add(new Pair(0,0,0));
		dist[0][0][0] = 0;
		while(!q.isEmpty()){
			Pair p = q.poll();
			int curX = p.x;
			int curY = p.y;
			int mcnt = p.cnt;
			if(curX==N-1 && curY == M-1){
				return dist[curX][curY][mcnt];
			}
			for(int i=0; i<4; ++i){
				int nx = curX+dx[i];
				int ny = curY+dy[i];
				if(chk(nx,ny)) continue;
				if(dist[nx][ny][mcnt] == -1 && arr[nx][ny] == 0){
					q.add(new Pair(nx,ny,mcnt));
					dist[nx][ny][mcnt] = dist[curX][curY][mcnt] + 1;
				}
			}
			if(mcnt<K){
				for(int i=0; i<8; ++i){
					int nx = curX+mdx[i];
					int ny = curY+mdy[i];
					if(chk(nx,ny)) continue;
					if(dist[nx][ny][mcnt+1] == -1 && arr[nx][ny] == 0){
						q.add(new Pair(nx,ny,mcnt+1));
						dist[nx][ny][mcnt+1] = dist[curX][curY][mcnt] + 1;
					}
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		dist = new int[N][M][K+1];
		for(int i=0; i<N; ++i){
			arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			for(int j=0; j<M; ++j){
				for(int k=0; k<=K; ++k){
					dist[i][j][k] = -1;
				}
			}
		}

		System.out.println(bfs());

	}
}
