package bfs;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class P16920 {

	static class Pair {

		int x;
		int y;
		int n;
		int cnt;

		public Pair(int x, int y, int n, int cnt) {
			this.x = x;
			this.y = y;
			this.n = n;
			this.cnt = cnt;
		}

		public Pair(int x, int y, int n) {
			this.x = x;
			this.y = y;
			this.n = n;
		}

		@Override
		public String toString() {
			return "Pair{" +
				"x=" + x +
				", y=" + y +
				", n=" + n +
				'}';
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N, M, K;
	static int[][] arr;
	static int[][] visit;
	static int[] result;
	static int[] s;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static List<Pair>[] l;
	static Queue<Pair> q = new ArrayDeque<>();
	static Queue<Pair> q2 = new ArrayDeque<>();

	static void bfs() {

	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		q.clear();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		result = new int[K + 1];
		arr = new int[N][M];
		visit = new int[N][M];
		l = new ArrayList[K + 1];
		for (int i = 1; i <= K; ++i) {
			l[i] = new ArrayList<>();
		}

		for (int i = 0; i < N; ++i) {
			String temp = br.readLine();
			for (int j = 0; j < M; ++j) {
				if (temp.charAt(j) == '.') {
					arr[i][j] = 0;
				} else if (temp.charAt(j) == '#') {
					visit[i][j] = -1;
					arr[i][j] = -1;
				} else {
					visit[i][j] = temp.charAt(j) - '0';
					arr[i][j] = temp.charAt(j) - '0';
				}
			}
		}
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				if (arr[i][j] > 0) {
					l[arr[i][j]].add(new Pair(i, j, arr[i][j]));
				}
			}
		}
		for (int i = 1; i <= K; ++i) {
			for (Pair p : l[i]) {
				visit[p.x][p.y] = p.n;
				q.add(p);
			}
		}
		while (!q.isEmpty()) {
			Pair p = q.poll();
			int curN = p.n;
			q2.add(p);
			while (!q.isEmpty() && q.peek().n == curN) {
				q2.add(q.poll());
			}
			while (!q2.isEmpty()) {
				Pair p2 = q2.poll();
				int curX2 = p2.x;
				int curY2 = p2.y;
				int curN2 = p2.n;
				int curCNT2 = p2.cnt;
				for (int i = 0; i < 4; ++i) {
					int nx = curX2 + dx[i];
					int ny = curY2 + dy[i];
					if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
						continue;
					}
					if (arr[nx][ny] == 0 && visit[nx][ny] == 0) {
						q.add(new Pair(nx, ny, curN2));
						if (curCNT2 < s[curN2 - 1] - 1) {
							q2.add(new Pair(nx, ny, curN2, curCNT2 + 1));
						}
						visit[nx][ny] = curN2;
					}
				}
			}

		}

		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				if (visit[i][j] > 0) {
					result[visit[i][j]]++;
				}
			}
		}
		for (int i = 1; i <= K; ++i) {
			bw.write(String.valueOf(result[i]));
			bw.write(" ");
		}
		bw.flush();
//		bw.close();
	}
}
