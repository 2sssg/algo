package koala.preparation.week3.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P8972 {
	static class Node {
		int x;
		int y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int dx[] = {1, 1, 1, 0, 0, 0, -1, -1, -1};
	static int dy[] = {-1, 0, 1, -1, 0, 1, -1, 0, 1};

	static int R, C;
	static char[][] map;
	static ArrayList<Node> crazy;
	static Node arduino;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		crazy = new ArrayList<>();

		for (int i = 0; i < R; i++) {
			String input = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = input.charAt(j);

				if (map[i][j] == 'I') {
					arduino = new Node(i, j);
				}

				if (map[i][j] == 'R') {
					crazy.add(new Node(i, j));
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		String input = br.readLine();
		for (int i = 0; i < input.length(); i++) {
			int move = input.charAt(i) - '0';
			if (!moveI(move)) {
				System.out.println("kraj " + (i + 1));
				return;
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static boolean moveI(int move) {
		int newX = arduino.x + dx[move - 1];
		int newY = arduino.y + dy[move - 1];

		if (map[newX][newY] == 'R') return false;
		// 아두이노가 미친 아두이노칸으로 이동하면 바로 종료.

		if (map[newX][newY] == '.') {
			arduino = new Node(newX, newY);
		}

		int visit[][] = new int[R][C];
		ArrayList<Node> removeR = new ArrayList<>();
		// 미친 아두이노가 같은 칸에 있는지 확인하는 용도

		for (Node temp : crazy) {
			// 8가지 중 가장 가까운 방향 찾기
			int min = Integer.MAX_VALUE;
			int crazyX = 0;
			int crazyY = 0;

			for (int i = 0; i < 9; i++) {
				if (i == 4) continue; // 가만히 있는 상태는 넘김

				int moveX = temp.x + dx[i];
				int moveY = temp.y + dy[i];
				if (moveX < 0 || moveY < 0 || moveX >= R || moveY >= C) continue;

				// 종수와 가장 가까워 지는 칸이라면 값들을 다 바꿔줌
				if (min > Math.abs(arduino.x - moveX) + Math.abs(arduino.y - moveY)) {
					min = Math.abs(arduino.x - moveX) + Math.abs(arduino.y - moveY);
					crazyX = moveX;
					crazyY = moveY;
				}
			}

			// 리스트 내부 값도 수정
			temp.x = crazyX;
			temp.y = crazyY;

			visit[crazyX][crazyY] += 1;
			if (visit[crazyX][crazyY] >= 2) {
				removeR.add(new Node(crazyX, crazyY));
			}
		}

		// 같은 칸에 미친 아두이노가 있다면 다 없애기
		for (int i = 0; i < crazy.size(); i++) {
			// 미친 아두이노가 종수의 아두이노와 같은 칸에 있으면 종료
			if (crazy.get(i).x == arduino.x && crazy.get(i).y == arduino.y) return false;

			// 제거 목록과 일치한다면 제거
			for (int j = 0; j < removeR.size(); j++) {
				if (removeR.get(j).x == crazy.get(i).x && removeR.get(j).y == crazy.get(i).y) {
					crazy.remove(i);
					i--;
					break;
					// 제거 완료 했기 때문에 다시 앞쪽 for문에서 탐색.
				}
			}
		}

		draw();
		// 수정된 값을 바탕으로 다시 맵 그리기
		return true;
	}

	static void draw() {
		for (int i = 0; i < R; i++) {
			Arrays.fill(map[i], '.');
		}

		map[arduino.x][arduino.y] = 'I';
		for (Node temp : crazy) {
			map[temp.x][temp.y] = 'R';
		}
	}
}

