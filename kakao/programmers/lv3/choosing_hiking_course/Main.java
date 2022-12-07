package kakao.programmers.lv3.choosing_hiking_course;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		int n; int[][] paths; int[] gates; int[] summits; int[] result;

		n = 6;
		paths = new int[][]{{1, 2, 3}, {2, 3, 5}, {2, 4, 2}, {2, 5, 4}, {3, 4, 4}, {4, 5, 3}, {4, 6, 1}, {5, 6, 1}};
		gates = new int[]{1, 3};
		summits = new int[]{5};
		result = new int[]{5,3};



		System.out.println(Arrays.toString(result));
		System.out.println(Arrays.toString(new Solution().solution(n, paths, gates, summits)));

	}
}
