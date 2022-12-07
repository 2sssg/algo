package kakao.programmers.lv1.press_keypad;

class Solution {

	StringBuilder sb = new StringBuilder();
	int left, right;

	void init() {
		sb.setLength(0);
		left = 10;
		right = 12;
	}

	public String solution(int[] numbers, String hand) {
		init();
		for (int num : numbers) {
			if (num == 1 || num == 4 || num == 7) {
				sb.append("L");
				left = num;
			}
			else if (num == 3 || num == 6 || num == 9) {
				right = num;
				sb.append("R");
			}
			else {
				int lx, rx, ly, ry, numx, numy;
				lx = (left - 1) / 3;
				ly = (left - 1) % 3;
				rx = (right - 1) / 3;
				ry = (right - 1) % 3;
				if (num == 0) num = 11;
				numx = (num - 1) / 3;
				numy = (num - 1) % 3;

				int leftdis = Math.abs(lx - numx) + Math.abs(ly - numy);
				int rightdis = Math.abs(rx - numx) + Math.abs(ry - numy);
				if (leftdis == rightdis) {
					if (hand.equals("right")) {
						right = num;
						sb.append("R");
					} else {
						left = num;
						sb.append("L");
					}
				} else if (leftdis > rightdis) {
					right = num;
					sb.append("R");
				} else {
					left = num;
					sb.append("L");
				}
			}
		}
		return sb.toString();
	}
}
