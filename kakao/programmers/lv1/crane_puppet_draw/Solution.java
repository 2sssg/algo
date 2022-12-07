package kakao.programmers.lv1.crane_puppet_draw;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
	Stack s = new Stack();
	List<Stack<Integer>> newBoard = new ArrayList<>();

	public int solution(int[][] board, int[] moves) {
		int n, m, answer = 0;
		n = board.length;
		m = board[0].length;
		for (int i = 0; i < m; ++i) newBoard.add(new Stack<>());
		for (int i = n - 1; i >= 0; --i)
			for (int j = m - 1; j >= 0; --j)
				if (board[i][j] != 0)
					newBoard.get(j).push(board[i][j]);

		for (int index : moves) {
			index--;
			if (newBoard.get(index).isEmpty()) continue;
			int item = newBoard.get(index).pop();
			if (s.isEmpty() || !s.peek().equals(item)) s.push(item);
			else {
				answer++;
				s.pop();
			}
		}
		return answer * 2;
	}
}
