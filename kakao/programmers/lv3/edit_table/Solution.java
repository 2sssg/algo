package kakao.programmers.lv3.edit_table;

import java.util.Stack;
import java.util.StringTokenizer;

class Solution {
	StringTokenizer st;

	public String solution(int n, int k, String[] cmd) {
		int cursor = k + 1;
		int lastindex = n;
		Stack<Integer> lastDeleted = new Stack<>();
//		boolean[] answer = new boolean[n + 1];
//		Arrays.fill(answer, true);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i <= n; ++i) {
			sb.append("O");
		}

		for (String behavior: cmd) {
			st = new StringTokenizer(behavior);
			int move;
			switch (st.nextToken()) {
				case "D":
					move = Integer.parseInt(st.nextToken());
					while (move > 0) {
						cursor++;
						if (sb.charAt(cursor) == 'O') move--;
					}
					 break;
				case "U":
					move = Integer.parseInt(st.nextToken());
					while (move > 0) {
						cursor--;
						if (sb.charAt(cursor) == 'O') move--;
					}
					break;
				case "C":
					sb.setCharAt(cursor, 'X');
					lastDeleted.push(cursor);
					if (cursor == lastindex) {
						while (sb.charAt(--cursor) == 'X');
						lastindex = cursor;
					} else {
						while (sb.charAt(++cursor) == 'X');
					}
					break;
				case "Z":
					int last = lastDeleted.pop();
					sb.setCharAt(last, 'O');
					if (last > lastindex) lastindex = last;
					break;
			}
		}
		return sb.substring(1, sb.length());
	}
}
