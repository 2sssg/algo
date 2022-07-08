package koala.preparation.week1.extra;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2589 {
	static class Pair{
		int x,y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Pair{" +
				"x=" + x +
				", y=" + y +
				'}';
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n,m;
	static int[][] arr,d;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static Queue<Pair> q = new ArrayDeque<>();

	static int bfs(int x, int y){
		for(int k=0; k<n; ++k){
			Arrays.fill(d[k],-1);
		}
		q.add(new Pair(x,y));
		d[x][y] = 0;
		int max = 0;
		while(!q.isEmpty()){
			Pair p = q.poll();
			int curX = p.x;
			int curY = p.y;
			max = Math.max(max,d[curX][curY]);
			for(int i=0; i<4; ++i){
				int nx = curX+dx[i];
				int ny = curY+dy[i];
				if(nx<0 || ny<0 || nx>=n || ny>=m) continue;
				if(arr[nx][ny]!=0 || d[nx][ny]!=-1) continue;
				q.add(new Pair(nx,ny));
				d[nx][ny] = d[curX][curY]+1;
			}
		}
		return max;
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		d = new int[n][m];

		for(int i=0; i<n; ++i){
			arr[i] = Arrays.stream(br.readLine().split("")).mapToInt(p->p.equals("W")?1:0).toArray();
		}

		int max = 0;
		for(int i=0; i<n; ++i){
			for(int j=0; j<m; ++j){
				if(arr[i][j] == 0){
					max = Math.max(max,bfs(i,j));
				}
			}
		}
		System.out.println(max);
	}
}
