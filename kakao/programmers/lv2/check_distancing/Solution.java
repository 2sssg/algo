package kakao.programmers.lv2.check_distancing;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

class Solution {

	boolean check(String[] place, int x, int y) {
		Queue<Pair> q = new ArrayDeque<>();
		int[][] dist = new int[5][5];
		for (int i = 0; i < 5; ++i) Arrays.fill(dist[i], -1);

		q.add(new Pair(x, y));
		dist[x][y] = 0;

		while (!q.isEmpty()) {
			Pair cur = q.poll();
			for (int i = 0; i < 4; ++i) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if (chk(nx, ny, 5, 5)) continue;
				if (dist[nx][ny] >= 0) continue;
				if (place[nx].charAt(ny) == 'P') return false;
				if (place[nx].charAt(ny) == 'X') continue;
				if (dist[cur.x][cur.y] == 1) continue;
				dist[nx][ny] = dist[cur.x][cur.y] + 1;
				q.add(new Pair(nx, ny));
			}
		}
		return true;
	}

	public int[] solution(String[][] places) {
		int[] answer = new int[5];
		Arrays.fill(answer, 1);
		l: for (int i = 0; i < 5; ++i) {
			for (int x = 0; x < 5; ++x) {
				for (int y = 0; y < 5; ++y) {
					if (places[i][x].charAt(y) == 'P'){
						if (!check(places[i], x, y)) {
							answer[i] = 0;
							continue l;
						}
					}
				}
			}
		}
		return answer;
	}

	class Pair {
		int x,y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	int[] dx = {0, 1, 0, -1};
	int[] dy = {1, 0, -1, 0};
	boolean chk(int x, int y, int n, int m) {return x < 0 || y < 0 || x >= n || y >= m;}
}