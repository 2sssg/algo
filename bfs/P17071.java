package bfs;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class P17071 {

	static class Pair {

		int x;
		int y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, K;
	static int[][] visit = new int[2][500005];
	static Queue<Pair> q = new ArrayDeque<>();

	static int f(int n) {
		return n * (n + 1) / 2;
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		q.clear();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		q.add(new Pair(N, 0));
		Arrays.fill(visit[0], -1);
		Arrays.fill(visit[1], -1);

		while (!q.isEmpty()) {
			Pair p = q.poll();
			int curX = p.x;
			int curY = p.y;
			if (curX < 0 || curX > 500000) {
				continue;
			}
			if (visit[curY & 1][curX] != -1) {
				continue;
			}
			visit[curY & 1][curX] = curY;
			if (curX + 1 < 500001) {
				q.add(new Pair(curX + 1, curY + 1));
			}
			if (curX - 1 >= 0) {
				q.add(new Pair(curX - 1, curY + 1));
			}
			if ((curX * 2 != 0 && curX * 2 <= 1000000)) {
				q.add(new Pair(curX * 2, curY + 1));
			}
		}
		for (int i = 0; i < 500000; i++) {
			int nk = K + f(i);
			if (nk > 500000) {
				break;
			}
			if (visit[i & 1][nk] != -1 && visit[i & 1][nk] <= i) {
				System.out.println(i);
				System.exit(0);
//				break;
			}
		}
		System.out.println("-1");
	}
}

// 5  6  8  11 15
// 17 16 15 14 15