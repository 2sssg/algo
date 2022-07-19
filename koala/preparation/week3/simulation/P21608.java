package koala.preparation.week3.simulation;

import Constant.Source;
import java.util.Arrays;
import library.UsefulForAlgo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class P21608 {

	static class Pair implements Comparable<Pair> {

		int x, y, friend, empty;

		public Pair(int x, int y, int friend, int empty) {
			this.x = x;
			this.y = y;
			this.friend = friend;
			this.empty = empty;
		}

		@Override
		public int compareTo(Pair o) {
			if (this.friend != o.friend) {
				return o.friend - this.friend;
			}
			if (this.empty != o.empty) {
				return o.empty - this.empty;
			}
			if (this.x != o.x) {
				return this.x - o.x;
			}
			return this.y - o.y;
		}

		@Override
		public String toString() {
			return "Pair{" +
				"x=" + x +
				", y=" + y +
				", friend=" + friend +
				", empty=" + empty +
				'}';
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] favorStudent;
	static int n;
	static int[][] arr;
	static int[] seq;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};

	static void init() throws IOException {
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		favorStudent = new int[n * n + 1][4];
		seq = new int[n * n];
		for (int i = 0; i < n * n; ++i) {
			st = new StringTokenizer(br.readLine());
			int student = Integer.parseInt(st.nextToken());
			seq[i] = student;
			for (int j = 0; j < 4; ++j) {
				favorStudent[student][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	static void makeSeat(int s) {
		List<Pair> l = new ArrayList<>();
		for (int x = 0; x < n; ++x) {
			for (int y = 0; y < n; ++y) {
				if (arr[x][y] != 0) {
					continue;
				}
				int count = 0;
				int emptycount = 0;
				for (int k = 0; k < 4; ++k) {
					int nx = x + dx[k];
					int ny = y + dy[k];
					if (chk(nx, ny)) {
						continue;
					}
					if (arr[nx][ny] == 0) {
						emptycount++;
						continue;
					}
					for (int favor : favorStudent[s]) {
						if (arr[nx][ny] == favor) {
							count++;
							break;
						}
					}
				}
				l.add(new Pair(x, y, count, emptycount));
			}
		}
		Collections.sort(l);
		arr[l.get(0).x][l.get(0).y] = s;
	}

	static int score() {
		int answer = 0;
		for (int x = 0; x < n; ++x) {
			for (int y = 0; y < n; ++y) {
				int count = 0;
				for (int i = 0; i < 4; ++i) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					if (chk(nx, ny)) {
						continue;
					}
					for (int favor : favorStudent[arr[x][y]]) {
						if (arr[nx][ny] == favor) {
							count++;
							break;
						}
					}
				}
				double tempanswer = 0.1;
				for (int i = 0; i < count; ++i) {
					tempanswer *= 10;
				}
				answer += (int) tempanswer;
			}
		}
		return answer;
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		init();
		Arrays.stream(seq).forEach(P21608::makeSeat);
		System.out.println(score());
	}

	static boolean chk(int x, int y) {
		return x < 0 || y < 0 || x >= n || y >= n;
	}

}
