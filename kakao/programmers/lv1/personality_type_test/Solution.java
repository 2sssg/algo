package kakao.programmers.lv1.personality_type_test;

class Solution {
	int R,T,C,F,J,M,A,N;

	void init() {
		R = T = C = F = J = M = A = N = 0;
	}

	private void updateScore(char type, int score) {
		switch (type) {
			case 'R':
				R += score;
				break;
			case 'T':
				T += score;
				break;
			case 'C':
				C += score;
				break;
			case 'F':
				F += score;
				break;
			case 'J':
				J += score;
				break;
			case 'M':
				M += score;
				break;
			case 'A':
				A += score;
				break;
			case 'N':
				N += score;
				break;
		}
	}

	public String solution(String[] survey, int[] choices) {
		init();
		int loopCount = survey.length;
		for (int i = 0; i < loopCount; ++i) {
			String item = survey[i];
			int choice = choices[i] - 4;
			if (choice == 0) continue;
			if (choice > 0) {
				updateScore(item.charAt(1), choice);
			} else {
				updateScore(item.charAt(0), -choice);
			}
		}

		StringBuilder sb = new StringBuilder();
		if (R >= T) sb.append("R");
		else sb.append("T");
		if (C >= F) sb.append("C");
		else sb.append("F");
		if (J >= M) sb.append("J");
		else sb.append("M");
		if (A >= N) sb.append("A");
		else sb.append("N");
		return sb.toString();
	}
}