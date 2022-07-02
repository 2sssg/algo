package simulation;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P17281 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	// 이닝 수
	static int N,answer;
	static int[][] playerBoard;
	static boolean[] pick = new boolean[10];
	static int[] lineup = new int[10];





	static void f(int depth){
		if(depth == 10){
			startGame();
			return;
		}
		for(int i=1; i<10; ++i){
			if(pick[i]) continue;
			lineup[depth] = i;
			pick[i] = true;
			f(depth+1);
			pick[i] = false;
		}
	}

	public static void startGame() {
		int score = 0;
		int startPlayer = 1;
		boolean[] base;

		for (int i = 0; i <N; i++) {
			int outCnt = 0;
			base = new boolean[4];

			outer: while (true) {
				for (int j = startPlayer; j <= 9; j++) {
					int hitter = playerBoard[i][lineup[j]];

					switch (hitter) {
						case 0:
							outCnt++;
							break;
						case 1:
							for (int k = 3; k >= 1; k--) {
								if (base[k]) {
									if (k == 3) {
										score++;
										base[k] = false;
										continue;
									}

									base[k] = false;
									base[k + 1] = true;
								}
							}
							base[1] = true;
							break;
						case 2:
							for (int k = 3; k >= 1; k--) {
								if (base[k]) {
									if (k == 3 || k == 2) {
										score++;
										base[k] = false;
										continue;
									}

									base[k] = false;
									base[k + 2] = true;
								}
							}
							base[2] = true;
							break;
						case 3:
							for (int k = 3; k >= 1; k--) {
								if (base[k]) {
									score++;
									base[k] = false;
								}
							}

							base[3] = true;
							break;
						case 4:
							for (int k = 1; k <= 3; k++) {
								if (base[k]) {
									score++;
									base[k] = false;
								}
							}
							score++;
							break;
					}

					if (outCnt == 3) {
						startPlayer = j + 1;
						if (startPlayer == 10) {
							startPlayer = 1;
						}
						break outer;
					}
				}
				startPlayer = 1;
			}
		}

		answer = Math.max(answer, score);
	}



	public static void main(String[] args) throws IOException {

		answer = 0;
		br = Source.getBufferedReader();
		N = Integer.parseInt(br.readLine());
		playerBoard = new int[N][10];

		for(int i=0; i<N; ++i){
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<10; ++j){
				playerBoard[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		lineup[1] = 4;
		pick[4] = true;
		f(2);
		System.out.println(answer);

	}
}
