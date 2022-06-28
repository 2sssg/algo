package bfs;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1245 {
	static class Pair{
		int x; int y; int h;
		public Pair(int x, int y, int h) {
			this.x = x;
			this.y = y;
			this.h = h;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static Queue<Pair> q = new ArrayDeque<>();


	static int N,M;
	static int[][] arr;
	static int[] dx = {1,1,1,0,0,-1,-1,-1};
	static int[] dy = {-1,0,1,-1,1,-1,0,1};
	static boolean[][] visit;
	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visit = new boolean[N][M];
		for(int i=0; i<N; ++i){
			arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		int count = 0;
		for(int i=0; i<N; ++i){
			l: for(int j=0; j<M; ++j){
				if(arr[i][j] > 0 && !visit[i][j]){
					boolean flag = false;
					q.add(new Pair(i,j,arr[i][j]));
					visit[i][j] = true;
					while(!q.isEmpty()){
						Pair p = q.poll();
						int curX = p.x;
						int curY = p.y;
						int curH = p.h;
						for(int k=0; k<8; ++k){
							int nx = curX + dx[k];
							int ny = curY + dy[k];
							if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
							if(arr[nx][ny] > curH ) {
								flag = true;
							}
							if(arr[nx][ny] == curH && !visit[nx][ny]){
								q.add(new Pair(nx,ny,curH));
								visit[nx][ny] = true;
							}
						}
					}
					if(!flag){
						count++;
					}
				}
			}
		}
		System.out.println(count);

	}
}
