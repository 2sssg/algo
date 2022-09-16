package extra;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class P16234 {
	static int n,l,r;
	static int[][] arr;
	static int[][] visit;
	static int[] dic;
	static Queue<Pair> q;

	static void init() throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		arr = new int[n][n];
		visit = new int[n][n];
		dic = new int[n*n + 5];
		q = new ArrayDeque<>();
		for(int i=0; i<n; ++i)
			arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
	}


	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		init();
		int ans = 0;
		while(true){
//			System.out.println("----");
			for(int i=0; i<n; ++i)
				Arrays.fill(visit[i] ,-1);
			Arrays.fill(dic, 0);
			for(int i=0; i<n; ++i){
				for(int j=0; j<n; ++j){
					if(visit[i][j] == -1){
						int psum = 0;
						int area = 0;
						q.add(new Pair(i,j));
						visit[i][j] = i * n + j;
						while(!q.isEmpty()) {
							Pair p = q.poll();
							area++;
							psum += arr[p.x][p.y];
							for (int k = 0; k < 4; ++k) {
								int nx = p.x + dx[k];
								int ny = p.y + dy[k];
								if (chk(nx, ny, n, n))
									continue;
								if (chk2(p.x, p.y, nx, ny))
									continue;
								if (visit[nx][ny] != -1) continue;
								q.add(new Pair(nx, ny));
								visit[nx][ny] = visit[p.x][p.y];
							}
						}
						if(area != 1){
							for(int ii=0; ii<n; ++ii){
								for(int jj=0; jj<n; ++jj){
									if(visit[ii][jj] == i*n+j){
										dic[ii * n + jj] = psum/area;
									}
								}
							}
						}

					}
				}
			}
			boolean flag = false;
			for (int i=0; i<n; ++i)
			{
				for (int j=0; j<n; ++j)
				{
					if(visit[i][j] != -1 && dic[i * n + j] != 0)
					{
						flag = true;
						arr[i][j] = dic[i * n + j];
					}
				}
			}
//			for (int i = 0; i < n; ++i) {
//				System.out.println(Arrays.toString(arr[i]));
//			}
			if(!flag) break;
			ans++;
		}
		System.out.println(ans);
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
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
	static boolean chk(int x, int y, int n, int m){
		return (x<0 || y<0 || x>=n || y>=m);
	}
	static boolean chk2(int cx, int cy, int nx, int ny){
		int cpop = arr[cx][cy];
		int npop = arr[nx][ny];
		return (Math.abs(cpop - npop) < l || Math.abs(cpop - npop) > r);
	}
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};

}
