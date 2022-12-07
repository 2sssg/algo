package kakao.programmers.lv3.build_track;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
	public int solution(int[][] board) {
		PriorityQueue<Quad> pq = new PriorityQueue<>((Comparator.comparingInt(o -> o.z)));
		int n = board.length;
		int[][][] cost = new int[n][n][4];
		for (int i = 0; i < n; ++i)
			for (int j = 0; j < n; ++j)
				Arrays.fill(cost[i][j], Integer.MAX_VALUE);
		cost[0][0][0] = 0;
		cost[0][0][1] = 0;
		cost[0][0][2] = 0;
		cost[0][0][3] = 0;
		pq.add(new Quad(0,0,0, -1));
		while (!pq.isEmpty()) {
			Quad cur = pq.poll();
			if (cur.w > cost[cur.x][cur.y][Math.max(cur.z, 0)]) continue;
			for (int i = 0; i < 4; ++i) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				int nz = i;
				int nw = cur.z == -1 || cur.z == nz ? 100 : 600;
				if (chk(nx, ny, n, n)) continue;
				if (board[nx][ny] == 1) continue;
				if (cost[nx][ny][nz] < cur.w + nw) continue;
				pq.add(new Quad(cur.w + nw, nx, ny, nz));
				cost[nx][ny][nz] = cur.w + nw;
			}
		}
		return Arrays.stream(cost[n - 1][n - 1]).min().getAsInt();
	}

	static class Quad{

		@Override
		public String toString() {
			return "Quad{" +
					"w=" + w +
					", x=" + x +
					", y=" + y +
					", z=" + z +
					'}';
		}

		int w,x,y,z;public Quad(int w, int x, int y,int z) {this.w = w; this.x = x;this.y = y;this.z = z;}}
	int[] dx = {0,1,0,-1};
	int[] dy = {1,0,-1,0};
	boolean chk(int x, int y, int n, int m) {return x < 0 || y < 0 || x >= n || y >= m;}
}