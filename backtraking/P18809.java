package backtraking;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class P18809 {

	static class Pair {

		int x;
		int y;
		int c;

		public Pair(int x, int y, int c) {
			this.x = x;
			this.y = y;
			this.c = c;
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
				", c=" + c +
				'}';
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int M;
	static int G;
	static int R;
	static int[][] arr;
	static List<Pair> able = new ArrayList<>();
	static boolean[] visitAble;
	static int[] green;
	static int[] red;
	static Queue<Pair> q = new ArrayDeque<>();
	static int[][][] visit;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int result = 0;


	static void fg(int cur, int idx) {
		if (cur == G) {
			fr(0, 0);
			return;
		}
		for (int i = idx; i < able.size(); ++i) {
			if (!visitAble[i]) {
				visitAble[i] = true;
				green[cur] = i;
				fg(cur + 1, i + 1);
				visitAble[i] = false;
			}
		}
	}

	static void fr(int cur, int idx) {
		if (cur == R) {
			result = Math.max(bfs(), result);
			return;
		}
		for (int i = idx; i < able.size(); ++i) {
			if (!visitAble[i]) {
				visitAble[i] = true;
				red[cur] = i;
				fr(cur + 1, i + 1);
				visitAble[i] = false;
			}
		}
	}

	static int bfs() {
		visit = new int[N][M][2];
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				visit[i][j][0] = -1;
				visit[i][j][1] = -1;
			}
		}
		for (int g : green) {
			Pair p = able.get(g);
			q.add(new Pair(p.x, p.y, 0));
			visit[p.x][p.y][0] = 0;
		}
		for (int r : red) {
			Pair p = able.get(r);
			q.add(new Pair(p.x, p.y, 1));
			visit[p.x][p.y][1] = 0;
		}

		int answer = 0;
		while (!q.isEmpty()) {
			Pair p = q.poll();
			int curX = p.x;
			int curY = p.y;
			int curC = p.c;
			if (visit[curX][curY][0] == -2) {
				continue;
			}
			if (visit[curX][curY][1] == -2) {
				continue;
			}
			int dist = visit[p.x][p.y][p.c];
			for (int i = 0; i < 4; ++i) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];
				if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
					continue;
				}
				if (arr[nx][ny] == 0 || visit[nx][ny][p.c] != -1 || (visit[nx][ny][p.c ^ 1] != -1
					&& visit[nx][ny][p.c ^ 1] != dist + 1)) {
					continue;
				}
				if (visit[nx][ny][p.c ^ 1] == dist + 1) {
					visit[nx][ny][p.c ^ 1] = -2;
					visit[nx][ny][p.c] = -2;

					answer++;
				} else {
					q.add(new Pair(nx, ny, curC));
					visit[nx][ny][curC] = dist + 1;
				}
			}
		}
		return answer;
	}

	public static void main(String[] args) throws IOException {
		able.clear();
		br = Source.getBufferedReader();
		result = 0;
		q.clear();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		green = new int[G];
		red = new int[R];
		arr = new int[N][M];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 2) {
					able.add(new Pair(i, j));
				}
			}
		}
		visitAble = new boolean[able.size()];
		fg(0, 0);
		System.out.println(result);

	}
}
