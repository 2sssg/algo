package bfs;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2146 {
	static class Pair{
		int x; int y; int src; int dest;

		public Pair(int x, int y, int src, int dest) {
			this.x = x;
			this.y = y;
			this.src = src;
			this.dest = dest;
		}

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Pair{" +
				"x=" + x +
				", y=" + y +
				", src=" + src +
				", dest=" + dest +
				'}';
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int[][] arr,visit;
	static boolean[][][] visit2;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static Queue<Pair> q = new ArrayDeque<>();
	static Queue<Pair> q2 = new ArrayDeque<>();


	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visit = new int[N][N];

		for(int i=0; i<N; ++i)
			arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int groupNum = 0;
		for(int i=0; i<N; ++i){
			for(int j=0; j<N; ++j){
				if(arr[i][j]>0 && visit[i][j] == 0){
					groupNum++;
					q.add(new Pair(i,j));
					visit[i][j] = groupNum;
					while (!q.isEmpty()) {
						Pair p = q.poll();
						q2.add(new Pair(p.x,p.y,groupNum,0));
						int curX = p.x;
						int curY = p.y;
						for(int k=0; k<4; ++k){
							int nx = curX + dx[k];
							int ny = curY + dy[k];
							if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
							if(arr[nx][ny] == 1 && visit[nx][ny]==0){
								q.add(new Pair(nx,ny));
								visit[nx][ny] = groupNum;
							}
						}
					}
				}
			}
		}
		visit2 = new boolean[N][N][groupNum];

//		for(int i=0; i<N; ++i){
//			System.out.println(Arrays.toString(visit[i]));
//		}

		int ans = 0;
		l: while(!q2.isEmpty()){
			Pair p = q2.poll();
			int curX = p.x;
			int curY = p.y;
			for(int k=0; k<4; ++k){
				int nx = curX + dx[k];
				int ny = curY + dy[k];
				if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
				if(arr[nx][ny] == 1 && visit[nx][ny] != p.src){
					ans = p.dest;
					break l;
				}
				if(arr[nx][ny] == 0 && !visit2[nx][ny][p.src-1]){
					q2.add(new Pair(nx,ny,p.src,p.dest+1));
					visit2[nx][ny][p.src-1] = true;
				}
			}
		}

		System.out.println(ans);


	}
}
