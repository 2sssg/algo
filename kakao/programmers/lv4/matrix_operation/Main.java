package kakao.programmers.lv4.matrix_operation;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		int[][] rc;
		String[] operation;

		rc = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		operation = new String[]{"Rotate", "ShiftRow"};
		int[][] solution = new Solution().solution(rc, operation);
		System.out.println("\n\n");
		for(int[] sol: solution) {
			System.out.println(Arrays.toString(sol));
		}
	}
}
