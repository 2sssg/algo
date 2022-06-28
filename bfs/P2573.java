package bfs;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2573 {
	static class Pair{
		int x;
		int y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N,M;
	static int[][] arr;
	static boolean[][] visit;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};

	static boolean bfs(){
		Queue<Pair> q = new ArrayDeque<>();
		visit = new boolean[N][M];
		boolean isSep = false;
		for(int i=1; i<N-1; ++i){
			for(int j=1; j<M-1; ++j){
				if(arr[i][j]>0 && !visit[i][j]){
					if(!isSep){
						isSep = true;
					}else{
						return true;
					}
					q.add(new Pair(i,j));
					visit[i][j] = true;
					while(!q.isEmpty()){
						Pair p = q.poll();
						int curX = p.x;
						int curY = p.y;
						for(int k=0; k<4; ++k){
							int nx = curX+dx[k];
							int ny = curY+dy[k];
							if(nx<=0 || ny<=0 || nx>=N-1 || ny>=M-1) continue;
							if(!visit[nx][ny] && arr[nx][ny]>0){
								q.add(new Pair(nx,ny));
								visit[nx][ny] = true;
							}
						}
					}
				}
			}
		}
		return false;
	}

	static int makeMap(){
		int[][] temp = new int[N][M];
		int iceCount = 0;
		for(int i=0; i<N; ++i){
			temp[i] = arr[i].clone();
		}
		for(int i=1; i<N-1; ++i){
			for(int j=1; j<M-1; ++j){
				if(arr[i][j] == 0) continue;
				int count = 0;
				for(int k=0; k<4; ++k){
					if(temp[i+dx[k]][j+dy[k]]==0){
						count++;
					}
				}
				arr[i][j] -= count;
				if(arr[i][j]<=0) arr[i][j] = 0;
				else iceCount++;
			}
		}
		return iceCount;
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		int maxcount = 0;
		for(int i=0; i<N; ++i){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; ++j){
				int h = Integer.parseInt(st.nextToken());
				arr[i][j] = h;
				maxcount = Math.max(maxcount,h);
			}
		}

		for(int i=1; i<Integer.MAX_VALUE; ++i){
			if(makeMap()==0){
				System.out.println(0);
				break;
			}
			if (bfs()) {
				System.out.println(i);
				break;
			}
		}


	}
}
