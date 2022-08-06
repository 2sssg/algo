package koala.preparation.week3.simulation;

import static library.UsefulForAlgo.*;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P23031 {

	static class Pair {

		int x, y, dir;

		public Pair(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}

		public void zombiemove() {
			int nx = this.x + dx[this.dir];
			if (nx < 0 || nx >= n) {
				this.dir = (this.dir + 2) % 4;
			} else {
				arr[this.x][this.y] = 'O';
				this.x = nx;
				arr[this.x][this.y] = 'Z';
			}
		}

		public void arriemove(char seq) {
			if (seq == 'F') {
				int nx = this.x + dx[dir];
				int ny = this.y + dy[dir];
				if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
					return;
				}
				this.x = nx;
				this.y = ny;
			} else if (seq == 'L') {
				this.dir++;
				if (this.dir == 4) {
					this.dir = 0;
				}
			} else if (seq == 'R') {
				this.dir--;
				if (this.dir == -1) {
					this.dir = 3;
				}
			}
		}

		@Override
		public String toString() {
			return "Pair{" +
				"x=" + x +
				", y=" + y +
				", dir=" + dir +
				'}';
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n;
	static String move;
	static int[][] isLight;
	static char[][] arr;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[] sx = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
	static int[] sy = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
	static Pair arrie;
	static List<Pair> zombie;
	static List<Pair> switches;

	static void init() throws IOException {
		n = Integer.parseInt(br.readLine());
		move = br.readLine();
		arr = new char[n][n];
		isLight = new int[n][n];
		zombie = new ArrayList<>();
		arrie = new Pair(0, 0, 0);
		for (int i = 0; i < n; ++i) {
			String temp = br.readLine();
			for (int j = 0; j < n; ++j) {
				arr[i][j] = temp.charAt(j);
				if (arr[i][j] == 'Z') {
					zombie.add(new Pair(i, j, 0));
				} else if (arr[i][j] == 'S') {
					isLight[i][j] = -1;
					arr[i][j] = 'O';
				}
			}
		}

	}

	static boolean movefunc() {
		for (int i = 0; i < move.length(); ++i) {
			arrie.arriemove(move.charAt(i));
			onSwitch();
			if (isMatching()) {
				return false;
			}
			zombie.forEach(Pair::zombiemove);
			if (isMatching()) {
				return false;
			}
		}
		return true;
	}

	static void onSwitch() {
		if (isLight[arrie.x][arrie.y] < 0) {
			for (int i = 0; i < 9; ++i) {
				int nx = arrie.x + sx[i];
				int ny = arrie.y + sy[i];
				if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
					continue;
				}
				if(isLight[nx][ny]<0){
					isLight[nx][ny] = -2;
				}else{
					isLight[nx][ny] = 1;
				}
			}
		}
	}

	static boolean isMatching() {
		if (arr[arrie.x][arrie.y] != 'Z') {
			return false;
		}
		if (isLight[arrie.x][arrie.y] != -1 && isLight[arrie.x][arrie.y] != 0) {
			return false;
		}
		return true;
	}


	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		init();
		System.out.println(movefunc() ? "Phew..." : "Aaaaaah!");
	}
}
