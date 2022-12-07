package kakao.programmers.lv4.matrix_operation;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {

	int r,c;
	Deque<Deque<Integer>> mid = new ArrayDeque<>();
	Deque<Integer> left = new ArrayDeque<>();
	Deque<Integer> right = new ArrayDeque<>();

	void shiftRow() {
		left.addFirst(left.pollLast());
		mid.addFirst(mid.pollLast());
		right.addFirst(right.pollLast());
	}

	void rotate() {
		mid.peekFirst().addFirst(left.pollFirst());
		right.addFirst(mid.peekFirst().pollLast());
		mid.peekLast().addLast(right.pollLast());
		left.addLast(mid.peekLast().pollFirst());
	}


	public int[][] solution(int[][] rc, String[] operations) {
		r = rc.length;
		c = rc[0].length;

		for (int i = 0; i < r; ++i) {
			left.add(rc[i][0]);
			mid.add(new ArrayDeque<>());
			for (int j = 1; j < c - 1; ++j) {
				mid.peekLast().add(rc[i][j]);
			}
			right.add(rc[i][c - 1]);
		}

		for(String op : operations) {
			if (op.equals("Rotate")) rotate();
			else shiftRow();
		}
		for (int i = 0; i < r; ++i) {
			rc[i][0] = left.pollFirst();
			for (int j = 1; j < c - 1; ++j) {
				rc[i][j] = mid.peekFirst().pollFirst();
			}
			mid.pollFirst();
			rc[i][c - 1] = right.pollFirst();
		}
		return rc;
	}
}